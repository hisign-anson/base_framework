package com.hisign.framework.xz.service.impl;

import com.hisign.framework.common.constant.Constants;
import com.hisign.framework.common.util.SerialNumGenerater;
import com.hisign.framework.xz.api.entity.Ajgroup;
import com.hisign.framework.xz.api.entity.AsjAj;
import com.hisign.framework.xz.api.entity.Usergroup;
import com.hisign.framework.xz.api.model.GroupModel;
import com.hisign.framework.xz.mapper.AjgroupMapper;
import com.hisign.framework.xz.mapper.AsjAjMapper;
import com.hisign.framework.xz.mapper.GroupMapper;
import com.hisign.framework.xz.api.entity.Group;
import com.hisign.framework.xz.api.service.GroupService;

import java.util.*;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bif.*;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.*;


/**
 * 《专案组》 业务逻辑服务类
 *
 * @author 何建辉
 */
@Service("groupService")
public class GroupServiceImpl extends BaseServiceImpl<Group, GroupModel, String> implements GroupService {

    @Autowired
    protected GroupMapper groupMapper;

    @Autowired
    private AjgroupMapper ajgroupMapper;

    @Autowired
    private AsjAjMapper asjAjMapper;

    @Override
    protected BaseMapper<Group, GroupModel, String> initMapper() {
        return groupMapper;
    }


    @Override
    public JsonResult add(Group entity) throws BusinessException {
        entity.setId(UUID.randomUUID().toString());
        entity.setCreatetime(new Date());
        entity.setDeleteflag(Constants.DELETE_FALSE);
        entity.setLastupdatetime(new Date());
        return super.add(entity);
    }

    @Override
    @Transactional
    public JsonResult add(List<Group> list) throws BusinessException {
        try {
            groupMapper.batchInsert(list);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult update(UpdateParams params) throws BusinessException {
        try {
            groupMapper.updateCustom(params);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult delByIds(List<String> ids) throws BusinessException {
        try {
            groupMapper.deleteByIds(ids);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult delBy(Conditions conditions) throws BusinessException {
        try {
            groupMapper.deleteCustom(conditions);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    private String createGroupNo() {
        String maxNo = groupMapper.getMaxNo();
        String nextNumber = SerialNumGenerater.getInstance().getNextNumber(maxNo, 4);
        return "ZAZ" + nextNumber;
    }

    @Override
    public JsonResult getGroupPage(Group group) {
        List<GroupModel> list = groupMapper.getGroupByCondition(group);
        long count = groupMapper.getCountGroupByCondition(group);
        return JsonResultUtil.success(count, list);
    }

    public JsonResult getAchievementList() {
        //获取最新归档专案组
        Conditions conditions = new Conditions(Group.class);
        Conditions.Criteria criteria = conditions.createCriteria();
        criteria.add(Group.GroupEnum.backupStatu.get(), BaseEnum.ConditionEnum.EQ, Constants.YES)
                .add(Group.GroupEnum.deleteflag.get(), BaseEnum.ConditionEnum.EQ, Constants.DELETE_FALSE);
        conditions.setOrderByClause(Group.GroupEnum.backupTime.get(), BaseEnum.DESCEnum.DESC);

        List<GroupModel> list = groupMapper.findList(conditions);
        List<Map<String, Object>> listMap = new ArrayList<>();

        for (GroupModel model : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("time",model.getBackupTime());
            //获取最早关联案件
            AsjAj aj = asjAjMapper.findFirstCaseByGroupId(model.getId());
            if (aj==null){
                //使用专案组名称
                map.put("name",model.getGroupname()+"告破");
            }else {
                //获取专案组关联案件数量
                Conditions conditions1 = new Conditions(Ajgroup.class);
                Conditions.Criteria criteria1 = conditions1.createCriteria();
                criteria1.add(Ajgroup.AjgroupEnum.groupid.get(), BaseEnum.ConditionEnum.EQ, model.getId())
                        .add(Ajgroup.AjgroupEnum.deleteflag.get(), BaseEnum.ConditionEnum.EQ, Constants.DELETE_FALSE);

                Long count = ajgroupMapper.findCount(conditions);

                if (count == 1) {
                    map.put("name",aj.getAjmc()+"告破");
                } else if (count > 1) {
                    map.put("name",aj.getAjmc()+"系列案告破");
                } else {
                    map.put("name",model.getGroupname()+"告破");
                }
            }
            listMap.add(map);
        }

        return JsonResultUtil.success(null);
    }
}