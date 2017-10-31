package com.hisign.xingzhen.xz.service.impl;

import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseMapper;
import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bif.BaseServiceImpl;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.bmodel.UpdateParams;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.constant.Constants;
import com.hisign.xingzhen.common.util.IpUtil;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.entity.GroupBackup;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.GroupBackupModel;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.service.GroupBackupService;
import com.hisign.xingzhen.xz.mapper.GroupBackupMapper;
import com.hisign.xingzhen.xz.mapper.GroupMapper;
import com.hisign.xingzhen.xz.mapper.XzLogMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 《专案组归档记录》 业务逻辑服务类
 *
 * @author 何建辉
 */
@Service("groupBackupService")
public class GroupBackupServiceImpl extends BaseServiceImpl<GroupBackup, GroupBackupModel, String> implements GroupBackupService {

    @Autowired
    protected GroupBackupMapper groupBackupMapper;

    @Autowired
    private XzLogMapper xzLogMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Override
    protected BaseMapper<GroupBackup, GroupBackupModel, String> initMapper() {
        return groupBackupMapper;
    }

    @Override
    public JsonResult add(GroupBackup entity) throws BusinessException {
        return addNotNull(entity);
    }

    @Override
    public JsonResult addNotNull(GroupBackup entity) throws BusinessException {
        entity.setId(UUID.randomUUID().toString());
        entity.setCreatetime(new Date());
        entity.setBackupTime(new Date());
        entity.setDeleteflag(Constants.DELETE_FALSE);
        long i = groupBackupMapper.insertNotNull(entity);
        if (i<1){
            return error(BaseEnum.BusinessExceptionEnum.INSERT.Msg());
        }
        //同时更新专案组
        GroupModel gm = groupMapper.findById(entity.getGroupid());
        if (gm==null){
            return error("对不起，该专案组不存在!");
        }
        Group group = new Group();
        BeanUtils.copyProperties(gm,group);
        group.setBackupTime(new Date());
        group.setBackupStatu(Constants.YES);
        group.setBackupReason(entity.getBackupReason());
        group.setLastupdatetime(new Date());

        long num = groupMapper.update(group);

        //更新小组信息-子小组全部归档
        UpdateParams updateParams = new UpdateParams(Group.class);

        Conditions conditions = new Conditions(Group.class);
        Conditions.Criteria criteria = conditions.createCriteria();
        criteria.add(Group.GroupEnum.pgroupid.get(), BaseEnum.ConditionEnum.EQ,gm.getId())
        .add(Group.GroupEnum.deleteflag.get(), BaseEnum.ConditionEnum.EQ,Constants.DELETE_FALSE);
        updateParams.add(new String[]{Group.GroupEnum.backupTime.get(),Group.GroupEnum.backupReason.get(),Group.GroupEnum.backupStatu.get(),Group.GroupEnum.lastupdatetime.get()}
        ,new Object[]{group.getBackupTime(),group.getBackupReason(),group.getBackupStatu(),group.getLastupdatetime()});

        updateParams.setConditions(conditions);

        groupMapper.updateCustom(updateParams);

        if (num<1){
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT);
        }

        try {
            if (i==1){
                //保存操作日志
                XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.GROUP, "专案组归档(ID:" + entity.getId()+")", entity.getCreator(), entity.getCreatetime(), entity.getId());
                xzLogMapper.insertNotNull(xzLog);
            }
        } catch (Exception e) {

        }

        return success();
    }

    @Override
    @Transactional
    public JsonResult add(List<GroupBackup> list) throws BusinessException {
        try {
            groupBackupMapper.batchInsert(list);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult update(UpdateParams params) throws BusinessException {
        try {
            groupBackupMapper.updateCustom(params);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult delByIds(List<String> ids) throws BusinessException {
        try {
            groupBackupMapper.deleteByIds(ids);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult delBy(Conditions conditions) throws BusinessException {
        try {
            groupBackupMapper.deleteCustom(conditions);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    public JsonResult remove(GroupBackup entity) throws BusinessException {
        //同时更新专案组
        GroupModel gm = groupMapper.findById(entity.getGroupid());
        if (gm==null){
            return error("对不起，该专案组不存在!");
        }
        Group group = new Group();
        BeanUtils.copyProperties(gm,group);
        group.setBackupTime(new Date());
        group.setBackupStatu(Constants.NO);
        group.setBackupReason(entity.getBackupReason());
        group.setLastupdatetime(new Date());

        long num = groupMapper.update(group);

        //更新小组信息-子小组全部撤销归档
        UpdateParams updateParams = new UpdateParams(Group.class);

        Conditions conditions = new Conditions(Group.class);
        Conditions.Criteria criteria = conditions.createCriteria();
        criteria.add(Group.GroupEnum.pgroupid.get(), BaseEnum.ConditionEnum.EQ,gm.getId())
                .add(Group.GroupEnum.deleteflag.get(), BaseEnum.ConditionEnum.EQ,Constants.DELETE_FALSE);
        updateParams.add(new String[]{Group.GroupEnum.backupTime.get(),Group.GroupEnum.backupReason.get(),Group.GroupEnum.backupStatu.get(),Group.GroupEnum.lastupdatetime.get()}
                ,new Object[]{group.getBackupTime(),group.getBackupReason(),group.getBackupStatu(),group.getLastupdatetime()});
        updateParams.setConditions(conditions);

        groupMapper.updateCustom(updateParams);

        if (num<1){
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT);
        }

        try {
            //保存操作日志
            XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.GROUP, "专案组撤销归档(ID:" + entity.getId()+")", entity.getCreator(), entity.getCreatetime(), entity.getId());
            xzLogMapper.insertNotNull(xzLog);
        } catch (Exception e) {

        }

        return success();
    }

}