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
import com.hisign.xingzhen.xz.api.entity.Cb;
import com.hisign.xingzhen.xz.api.entity.Task;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.CbModel;
import com.hisign.xingzhen.xz.api.service.CbService;
import com.hisign.xingzhen.xz.mapper.CbMapper;
import com.hisign.xingzhen.xz.mapper.TaskMapper;
import com.hisign.xingzhen.xz.mapper.XzLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 《催办记录》 业务逻辑服务类
 * @author 何建辉
 *
 */
@Service("cbService")
public class CbServiceImpl extends BaseServiceImpl<Cb,CbModel, String> implements CbService{

	@Autowired
	protected CbMapper cbMapper;
    @Autowired
    protected TaskMapper taskMapper;
    @Autowired
    protected XzLogMapper xzLogMapper;
	
	@Override
	protected BaseMapper<Cb,CbModel, String> initMapper() {
		return cbMapper;
	}
	
	@Override
	@Transactional
	public JsonResult add(List<Cb> list) throws BusinessException {
		try {
			cbMapper.batchInsert(list);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT,e);
		}
		return JsonResultUtil.success();
	}
	
	@Override
	@Transactional
	public JsonResult update(UpdateParams params) throws BusinessException {
		try {
			cbMapper.updateCustom(params);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delByIds(List<String> ids) throws BusinessException {
		try {
			cbMapper.deleteByIds(ids);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delBy(Conditions conditions) throws BusinessException {
		try {
			cbMapper.deleteCustom(conditions);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

     @Override
     @Transactional
     public JsonResult addCb(String id,String userId,String deparmentcode) {
         try {
             if(StringUtils.isEmpty(userId)){
                 return error("任务催办失败,当前登陆用户不能为空");
             }
             Cb cb=new Cb();
             Date now=new Date();
             cb.setId(UUID.randomUUID().toString());
             cb.setCbTime(now);
             cb.setTaskid(id);
             cb.setCreator(userId);
             cb.setCreatetime(now);
             cb.setDeparmentcode(deparmentcode);
             cb.setLastupdatetime(now);
             cb.setDeleteflag(Constants.DELETE_FALSE);
             JsonResult result =  super.addNotNull(cb);

             Task task=new Task();
             task.setId(cb.getTaskid());
             task.setCbzt(Constants.YES);
             task.setLastupdatetime(now);
             taskMapper.updateNotNull(task);

             String content="任务催办（ID=" + cb.getId() + ",TASKID="+ cb.getTaskid()+ "）";
             XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.TASK,content , cb.getCreator(), now, cb.getId());
             xzLogMapper.insertNotNull(xzLog);
             return result;
         }catch (Exception e) {
             throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT,e);
         }
     }
 }