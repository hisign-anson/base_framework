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
import com.hisign.xingzhen.common.util.DateUtil;
import com.hisign.xingzhen.common.util.IpUtil;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.nt.api.exception.NoticeException;
import com.hisign.xingzhen.nt.api.model.JMBean;
import com.hisign.xingzhen.nt.api.model.MsgBean;
import com.hisign.xingzhen.nt.api.service.NtService;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.sys.api.service.SysUserService;
import com.hisign.xingzhen.xz.api.entity.*;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.model.TaskFkModel;
import com.hisign.xingzhen.xz.api.model.TaskModel;
import com.hisign.xingzhen.xz.api.model.TaskfkFileModel;
import com.hisign.xingzhen.xz.api.param.TaskMoveParam;
import com.hisign.xingzhen.xz.api.param.TaskSelectParam;
import com.hisign.xingzhen.xz.api.service.TaskService;
import com.hisign.xingzhen.xz.mapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 《任务》 业务逻辑服务类
 *
 * @author 何建辉
 */
@Service("taskService")
public class TaskServiceImpl extends BaseServiceImpl<Task,TaskModel, String> implements TaskService {

    Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    protected TaskMapper taskMapper;

    @Autowired
    protected TaskFkMapper taskFkMapper;

    @Autowired
    protected GroupMapper groupMapper;

    @Autowired
    protected CbMapper cbMapper;

    @Autowired
    protected TaskfkFileMapper taskfkFileMapper;

    @Autowired
    protected XzLogMapper xzLogMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private NtService ntService;

