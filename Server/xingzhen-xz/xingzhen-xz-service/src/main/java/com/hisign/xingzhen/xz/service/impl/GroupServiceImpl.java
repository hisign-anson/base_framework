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
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.entity.Usergroup;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.model.UsergroupModel;
import com.hisign.xingzhen.xz.api.param.GroupParam;
import com.hisign.xingzhen.xz.api.service.GroupService;
import com.hisign.xingzhen.xz.mapper.GroupMapper;
import com.hisign.xingzhen.xz.mapper.UsergroupMapper;
import com.hisign.xingzhen.xz.mapper.XzLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
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
    private XzLogMapper xzLogMapper;

    @Autowired
    private UsergroupMapper usergroupMapper;

    Logger log = LoggerFactory.getLogger(GroupServiceImpl.class);

    @Override
    protected BaseMapper<Group, GroupModel, String> initMapper() {
        return groupMapper;
    }


    @Override
    public JsonResult add(Group entity) throws BusinessException {
        return addNotNull(entity);
    }

    @Override
    @Transactional
    public JsonResult addNotNull(Group entity) throws BusinessException {
        if (!StringUtils.isEmpty(entity.getPgroupid())){
            //获取父专案组
            Group pgroup = new Group();
            pgroup.setPgroupid(entity.getPgroupid());
            GroupModel pgroupModel = getByEntity(pgroup);
            if(pgroupModel==null) {
                return error(BaseEnum.BusinessExceptionEnum.PARAMSEXCEPTION.Msg());
            }
        }
        Date now=new Date();
        //保存专案组
        entity.setId(UUID.randomUUID().toString());
        entity.setGroupnum(createGroupNum(entity.getDeparmentcode()));
        entity.setCreatetime(now);
        entity.setLastupdatetime(now);
        entity.setDeleteflag(Constants.DELETE_FALSE);
        JsonResult result = super.addNotNull(entity);

        //把创建人添加到关联人员
        Usergroup usergroup = new Usergroup();
        usergroup.setId(UUID.randomUUID().toString());
        usergroup.setCreatetime(new Date());
        usergroup.setCreator(entity.getCreator());
        usergroup.setGroupid(entity.getId());
        usergroup.setDeleteflag(Constants.DELETE_FALSE);
        usergroup.setDeparmentcode(entity.getDeparmentcode());
        usergroup.setUserid(entity.getCreator());
        usergroup.setJh(entity.getPoliceId());

        long num = usergroupMapper.insertNotNull(usergroup);
        if (num!=1){
            throw new BusinessException("对不起，关联创建人失败!");
        }

        if (result.getFlag()==1){
            try {
                String content = "专案组新增(ID:"+entity.getId()+")";
                if (StringUtils.isNotBlank(entity.getPgroupid())){
                    content = content.replace("新增","组内建组");
                }
                //保存操作日志
                XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.GROUP,content , entity.getCreator(), now, entity.getId());
                xzLogMapper.insertNotNull(xzLog);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
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

    private synchronized String createGroupNum(String deparmentcode) {
        String maxNo = groupMapper.findMaxNo(deparmentcode);
        String nextNumber;
        if(StringUtils.isEmpty(maxNo)){
            nextNumber="00000";
        }  else{
            nextNumber=String.valueOf(Integer.parseInt(maxNo)+1);
            while (nextNumber.length()<6){
                nextNumber="0"+nextNumber;
            }
        }
        return "ZAZ" + deparmentcode+new SimpleDateFormat("yyyy").format(new Date())+nextNumber;
    }

    @Override
    public JsonResult getGroupPage(GroupParam groupParam) {
        Group group=new Group();
        BeanUtils.copyProperties(groupParam, group);
        //获取父专案组
        List<GroupModel> list = groupMapper.findGroupByCondition(group);
        long count = groupMapper.findCountGroupByCondition(group);
        return JsonResultUtil.success(count, list);
    }

    @Override
    public JsonResult getChildGroupList(String pgroupid) {
        List<GroupModel> list = groupMapper.findChildGroupList(pgroupid);
        return JsonResultUtil.success(list);
    }

    @Override
    public JsonResult getAllGroupByUserId(String userId) {
        return JsonResultUtil.success(groupMapper.findAllGroupByUserId(userId));
    }

}