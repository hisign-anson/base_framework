package com.hisign.xingzhen.xz.service.impl;

import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.constant.Constants;
import com.hisign.xingzhen.xz.api.entity.Ajgroup;
import com.hisign.xingzhen.xz.api.entity.AsjAj;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.service.IndexService;
import com.hisign.xingzhen.xz.mapper.AjgroupMapper;
import com.hisign.xingzhen.xz.mapper.AsjAjMapper;
import com.hisign.xingzhen.xz.mapper.GroupMapper;
import com.hisign.xingzhen.xz.mapper.TaskFkMapper;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* 《催办记录》 业务逻辑服务类
* @author 何建辉
*
*/
@Service("indexService")
public class IndexServiceImpl implements IndexService{

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private AsjAjMapper asjAjMapper;

    @Autowired
    private AjgroupMapper ajgroupMapper;

    @Autowired
    private TaskFkMapper taskFkMapper;

    @Override
    public JsonResult getAchievementList() {
        //获取最新归档专案组
        Conditions conditions = new Conditions(Group.class);
        Conditions.Criteria criteria = conditions.createCriteria();
        criteria.add(Group.GroupEnum.backupStatu.get(), BaseEnum.ConditionEnum.EQ, Constants.YES)
                .add(Group.GroupEnum.deleteflag.get(), BaseEnum.ConditionEnum.EQ, Constants.DELETE_FALSE);
        conditions.setOrderByClause(Group.GroupEnum.backupTime.get(), BaseEnum.DESCEnum.DESC);

        List<GroupModel> list = groupMapper.findList(conditions);
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();

        for (GroupModel model : list) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("time",model.getBackupTime());
            map.put("id",model.getId());
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

        return JsonResultUtil.success(listMap);
    }

    @Override
    public JsonResult getGroupCaseInfo(String backupStatus) {
        Map<String, Long> map = groupMapper.findGroupCaseInfo(backupStatus);
        return JsonResultUtil.success(map);
    }

    @Override
    public Long getNotConfirmCountByCreator(String creator) {
        return taskFkMapper.findNotConfirmCountByCreator(creator);
    }

}