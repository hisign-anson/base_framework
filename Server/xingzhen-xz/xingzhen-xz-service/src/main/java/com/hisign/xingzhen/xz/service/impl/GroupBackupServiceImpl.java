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
import com.hisign.xingzhen.xz.api.param.GroupBackupParam;
import com.hisign.xingzhen.xz.api.service.GroupBackupService;
import com.hisign.xingzhen.xz.mapper.GroupBackupMapper;
import com.hisign.xingzhen.xz.mapper.GroupMapper;
import com.hisign.xingzhen.xz.mapper.XzLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
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

    private Logger log = LoggerFactory.getLogger(GroupBackupServiceImpl.class);

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
        return super.addNotNull(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult add(List<GroupBackup> list) throws BusinessException {
        try {
            groupBackupMapper.batchInsert(list);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult update(UpdateParams params) throws BusinessException {
        try {
            groupBackupMapper.updateCustom(params);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult delByIds(List<String> ids) throws BusinessException {
        try {
            groupBackupMapper.deleteByIds(ids);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult delBy(Conditions conditions) throws BusinessException {
        try {
            groupBackupMapper.deleteCustom(conditions);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor=BusinessException.class)
    public JsonResult backup(GroupBackupParam param) throws BusinessException {

        //判断是否归档
        GroupBackup entity = new GroupBackup();
        String backupLogMsg = "撤销归档";
        if (param.getBackupStatus().equals(Constants.YES)){
            BeanUtils.copyProperties(param,entity);
            entity.setId(UUID.randomUUID().toString());
            entity.setCreatetime(new Date());
            entity.setBackupTime(new Date());
            entity.setDeleteflag(Constants.DELETE_FALSE);
            long i = groupBackupMapper.insertNotNull(entity);
            if (i<1){
                return error(BaseEnum.BusinessExceptionEnum.INSERT.Msg());
            }
            backupLogMsg = "归档";
        }else {
            param.setBackupStatus(Constants.NO);
        }

        //同时更新专案组
        GroupModel gm = groupMapper.findById(param.getGroupid());
        if (gm==null){
            return error("对不起，该专案组不存在!");
        }
        Group group = new Group();
        BeanUtils.copyProperties(gm,group);
        group.setBackupTime(new Date());
        group.setBackupStatu(param.getBackupStatus());
        group.setBackupReason(param.getBackupReason());
        group.setLastupdatetime(new Date());

        long num = groupMapper.updateNotNull(group);

        //更新小组信息-子小组全部与父专案组一致
        UpdateParams updateParams = new UpdateParams(Group.class);

        Conditions conditions = new Conditions(Group.class);
        Conditions.Criteria criteria = conditions.createCriteria();
        criteria.add(Group.GroupEnum.pgroupid.get(), BaseEnum.ConditionEnum.EQ,gm.getId())
                .add(Group.GroupEnum.deleteflag.get(), BaseEnum.ConditionEnum.EQ,Constants.DELETE_FALSE);
        updateParams.add(new String[]{Group.GroupEnum.backupTime.get(),Group.GroupEnum.backupStatu.get(),Group.GroupEnum.lastupdatetime.get()}
                ,new Object[]{group.getBackupTime(),param.getBackupStatus(),group.getLastupdatetime()});
        updateParams.setConditions(conditions);

        groupMapper.updateCustom(updateParams);

        if (num<1){
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT);
        }

        try {
            //保存操作日志
            XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.GROUP, "专案组"+backupLogMsg+"(ID:" + entity.getId()+")", entity.getCreator(), entity.getCreatetime(), gm.getId());
            xzLogMapper.insertNotNull(xzLog);
        } catch (Exception e) {
            log.info("保存操作日志失败:",e);
        }
        return success();
    }

}