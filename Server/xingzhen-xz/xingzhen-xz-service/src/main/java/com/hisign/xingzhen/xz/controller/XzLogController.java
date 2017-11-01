package com.hisign.xingzhen.xz.controller;

import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.constant.Constants;
import com.hisign.xingzhen.common.controller.BaseController;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.model.XzLogModel;
import com.hisign.xingzhen.xz.api.service.GroupService;
import com.hisign.xingzhen.xz.api.service.XzLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * 《日志》 rest服务类
 * @author 何建辉
 *
 */
@RestController
@RequestMapping("/xz/xzlog")
public class XzLogController extends BaseController {

	@Autowired
	private GroupService groupService;

	@Autowired
	private XzLogService xzLogService;

	/**
	 *@Author: 何建辉
	 *@Description: 添加最后聊天日志
	 *@Date: 2017/11/1 17:09
	 *@Email: hejianhui@hisign.com.cn
	 */
	@ApiOperation(value = "添加最后聊天日志",httpMethod ="POST",response = JsonResult.class)
	@RequestMapping(value = "/addChatLog", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	public JsonResult addNotNull(@RequestBody XzLog entity) throws BusinessException {
		return xzLogService.addNotNull(entity);
	}

	/**
	 *@Author: 何建辉
	 *@Description: 获取常用专案组
	 *@Date: 2017/11/1 17:09
	 *@Email: hejianhui@hisign.com.cn
	 */
	@ApiOperation(value = "获取常用专案组",httpMethod ="POST",response = JsonResult.class)
	 @RequestMapping(value = "/getCommonGroupList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	 public JsonResult getCommonGroupList(@RequestParam String userId){
		 Conditions conditions = new Conditions(XzLog.class);
		 Conditions.Criteria criteria = conditions.createCriteria();
		 //查找用户最近聊天的专案组列表
		 criteria.add(XzLog.XzLogEnum.creator.get(), BaseEnum.ConditionEnum.EQ,userId)
				 .add(XzLog.XzLogEnum.logType.get(), BaseEnum.ConditionEnum.EQ, Constants.XZLogType.CHAT)
				 .add(XzLog.XzLogEnum.deleteFlag.get(), BaseEnum.ConditionEnum.EQ,Constants.DELETE_FALSE);
		 //返回专案组id
		 conditions.setReturnFields(new String[]{XzLog.XzLogEnum.reserveField1.get()});
		 //根据创建时间倒排
		 conditions.setOrderByClause(XzLog.XzLogEnum.createTime.get(), BaseEnum.DESCEnum.DESC);
		 //获取6个
		 conditions.setLimit(0,6);
		 //获取专案组
		 List<XzLogModel> list = xzLogService.getList(conditions);

		 if (list==null || list.size()==0){
		 	return JsonResultUtil.success();
		 }

		 List<Object> groupIds = new ArrayList<>();
		 for (XzLogModel xzlog:list){
			 groupIds.add(xzlog.getReserveField1());
		 }

		 //获取专案组
		 Conditions condition1 = new Conditions(Group.class);
		 Conditions.Criteria criteria1 = condition1.createCriteria();
		 criteria1.add(Group.GroupEnum.id.get(), BaseEnum.IsInEnum.IN,groupIds)
				  .add(Group.GroupEnum.deleteflag.get(), BaseEnum.ConditionEnum.EQ,Constants.DELETE_FALSE);
		 condition1.setReturnFields(new String[]{Group.GroupEnum.id.get(),Group.GroupEnum.groupname.get()});
		 List<GroupModel> groupList = groupService.getList(condition1);
		 return JsonResultUtil.success(groupList);
	 }
}