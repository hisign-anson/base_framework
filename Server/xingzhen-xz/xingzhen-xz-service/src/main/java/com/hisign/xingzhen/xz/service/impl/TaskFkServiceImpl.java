package com.hisign.xingzhen.xz.service.impl;

import cn.jmessage.api.message.MessageType;
import com.alibaba.fastjson.JSONObject;
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
import com.hisign.xingzhen.nt.api.exception.NoticeException;
import com.hisign.xingzhen.nt.api.model.JMBean;
import com.hisign.xingzhen.nt.api.model.MsgBean;
import com.hisign.xingzhen.nt.api.service.NtService;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.sys.api.service.SysUserService;
import com.hisign.xingzhen.xz.api.entity.Task;
import com.hisign.xingzhen.xz.api.entity.TaskFk;
import com.hisign.xingzhen.xz.api.entity.TaskfkFile;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.model.TaskFkModel;
import com.hisign.xingzhen.xz.api.model.TaskModel;
import com.hisign.xingzhen.xz.api.param.TaskfkFileAddParam;
import com.hisign.xingzhen.xz.api.service.TaskFkService;
import com.hisign.xingzhen.xz.mapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


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
    protected GroupMapper groupMapper;

    @Autowired
    protected TaskfkFileMapper taskfkFileMapper;

    @Autowired
    protected XzLogMapper xzLogMapper;


    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private NtService ntService;
	
	@Override
	protected BaseMapper<TaskFk,TaskFkModel, String> initMapper() {
		return taskFkMapper;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public JsonResult add(List<TaskFk> list) throws BusinessException {
		try {
			taskFkMapper.batchInsert(list);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT,e);
		}
		return JsonResultUtil.success();
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public JsonResult update(UpdateParams params) throws BusinessException {
		try {
			taskFkMapper.updateCustom(params);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public JsonResult delByIds(List<String> ids) throws BusinessException {
		try {
			taskFkMapper.deleteByIds(ids);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE,e);
		}
		return JsonResultUtil.success();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
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
    @Transactional(rollbackFor = Exception.class)
    public JsonResult addNotNull(TaskFk taskFk) throws BusinessException {
        try {
            if(StringUtils.isEmpty(taskFk.getCreator())){
                return error("反馈任务失败,当前登陆用户不能为空");
            }
            TaskModel taskModel=taskMapper.findById(taskFk.getTaskid());
            if(taskModel==null || Constants.DELETE_TRUE.equals(taskModel.getDeleteflag())){
                return error("该任务不存在");
            }

            GroupModel group =groupMapper.findById(taskModel.getGroupid());
            if(group==null){
                return error("该任务专案组不存在");
            }
            //获取用户信息
            SysUserInfo user = sysUserService.getUserInfoByUserId(taskModel.getCreator());
            if (user==null){
                log.error("该用户不存在，[user=?]",user);
                return error("抱歉，该任务创建人不存在，请联系管理员!");
            }
            Date now=new Date();
            taskFk.setId(StringUtils.getUUID());
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
                    taskfkFile.setId(StringUtils.getUUID());
                    taskfkFile.setCreatetime(now);
                    taskfkFile.setDeleteFlag(Constants.DELETE_FALSE);
                    taskfkFile.setTaskfkId(taskFk.getId());
                    taskfkFile.setCreator(taskFk.getCreator());
                    taskfkFileMapper.insertNotNull(taskfkFile);
                }
            }
            if(result.isSuccess()){
                try {
                    String content="任务反馈（ID=" + taskFk.getId() + ",TASKID"+ taskFk.getTaskid() + "）";
                    XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.TASK,content , taskFk.getCreator(), now, taskModel.getId());
                    xzLogMapper.insertNotNull(xzLog);
                } catch (Exception e){
                    log.error(e.getMessage(),e);
                }
                try {
                    //发送消息到极光
                    JMBean jmBean = new JMBean(StringUtils.getUUID(), Constants.SEND_TASK_FEEDBACK_INFO,Constants.JM_FROM_TYPE_ADMIN, Constants.JM_TARGET_TYPE_SINGLE, MessageType.CUSTOM.getValue(),
                            taskFk.getCreator(), taskModel.getCreator());
                    Map<String, Object> map = new HashMap<>();
                    map.put("msgType",Constants.SEND_TASK_FEEDBACK_INFO);
                    map.put("title","反馈任务");
                    map.put("taskId",taskModel.getId());
                    map.put("creator",taskFk.getCreator());
                    map.put("createName",taskFk.getCreatename());
                    map.put("jsr",taskModel.getCreator());
                    map.put("jsrName",taskModel.getCreatename());
                    map.put("fkxs",taskFk.getFkxs());
                    map.put("createTime",taskFk.getCreatetime());
                    map.put("groupId",group.getId());
                    map.put("jmgId",group.getJmgid());
                    jmBean.setMsg_body(JSONObject.toJSONString(map));
                    ntService.sendJM(jmBean);

                    //发送信息提醒
                    MsgBean bean = new MsgBean();
                    String text = "反馈任务:"+taskFk.getCreatename()+"反馈了您下发的任务，任务编号："+taskModel.getTaskNo();
                    bean.setMsgId(StringUtils.getUUID());
                    bean.setReceiverType(String.valueOf(Constants.ReceiveMessageType.TYPE_3));
                    bean.setMsgContent(text);
                    bean.setPublishId(taskFk.getCreator());
                    bean.setPublishName(taskFk.getCreatename());
                    List<SysUserInfo> userList=new ArrayList<>();
                    userList.add(user);
                    bean.setList(userList);
                    ntService.sendMsg(bean);
                } catch (NoticeException e){
                    //不做回滚
                    log.error("推送消息到移动端失败",e);
                }
                return JsonResultUtil.success(super.getById(taskFk.getId()));
            }
            return result;
        }  catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE,e);
        }
    }
}