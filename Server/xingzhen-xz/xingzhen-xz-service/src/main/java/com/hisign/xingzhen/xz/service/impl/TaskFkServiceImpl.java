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
import com.hisign.xingzhen.xz.api.entity.Task;
import com.hisign.xingzhen.xz.api.entity.TaskFk;
import com.hisign.xingzhen.xz.api.entity.TaskfkFile;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.TaskFkModel;
import com.hisign.xingzhen.xz.api.model.TaskModel;
import com.hisign.xingzhen.xz.api.param.TaskfkFileAddParam;
import com.hisign.xingzhen.xz.api.service.TaskFkService;
import com.hisign.xingzhen.xz.mapper.TaskFkMapper;
import com.hisign.xingzhen.xz.mapper.TaskMapper;
import com.hisign.xingzhen.xz.mapper.TaskfkFileMapper;
import com.hisign.xingzhen.xz.mapper.XzLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 《任务反馈》 业务逻辑服务类
 * @author 何建辉
 *
 */
@Service("taskFkService")
public class TaskFkServiceImpl extends BaseServiceImpl<TaskFk,TaskFkModel, String> implements TaskFkService{

    Logger log = LoggerFactory.getLogger(TaskFkServiceImpl.class);

	@Autowired
	protected TaskFkMapper taskFkMapper;

    @Autowired
    protected TaskMapper taskMapper;

    @Autowired
    protected TaskfkFileMapper taskfkFileMapper;

    @Autowired
    protected XzLogMapper xzLogMapper;
	
	@Override
	protected BaseMapper<TaskFk,TaskFkModel, String> initMapper() {
		return taskFkMapper;
	}
	
	@Override
	@Transactional
	public JsonResult add(List<TaskFk> list) throws BusinessException {
		try {
			taskFkMapper.batchInsert(list);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT,e);
		}
		return JsonResultUtil.success();
	}
	
	@Override
	@Transactional
	public JsonResult update(UpdateParams params) throws BusinessException {
		try {
			taskFkMapper.updateCustom(params);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delByIds(List<String> ids) throws BusinessException {
		try {
			taskFkMapper.deleteByIds(ids);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional
	public JsonResult delBy(Conditions conditions) throws BusinessException {
		try {
			taskFkMapper.deleteCustom(conditions);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

    @Override
    public JsonResult add(TaskFk entity) throws BusinessException {
        return super.addNotNull(entity);
    }

    @Override
    public JsonResult addNotNull(TaskFk taskFk) throws BusinessException {
        try {
            if(StringUtils.isEmpty(taskFk.getCreator())){
                return error("反馈任务失败,当前登陆用户不能为空");
            }
            TaskModel taskModel=taskMapper.findById(taskFk.getTaskid());
            if(taskModel==null || Constants.DELETE_TRUE.equals(taskModel.getDeleteflag())){
                return error("该任务不存在");
            }
            Date now=new Date();
            taskFk.setId(UUID.randomUUID().toString());
            taskFk.setGroupid(taskModel.getGroupid());
            taskFk.setPgroupid(taskModel.getPgroupid());
            taskFk.setFkTime(now);
            taskFk.setFkr(taskFk.getCreator());
            taskFk.setFkrname(taskFk.getCreatename());
            taskFk.setCreatetime(now);
            taskFk.setLastupdatetime(now);
            taskFk.setDeleteflag(Constants.DELETE_FALSE);
            JsonResult result =  super.addNotNull(taskFk);

            Task task=new Task();
            task.setId(taskFk.getTaskid());
            task.setFkzt(Constants.YES);
            task.setFkTime(now);
            task.setLastupdatetime(now);
            taskMapper.updateNotNull(task);

            if(taskFk.getTaskFkFiles()!=null){
                for(TaskfkFileAddParam file:taskFk.getTaskFkFiles()) {
                    TaskfkFile taskfkFile=new TaskfkFile();
                    BeanUtils.copyProperties(file,taskfkFile);
                    taskfkFile.setId(UUID.randomUUID().toString());
                    taskfkFile.setCreatetime(now);
                    taskfkFile.setDeleteFlag(Constants.DELETE_FALSE);
                    taskfkFile.setTaskfkId(taskFk.getId());
                    taskfkFile.setCreator(taskFk.getCreator());
                    taskfkFileMapper.insertNotNull(taskfkFile);
                }
            }
            if(result.getFlag()==1){
                try {
                    String content="任务反馈（ID=" + taskFk.getId() + ",TASKID"+ taskFk.getTaskid() + "）";
                    XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.TASK,content , taskFk.getCreator(), now, task.getId());
                    xzLogMapper.insertNotNull(xzLog);
                } catch (Exception e){
                    log.error(e.getMessage());
                }
                return JsonResultUtil.success(super.getById(taskFk.getId()));
            }
            return result;
        }  catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE,e);
        }
    }
}