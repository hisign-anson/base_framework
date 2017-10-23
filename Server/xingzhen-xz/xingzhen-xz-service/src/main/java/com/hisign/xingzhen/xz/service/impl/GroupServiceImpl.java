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
import com.hisign.xingzhen.common.util.SerialNumGenerater;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.service.GroupService;
import com.hisign.xingzhen.xz.mapper.AjgroupMapper;
import com.hisign.xingzhen.xz.mapper.AsjAjMapper;
import com.hisign.xingzhen.xz.mapper.GroupMapper;
import com.hisign.xingzhen.xz.mapper.XzLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


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

    @Autowired
    private XzLogMapper xzLogMapper;

    @Override
    protected BaseMapper<Group, GroupModel, String> initMapper() {
        return groupMapper;
    }


    @Override
    public JsonResult add(Group entity) throws BusinessException {
        return addNotNull(entity);
    }

    @Override
    public JsonResult addNotNull(Group entity) throws BusinessException {
        //获取父专案组
        Group pgroup = new Group();
        pgroup.setPgroupid(entity.getPgroupid());
        GroupModel pgroupModel = getByEntity(pgroup);

        //如果为空或者父专案组有父id
        if (pgroupModel==null || StringUtils.isEmpty(pgroupModel.getPgroupid())){
            return error(BaseEnum.BusinessExceptionEnum.PARAMSEXCEPTION.Msg());
        }

        //保存专案组
        entity.setId(UUID.randomUUID().toString());
        entity.setCreatetime(new Date());
        entity.setDeleteflag(Constants.DELETE_FALSE);
        entity.setLastupdatetime(new Date());
        JsonResult result = super.addNotNull(entity);

        try {
            if (result.getFlag()==1){
                String content = "专案组新增(ID:"+entity.getId()+")";
                if (StringUtils.isNotBlank(entity.getPgroupid())){
                    content = content.replace("新增","组内建组");
                }
                //保存操作日志
                XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.GROUP.toString(),content , entity.getCreator(), entity.getCreatetime(), entity.getId());
                xzLogMapper.insertNotNull(xzLog);
            }
        } catch (Exception e) {

        }

        return result;
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

    private String createGroupNo(String orgId) {
        String maxNo = groupMapper.findMaxNo();
        String nextNumber = SerialNumGenerater.getInstance().getNextNumber(orgId,maxNo, 4);
        return "ZAZ" + nextNumber;
    }

    @Override
    public JsonResult getGroupPage(Group group) {
        //获取父专案组
        List<GroupModel> list = groupMapper.findGroupByCondition(group);
        long count = groupMapper.findCountGroupByCondition(group);
        return JsonResultUtil.success(count, list);
    }

}