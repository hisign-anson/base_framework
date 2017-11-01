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
import com.hisign.xingzhen.xz.api.entity.AsjAj;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.AjgroupModel;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.service.AjgroupService;
import com.hisign.xingzhen.xz.mapper.AjgroupMapper;
import com.hisign.xingzhen.xz.mapper.AsjAjMapper;
import com.hisign.xingzhen.xz.mapper.GroupMapper;
import com.hisign.xingzhen.xz.mapper.XzLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    private AsjAjMapper asjAjMapper;

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
        //子专案组不能关联案件
        if (StringUtils.isNotBlank(groupModel.getPgroupid())){
            return error("抱歉，子专案组不能关联案件");
        }

        Date now=new Date();
        entity.setId(UUID.randomUUID().toString());
        entity.setPgroupid(groupModel.getPgroupid());
        entity.setCreatetime(now);
        entity.setLastupdatetime(now);
        entity.setPgroupid(groupModel.getPgroupid());
        entity.setDeleteflag(Constants.DELETE_FALSE);
        JsonResult result = super.addNotNull(entity);
        if (result.getFlag()==JsonResultUtil.SUCCESS){
            try {
                //保存操作日志
                String content = StringUtils.concat("专案组(ID:",entity.getGroupid(),")关联案件(ID:", entity.getAjid(),")");
                XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()), Constants.XZLogType.GROUP, content, entity.getCreator(), entity.getCreatetime(), entity.getId());
                xzLogMapper.insertNotNull(xzLog);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
            return JsonResultUtil.success(super.getById(entity.getId()));
        }else {

        }
        return error(BaseEnum.BusinessExceptionEnum.INSERT.Msg());
    }

    @Override
    @Transactional
    public JsonResult add(List<Ajgroup> ajgroupList) throws BusinessException {
        try {
            List<Object> ids = new ArrayList<>();
            String groupId = ajgroupList.get(0).getGroupid();

            //获取专案组对象
            GroupModel groupModel = groupMapper.findById(groupId);
            if (groupModel==null){
                log.error("专案组不存在，[id=?]",groupId);
                return error("抱歉，关联的专案组不存在，请刷新页面再试!");
            }

            for (Ajgroup ajgroup : ajgroupList) {
                ids.add(ajgroup.getAjid());
                ajgroup.setGroupid(groupId);
                ajgroup.setPgroupid(groupModel.getPgroupid());
                ajgroup.setDeleteflag(Constants.DELETE_FALSE);
                ajgroup.setCreatetime(new Date());
                ajgroup.setLastupdatetime(new Date());
                ajgroup.setId(UUID.randomUUID().toString());
                ajgroup.setPgroupid(null);
            }

            Conditions conditions = new Conditions(AsjAj.class);
            Conditions.Criteria criteria = conditions.createCriteria();
            criteria.add(AsjAj.AsjAjEnum.id.get(), BaseEnum.IsInEnum.IN,ids);

            Long count = asjAjMapper.findCount(conditions);
            if (count.intValue()!=ajgroupList.size()){
                log.error("关联的案件有些不存在，[ids=?]",ids);
                return error("抱歉，参数错误，请刷新页面再试!");
            }

            //关联案件
            long num = ajgroupMapper.batchInsert(ajgroupList);
            if (num!=ajgroupList.size()){
                throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT);
            }
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

    /**
     * 移除案件
     * @param ajgroupList
     * @return
     * @throws BusinessException
     */
    @Transactional(rollbackFor = BusinessException.class)
    public JsonResult removeCaseList(List<Ajgroup> ajgroupList) throws BusinessException {

        List<Object> ids = new ArrayList<>();
        for (Ajgroup ajgroup : ajgroupList) {
            if (StringUtils.isEmpty(ajgroup.getId())){
                log.error("错误，关联的id为空");
                return error("抱歉，参数错误，请刷新页面再试!");
            }
            ids.add(ajgroup.getId());
        }

        Conditions conditions = new Conditions(Ajgroup.class);
        Conditions.Criteria criteria = conditions.createCriteria();
        criteria.add(Ajgroup.AjgroupEnum.id.get(), BaseEnum.IsInEnum.IN,ids);

        Long count = ajgroupMapper.findCount(conditions);
        if (count.intValue()!=ajgroupList.size()){
            log.info("count=[]",count);
            return error("抱歉，参数错误，请刷新页面再试!");
        }

        List<AjgroupModel> ajgroupModelList = ajgroupMapper.findList(conditions);

        for (AjgroupModel ajgroupModel : ajgroupModelList) {
            //子专案组不能移除案件
            if (StringUtils.isNotBlank(ajgroupModel.getPgroupid())){
                return error("抱歉，子专案组不能移除案件");
            }
        }
        ajgroupMapper.deleteCustom(conditions);

        return success();
    }
}