    @Override
    protected BaseMapper<Task,TaskModel, String> initMapper() {
        return taskMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult add(List<Task> list) throws BusinessException {
        try {
            taskMapper.batchInsert(list);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult update(UpdateParams params) throws BusinessException {
        try {
            taskMapper.updateCustom(params);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult delByIds(List<String> ids) throws BusinessException {
        try {
            taskMapper.deleteByIds(ids);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult delBy(Conditions conditions) throws BusinessException {
        try {
            taskMapper.deleteCustom(conditions);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.DELETE, e);
        }
        return JsonResultUtil.success();
    }

    /**
     * 任务分页
     * @param  taskSelectParam
     * 刘玉兰 2017/10/23
     */
    @Override
    public JsonResult getTaskPage(TaskSelectParam taskSelectParam) {
        Task task=new Task();
        BeanUtils.copyProperties(taskSelectParam,task);
        List<TaskModel> list = taskMapper.findTaskByEntity(task);
        long count = taskMapper.findCountTaskByEntity(task);
        return JsonResultUtil.success(count,list);
    }
    /**
     * 查看任务
     * @param  id   userId
     * 刘玉兰
     * 接收人查看未反馈的信息，将任务单状态改为已签收，接收人查看已反馈的信息，反馈信息的状态改为已确认
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult taskDetail(String id,String userId) {
        TaskModel taskModel=taskMapper.findTaskById(id);
        if(taskModel==null){
            return error("该任务不存在");
        }
        //已反馈的才能有反馈信息
        if(Constants.YES.equals(taskModel.getFkzt())){
            TaskFk fk=new TaskFk();
            fk.setTaskid(id);
            fk.setOrderBy("createtime");
            List<TaskFkModel> taskFkModels=taskFkMapper.findListByEntity(fk);
            if(taskFkModels!=null && taskFkModels.size()>0){
                Date now=new Date();
                for(TaskFkModel taskFkModel:taskFkModels){
                    TaskfkFile file=new TaskfkFile();
                    file.setTaskfkId(taskFkModel.getId());
                    file.setOrderBy("createtime");
                    List<TaskfkFileModel> taskfkFiles=taskfkFileMapper.findListByEntity(file);
                    if(taskfkFiles!=null&&taskfkFiles.size()>0) {
                        taskFkModel.setTaskFkFiles(taskfkFiles);
                    }
                    //查看更新未确认的反馈信息
                    if(!Constants.YES.equals(taskFkModel.getQrzt()) && taskModel.getCreator()!=null && taskModel.getCreator().equals(userId)) {
                        TaskFk taskFk=new TaskFk();
                        taskFk.setId(taskFkModel.getId());
                        taskFk.setQrzt(Constants.YES);
                        taskFk.setQrTime(now);
                        taskFk.setLastupdatetime(now);
                        long result=taskFkMapper.updateNotNull(taskFk);
                        if(result>0){
                            try {
                                String content="任务反馈确认（ID=" + taskFkModel.getId() + "）";
                                XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.TASK,content , userId, now, taskFkModel.getId());
                                xzLogMapper.insertNotNull(xzLog);
                            }catch (Exception e) {
                                log.error(e.getMessage(),e);
                            }
                            //第一次进去现在已确认
                            taskFkModel.setQrzt(Constants.YES);
                        }
                    }
                }
                taskModel.setTaskFks(taskFkModels);
            }
        } else{
            //查看更新未确认的反馈信息
            if(!Constants.YES.equals(taskModel.getQszt()) && taskModel.getJsr()!=null && taskModel.getJsr().equals(userId)) {
                Date now=new Date();
                Task t = new Task();
                t.setId(id);
                t.setQszt(Constants.YES);
                t.setQsTime(now);
                t.setLastupdatetime(now);
                long result=taskMapper.updateNotNull(t);
                if(result>0){
                     try {
                         String content="任务签收（ID=" + taskModel.getId() + "）";
                         XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.TASK,content , taskModel.getCreator(), now, taskModel.getId());
                         xzLogMapper.insertNotNull(xzLog);
                     } catch (Exception e) {
                         log.error(e.getMessage(),e);
                     }
                    taskModel.setQszt(Constants.YES);
                }
            }
        }
        return JsonResultUtil.success(taskModel);
    }

    @Override
    public JsonResult add(Task entity) throws BusinessException {
        return super.addNotNull(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult addNotNull(Task task) throws BusinessException {
        if(!StringUtils.isEmpty(task.getBcrwid())){
            TaskModel t=super.getById(task.getBcrwid());
            if(t==null){
                return error("补充任务不存在");
            }
        }
        if(!StringUtils.isEmpty(task.getFkid())){
            TaskFkModel t=taskFkMapper.findById(task.getFkid());
            if(t==null){
                return error("任务反馈不存在");
            }
        }
        GroupModel group=groupMapper.findById(task.getGroupid());
        if(group==null) {
            return error("添加记录失败,专案组不存在");
        }
        if(group.getDeparmentcode()==null||group.getDeparmentcode().length()!=12){
            return error("添加记录失败,该专案组所属机构有误");
        }
        //获取用户信息
        SysUserInfo user = sysUserService.getUserInfoByUserId(task.getJsr());
        if (user==null){
            log.error("该用户不存在，[user=?]",user);
            return error("抱歉，该接收人不存在，请重新选择!");
        }
        Date now=new Date();
        task.setId(StringUtils.getUUID());
        task.setTaskNo(createTaskNo(group.getDeparmentcode()));
        task.setGroupTaskNo(createGroupTaskNo(group.getId()));
        task.setPgroupid(group.getPgroupid());
        task.setCreator(task.getFqr());
        task.setCreatename(task.getFqrname());
        task.setDeparmentcode(task.getFqrDeptCode());
        task.setFqTime(now);
        task.setCreatetime(now);
        task.setLastupdatetime(now);
        task.setDeleteflag(Constants.DELETE_FALSE);
        JsonResult result = super.addNotNull(task);
        if(result.isSuccess()){
            try {
                String content="任务新增（ID=" + task.getId() + "）";
                if(!StringUtils.isEmpty(task.getBcrwid())) {
                    content ="任务补充（ID=" + task.getId() + ",BCRWID"+ task.getBcrwid() + "）";
                }
                if(!StringUtils.isEmpty(task.getFkid())) {
                    content ="任务追加（ID=" + task.getId() + ",FKID"+ task.getFkid() + "）";
                }
                XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.TASK,content , task.getCreator(), now, task.getId());
                xzLogMapper.insertNotNull(xzLog);
            } catch (Exception e){
                log.error(e.getMessage(),e);
            }

            try {
                //发送消息到极光
                JMBean jmBean = new JMBean(StringUtils.getUUID(), Constants.SEND_TASK_INFO,Constants.JM_FROM_TYPE_ADMIN, Constants.JM_TARGET_TYPE_GROUP, MessageType.CUSTOM.getValue(),
                        task.getCreator(), group.getJmgid());
                Map<String, Object> map = new HashMap<>();
                map.put("msgType",Constants.SEND_TASK_INFO);
                map.put("title","新增任务");
                map.put("taskId",task.getId());
                map.put("creator",task.getCreator());
                map.put("createName",task.getCreatename());
                map.put("jsr",task.getJsr());
                map.put("jsrName",task.getJsrname());
                map.put("taskContent",task.getTaskContent());
                map.put("createTime",DateUtil.getDateTime(now));
                map.put("groupId",group.getId());
                map.put("jmgId",group.getJmgid());
                jmBean.setMsg_body(JSONObject.toJSONString(map));
                ntService.sendJM(jmBean);

                //发送信息提醒
                MsgBean bean = new MsgBean();
                String text = "新增任务:"+task.getCreatename()+"给您下发了任务，任务编号："+task.getTaskNo();
                bean.setMsgId(StringUtils.getUUID());
                bean.setReceiverType(String.valueOf(Constants.ReceiveMessageType.TYPE_3));
                bean.setMsgContent(text);
                bean.setPublishId(task.getCreator());
                bean.setPublishName(task.getCreatename());
                List<SysUserInfo> userList=new ArrayList<>();
                userList.add(user);
                bean.setList(userList);
                ntService.sendMsg(bean);
            } catch (Exception e){
                //不做回滚
                log.error("推送消息到移动端失败",e);
            }

            return JsonResultUtil.success(super.getById(task.getId()));
        }
        return result;
    }


    @Override
    public JsonResult deleteTaskById(String id,String userId) {
        Task task=new Task();
        task.setId(id);
        Date now=new Date();
        task.setDeleteflag(Constants.DELETE_TRUE);
        task.setLastupdatetime(now);
        JsonResult result = super.updateNotNull(task);
        if(result.isSuccess()){
             try {
                 String content="任务删除（ID=" + task.getId() + "）";
                 XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.TASK,content , userId, now, task.getId());
                 xzLogMapper.insertNotNull(xzLog);
             } catch (Exception e){
                 log.error(e.getMessage(),e);
             }
        }
        return result;
    }
    /**
     * 移交任务
     * @param  taskMoveParam
     * 刘玉兰
     * 本方法移交是创建一条新数据用来保存历史，修改旧数据作为移交后的数据，移交后需要修改提醒记录中的taskid
     */
    @Override
    @Transactional
    public JsonResult moveTask(TaskMoveParam taskMoveParam) {
        try {
            Task new_task  = super.getEntityById(taskMoveParam.getId());
            if(new_task==null || Constants.DELETE_TRUE.equals(new_task.getDeleteflag())){
                return error("该任务不存在");
            }
            GroupModel group =groupMapper.findById(new_task.getGroupid());
            if(group==null){
                return error("该任务专案组不存在");
            }
            //获取用户信息
            SysUserInfo user = sysUserService.getUserInfoByUserId(taskMoveParam.getJsr());
            if (user==null){
                log.error("该用户不存在，[user=?]",user);
                return error("抱歉，该接收人不存在，请重新选择!");
            }
            Task entity=new Task();
            BeanUtils.copyProperties(new_task,entity);
            Date now=new Date();
            new_task.setId(StringUtils.getUUID());
            new_task.setLastupdatetime(now);
            new_task.setYjzt(Constants.YES);
            new_task.setYjTime(now);
            taskMapper.insertNotNull(new_task);

            Cb cb=new Cb();
            cb.setTaskid(new_task.getId());
            cb.setOld_taskid(taskMoveParam.getId());
            cbMapper.updateCbTaskid(cb);

            entity.setId(taskMoveParam.getId());
            entity.setQszt(Constants.NO);
            entity.setQsTime(null);
            entity.setJsr(taskMoveParam.getJsr());
            entity.setJsrname(taskMoveParam.getJsrname());
            entity.setJsrLxfs(taskMoveParam.getJsrLxfs());
            entity.setCreator(taskMoveParam.getCreator());
            entity.setCreatename(taskMoveParam.getCreatename());
            entity.setCreatetime(now);
            entity.setLastupdatetime(now);
            entity.setDeleteflag(Constants.DELETE_FALSE);
            entity.setYjrwid(new_task.getId());
            JsonResult result = super.update(entity);
            if(result.isSuccess()){
                try {
                    String content="任务移交（ID=" + taskMoveParam.getId() + ",YJRWID="+ new_task.getId()+ "）";
                    XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.TASK,content , taskMoveParam.getCreator(), now, taskMoveParam.getId());
                    xzLogMapper.insertNotNull(xzLog);
                } catch (Exception e){
                    log.error(e.getMessage(),e);
                }

                try {
                    //发送消息到极光
                    JMBean jmBean = new JMBean(StringUtils.getUUID(), Constants.SEND_TASK_MOVE_INFO,Constants.JM_FROM_TYPE_ADMIN, Constants.JM_TARGET_TYPE_GROUP, MessageType.CUSTOM.getValue(),
                            entity.getCreator(), group.getJmgid());
                    Map<String, Object> map = new HashMap<>();
                    map.put("msgType",Constants.SEND_TASK_MOVE_INFO);
                    map.put("title","移交任务");
                    map.put("taskId",entity.getId());
                    map.put("creator",entity.getCreator());
                    map.put("createName",entity.getCreatename());
                    map.put("jsr",entity.getJsr());
                    map.put("jsrName",entity.getJsrname());
                    map.put("taskContent",entity.getTaskContent());
                    map.put("createTime",DateUtil.getDateTime(now));
                    map.put("groupId",group.getId());
                    map.put("jmgId",group.getJmgid());
                    jmBean.setMsg_body(JSONObject.toJSONString(map));
                    ntService.sendJM(jmBean);

                    //发送信息提醒接收人
                    MsgBean bean1 = new MsgBean();
                    String text1 = "移交任务:"+entity.getCreatename()+"移交了任务给您，任务编号："+entity.getTaskNo();
                    bean1.setMsgId(StringUtils.getUUID());
                    bean1.setReceiverType(String.valueOf(Constants.ReceiveMessageType.TYPE_3));
                    bean1.setMsgContent(text1);
                    bean1.setPublishId(entity.getCreator());
                    bean1.setPublishName(entity.getCreatename());
                    List<SysUserInfo> userList1=new ArrayList<>();
                    userList1.add(user);
                    bean1.setList(userList1);
                    ntService.sendMsg(bean1);

                    //获取用户信息
                    SysUserInfo fqrUser = sysUserService.getUserInfoByUserId(entity.getFqr());
                    if (fqrUser!=null){
                        //发送信息提醒发起人
                        MsgBean bean2 = new MsgBean();
                        String text = "移交任务:"+entity.getCreatename()+"将您发布的任务移交给了"+taskMoveParam.getJsrname()+"，任务编号："+entity.getTaskNo();
                        bean2.setMsgId(StringUtils.getUUID());
                        bean2.setReceiverType(String.valueOf(Constants.ReceiveMessageType.TYPE_3));
                        bean2.setMsgContent(text);
                        bean2.setPublishId(entity.getCreator());
                        bean2.setPublishName(entity.getCreatename());
                        List<SysUserInfo> userList2=new ArrayList<>();
                        userList2.add(fqrUser);
                        bean2.setList(userList2);
                        ntService.sendMsg(bean2);
                    }


                } catch (NoticeException e){
                    //不做回滚
                    log.error("推送消息到移动端失败",e);
                }
            }
            return result;
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.UPDATE,e);
        }
    }


    private String createTaskNo(String deparmentcode) {
        String maxNo = taskMapper.findMaxNo(deparmentcode);
        String nextNumber;
        if(StringUtils.isEmpty(maxNo)){
            nextNumber="000000";
        }  else{
            nextNumber=String.valueOf(Integer.parseInt(maxNo)+1);
            while (nextNumber.length()<6){
                nextNumber="0"+nextNumber;
            }
        }
        return "RW" + deparmentcode+new SimpleDateFormat("yyyy").format(new Date())+nextNumber;
    }

    private String createGroupTaskNo(String groupId) {
        String maxNo = taskMapper.findGroupTaskMaxNo(groupId);
        String nextNumber;
        if(StringUtils.isEmpty(maxNo)){
            nextNumber="001";
        }  else{
            nextNumber=String.valueOf(Integer.parseInt(maxNo)+1);
            while (nextNumber.length()<3){
                nextNumber="0"+nextNumber;
            }
        }
        return nextNumber;
    }
}