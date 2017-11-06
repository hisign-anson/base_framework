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
import com.hisign.xingzhen.xz.api.entity.Cb;
import com.hisign.xingzhen.xz.api.entity.Task;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.CbModel;
import com.hisign.xingzhen.xz.api.model.TaskModel;
import com.hisign.xingzhen.xz.api.service.CbService;
import com.hisign.xingzhen.xz.mapper.CbMapper;
import com.hisign.xingzhen.xz.mapper.TaskMapper;
import com.hisign.xingzhen.xz.mapper.XzLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * 《催办记录》 业务逻辑服务类
 * @author 何建辉
 *
 */
@Service("cbService")
public class CbServiceImpl extends BaseServiceImpl<Cb,CbModel, String> implements CbService{

    Logger log = LoggerFactory.getLogger(CbServiceImpl.class);

	@Autowired
	protected CbMapper cbMapper;
    @Autowired
    protected TaskMapper taskMapper;
    @Autowired
    protected XzLogMapper xzLogMapper;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private NtService ntService;
	
	@Override
	protected BaseMapper<Cb,CbModel, String> initMapper() {
		return cbMapper;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public JsonResult add(List<Cb> list) throws BusinessException {
		try {
			cbMapper.batchInsert(list);
		} catch (Exception e) {
			throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT,e);
		}
		return JsonResultUtil.success();
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
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
    public JsonResult add(Cb entity) throws BusinessException {
        return super.addNotNull(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult addNotNull(Cb cb) throws BusinessException {
        try {
            if(StringUtils.isEmpty(cb.getCreator())){
                return error("任务催办失败,当前登陆用户不能为空");
            }
            TaskModel taskModel=taskMapper.findById(cb.getTaskid());
            if(taskModel==null|| Constants.DELETE_TRUE.equals(taskModel.getDeleteflag())){
                return error("任务催办失败,该任务不存在");
            }
            //获取用户信息
            SysUserInfo loginUser= sysUserService.getUserInfoByUserId(cb.getCreator());
            if (loginUser==null){
                log.error("该用户不存在，[user=?]",loginUser);
                return error("抱歉，该用户不存在，请刷新页面再试!");
            }
            //获取用户信息
            SysUserInfo user = sysUserService.getUserInfoByUserId(taskModel.getJsr());
            if (user==null){
                log.error("该用户不存在，[user=?]",user);
                return error("抱歉，该任务接收人不存在，请联系管理员!");
            }
            Date now=new Date();
            cb.setId(StringUtils.getUUID());
            cb.setCbTime(now);
            cb.setCreatename(loginUser.getUserName());
            cb.setCreatetime(now);
            cb.setLastupdatetime(now);
            cb.setDeleteflag(Constants.DELETE_FALSE);
            JsonResult result =  super.addNotNull(cb);

            Task task=new Task();
            task.setId(cb.getTaskid());
            task.setCbzt(Constants.YES);
            task.setLastupdatetime(now);
            taskMapper.updateNotNull(task);
            if(result.isSuccess()){
                try {
                    String content="任务催办（ID=" + cb.getId() + ",TASKID="+ cb.getTaskid()+ "）";
                    XzLog xzLog = new XzLog(IpUtil.getRemotIpAddr(BaseRest.getRequest()),Constants.XZLogType.TASK,content , cb.getCreator(), now, cb.getId());
                    xzLogMapper.insertNotNull(xzLog);
                } catch (Exception e){
                    log.error(e.getMessage(),e);
                }

                try {
                    //发送消息到极光
                    JMBean jmBean = new JMBean(StringUtils.getUUID(), Constants.SEND_TASK_URGE_INFO,Constants.JM_FROM_TYPE_ADMIN, Constants.JM_TARGET_TYPE_SINGLE, MessageType.CUSTOM.getValue(),
                            cb.getCreator(), taskModel.getJsr());
                    Map<String, Object> map = new HashMap<>();
                    map.put("msgType",Constants.SEND_TASK_URGE_INFO);
                    map.put("title","催办任务");
                    map.put("taskId",cb.getTaskid());
                    map.put("creator",cb.getCreator());
                    map.put("createName",cb.getCreatename());
                    map.put("jsr",taskModel.getJsr());
                    map.put("jsrName",taskModel.getJsrname());
                    map.put("taskContent",taskModel.getTaskContent());
                    map.put("createTime",cb.getCreatetime());
                    jmBean.setMsg_body(JSONObject.toJSONString(map));
                    ntService.sendJM(jmBean);

                    //发送信息提醒
                    MsgBean bean = new MsgBean();
                    String text = "催办任务:"+cb.getCreatename()+"催您尽快反馈任务，任务编号："+taskModel.getTaskNo();
                    bean.setMsgId(StringUtils.getUUID());
                    bean.setReceiverType(String.valueOf(Constants.ReceiveMessageType.TYPE_3));
                    bean.setMsgContent(text);
                    bean.setPublishId(cb.getCreator());
                    bean.setPublishName(cb.getCreatename());
                    List<SysUserInfo> userList=new ArrayList<>();
                    userList.add(user);
                    bean.setList(userList);
                    ntService.sendMsg(bean);
                } catch (NoticeException e){
                    //不做回滚
                    log.error("推送消息到移动端失败",e);
                }
            }
            return result;
        }catch (Exception e) {
            throw new BusinessException(BaseEnum.BusinessExceptionEnum.INSERT,e);
        }
    }
 }