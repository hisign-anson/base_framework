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
import com.hisign.xingzhen.xz.api.entity.Ajgroup;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.AjgroupModel;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.service.AjgroupService;
import com.hisign.xingzhen.xz.mapper.AjgroupMapper;
import com.hisign.xingzhen.xz.mapper.GroupMapper;
import com.hisign.xingzhen.xz.mapper.XzLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 《案件专案组关联》 业务逻辑服务类
 *
 * @author 何建辉
 */
@Service("ajgroupService")
public class AjgroupServiceImpl extends BaseServiceImpl<Ajgroup, AjgroupModel, String> implements AjgroupService {

    Logger log = LoggerFactory.getLogger(AjgroupService.class);

    @Autowired
    protected AjgroupMapper ajgroupMapper;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private XzLogMapper xzLogMapper;

    @Override
    protected BaseMapper<Ajgroup, AjgroupModel, String> initMapper() {
        return ajgroupMapper;
    }

    @Override
    public JsonResult add(Ajgroup entity) throws BusinessException {

        return addNotNull(entity);
    }

    @Override
    public JsonResult addNotNull(Ajgroup entity) throws BusinessException {
        GroupModel groupModel=groupMapper.findById(entity.getGroupid());
        if(groupModel==null){
            return error("专案组不存在");
        }
        Date now=new Date();
        entity.setId(UUID.randomUUID().toString());
        entity.setCreatetime(now);
        entity.setLastupdatetime(now);
        entity.setPgroupid(groupModel.getPgroupid());
        entity.setDeleteflag(Constants.DELETE_FALSE);
        JsonResult result = super.addNotNull(entity);
        if (result.getFlag()==1){
            try {
                if (result.getFlag()==1){
                    //保存操作日志
                    String content = StringUtils.concat("专案组(ID:",entity.getGroupid(),")关联案件(ID:", entity.getAjid(),")");
                    XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()), Constants.XZLogType.GROUP, content, entity.getCreator(), entity.getCreatetime(), entity.getId());
                    xzLogMapper.insertNotNull(xzLog);
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
            return JsonResultUtil.success(super.getById(entity.getId()));
        }
        return super.addNotNull(entity);
    }

    @Override
    @Transactional
    public JsonResult add(List<Ajgroup> list) throws BusinessException {
        try {
            ajgroupMapper.batchInsert(list);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult update(UpdateParams params) throws BusinessException {
        try {
            ajgroupMapper.updateCustom(params);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult delByIds(List<String> ids) throws BusinessException {
        try {
            ajgroupMapper.deleteByIds(ids);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional
    public JsonResult delBy(Conditions conditions) throws BusinessException {
        try {
            ajgroupMapper.deleteCustom(conditions);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

}