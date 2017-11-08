package com.hisign.xingzhen.xz.service.impl;

import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.constant.Constants;
import com.hisign.xingzhen.common.util.DateUtil;
import com.hisign.xingzhen.xz.api.entity.Ajgroup;
import com.hisign.xingzhen.xz.api.entity.AsjAj;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.entity.GroupBackup;
import com.hisign.xingzhen.xz.api.model.AsjAjModel;
import com.hisign.xingzhen.xz.api.model.GroupBackupModel;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.service.GroupBackupService;
import com.hisign.xingzhen.xz.api.service.IndexService;
import com.hisign.xingzhen.xz.mapper.*;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * 《催办记录》 业务逻辑服务类
 *
 * @author 何建辉
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService {

    Logger log = LoggerFactory.getLogger(IndexServiceImpl.class);

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private GroupBackupMapper groupBackupMapper;

    @Autowired
    private AsjAjMapper asjAjMapper;

    @Autowired
    private AjgroupMapper ajgroupMapper;

    @Autowired
    private TaskFkMapper taskFkMapper;

    @Override
    public JsonResult getAchievementList(GroupBackup gb) {
        //获取最新归档专案组
        Conditions conditions = new Conditions(Group.class);
        Conditions.Criteria criteria = conditions.createCriteria();
        criteria.add(Group.GroupEnum.backupStatu.get(), BaseEnum.ConditionEnum.EQ, Constants.YES)
                .add(Group.GroupEnum.pgroupid.get(), BaseEnum.IsNullEnum.ISNULL)
                .add(Group.GroupEnum.deleteflag.get(), BaseEnum.ConditionEnum.EQ, Constants.DELETE_FALSE);
        conditions.setOrderByClause(Group.GroupEnum.backupTime.get(), BaseEnum.DESCEnum.DESC);

        conditions.setLimit(gb.getBegin(),gb.getEnd());

        List<GroupModel> list = groupMapper.findList(conditions);
        Long num = groupMapper.findCount(conditions);
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();

        for (GroupModel model : list) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("backupTime", model.getBackupTime());
            map.put("groupId", model.getId());
            map.put("groupNum", model.getGroupnum());
            map.put("groupName", model.getGroupname());
            map.put("rownum", model.getRownum());

            //获取最新归档记录
            GroupBackup groupBackup = new GroupBackup();
            groupBackup.setGroupid(model.getPgroupid());
            groupBackup.setDeleteflag(Constants.DELETE_FALSE);
            groupBackup.setOrderBy(GroupBackup.GroupBackupEnum.backupTime.get());
            groupBackup.setDesc(true);

            GroupBackupModel groupBackupModel = groupBackupMapper.findBackUpInfoByEntity(groupBackup);
            map.put("departmentName", groupBackupModel.getDeparmentName());
            map.put("backupPerson", groupBackupModel.getCreatorName());
            map.put("backupReson", groupBackupModel.getBackupReasonContent());

            try {
                map.put("createTime", DateUtil.getDateTime(model.getCreatetime()));
            } catch (Exception e) {
                e.printStackTrace();
                map.put("createTime", "");
            }

            //获取最早关联案件
            AsjAjModel aj = asjAjMapper.findFirstCaseByGroupId(model.getId());
            if (aj == null) {
                //使用专案组名称
                map.put("name", model.getGroupname() + "告破");
            } else {
                //获取专案组关联案件数量
                Conditions conditions1 = new Conditions(Ajgroup.class);
                Conditions.Criteria criteria1 = conditions1.createCriteria();
                criteria1.add(Ajgroup.AjgroupEnum.groupid.get(), BaseEnum.ConditionEnum.EQ, model.getId())
                        .add(Ajgroup.AjgroupEnum.deleteflag.get(), BaseEnum.ConditionEnum.EQ, Constants.DELETE_FALSE);

                Long count = ajgroupMapper.findCount(conditions1);

                if (count == 1) {
                    map.put("name", aj.getAjmc() + "告破");
                } else if (count > 1) {
                    map.put("name", aj.getAjmc() + "系列案告破");
                } else {
                    map.put("name", model.getGroupname() + "告破");
                }
            }
            listMap.add(map);
        }

        return JsonResultUtil.success(num,listMap);
    }

    @Override
    public JsonResult getGroupCaseInfo(Date[] dateSection, String backupStatus) {
        List<Map<String, Long>> map = null;
        try {
            map = groupMapper.findGroupCaseInfo(DateUtil.getDateTime(dateSection[0]), DateUtil.getDateTime(dateSection[1]), backupStatus);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return JsonResultUtil.error("对不起，时间参数格式错误");
        }
        if (map == null) {
            map = new ArrayList<>();
        }
        return JsonResultUtil.success(map);
    }

    @Override
    public Long getNotConfirmCountByCreator(String creator) {
        return taskFkMapper.findNotConfirmCountByCreator(creator);
    }

}