package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.benum.BaseEnum;
import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.common.constant.Constants;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.xz.api.entity.XzLog;
import com.hisign.xingzhen.xz.api.model.XzLogModel;
import com.hisign.xingzhen.xz.api.service.GroupService;
import com.hisign.xingzhen.xz.api.service.XzLogService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


 /**
 * 《日志》 rest服务类
 * @author 何建辉
 *
 */
@RestController
public class XzLogRest extends BaseRest<XzLog, XzLogModel, String, XzLogService> {

	@Autowired
	private GroupService groupService;

	@Override
	@Autowired
	@Resource(name = "xzLogService")
	public void setBaseService(XzLogService baseService) {
		super.setBaseService(baseService);
	}


	 @ApiOperation(value = "获取常用专案组",httpMethod ="POST",response = JsonResult.class)
	 @RequestMapping(value = "/getCommonGroupList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	 public JsonResult getCommonGroupList(@ApiParam String userId){
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
		 //获取专案组
		 groupService.getList()
	 }
}