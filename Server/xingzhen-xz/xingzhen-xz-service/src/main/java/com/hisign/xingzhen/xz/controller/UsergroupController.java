package com.hisign.xingzhen.xz.controller;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.controller.BaseController;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.xz.api.entity.Usergroup;
import com.hisign.xingzhen.sys.api.param.SysUserInfoParam;
import com.hisign.xingzhen.xz.api.service.UsergroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 《人员专案组关联》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "人员专案组关联")
@RestController
@RequestMapping("/xz/usergroup")
public class UsergroupController extends BaseController {

    @Autowired
    private UsergroupService usergroupService;

    /**
     *@Author: 何建辉
     *@Description: 关联组内成员
     *@Date: 2017/11/1 17:08
     *@Email: hejianhui@hisign.com.cn
     */
    @ApiOperation(value = "关联组内成员",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/addUserGroupList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult addUserGroupList(@Valid @RequestBody List<Usergroup> usergroupList, BindingResult result) throws BusinessException {
        JsonResult jr = handleResult(result);
        if (!jr.isSuccess()){
            return jr;
        }
        return usergroupService.add(usergroupList);
    }

    /**
     *@Author: 何建辉
     *@Description: 移除组内成员列表
     *@Date: 2017/11/1 17:09
     *@Email: hejianhui@hisign.com.cn
     */
    @ApiOperation(value = "移除组内成员列表",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/deleteUsergroupList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult deleteUsergroupList(@RequestBody List<Usergroup> usergroup) {
        if (usergroup==null){
            return JsonResultUtil.error("请选择成员");
        }
        return usergroupService.deleteUsergroupList(usergroup);
    }

    /**
     *@Author: 何建辉
     *@Description: 用户列表/组内成员列表
     *@Date: 2017/11/1 17:09
     *@Email: hejianhui@hisign.com.cn
     */
    @ApiOperation(value = "用户列表/组内成员列表",notes = "groupId传，就是组内成员列表",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/getUsergroupPage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getUsergroupPage(@RequestBody SysUserInfoParam info){

        JsonResult result = usergroupService.getUsergroupPage(info);
        return result;
    }

    /**
     *@Author: 何建辉
     *@Description: 用户列表/组内成员列表 -app查询用户
     *@Date: 2017/11/1 17:09
     *@Email: hejianhui@hisign.com.cn
     */
    @ApiOperation(value = "用户列表/组内成员列表 -app查询用户",notes = "groupId传，并且isInGroup=true是组内，false是组外，searchValue查询警号，电话，地址，用户名，组织机构",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/getUsergroupPageByKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getUsergroupPageByKey(@RequestBody SysUserInfoParam info){
        JsonResult result = usergroupService.getUserInfoListByKey(info);
        return result;
    }

    /**
     *@Author: 何建辉
     *@Description: 首页成果详情-获取所有组内成员
     *@Date: 2017/11/1 17:09
     *@Email: hejianhui@hisign.com.cn
     */
    @ApiOperation(value = "首页成果详情-获取所有组内成员",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/getGroupMemberList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getGroupMemberList(@RequestParam String groupId){
        JsonResult result = usergroupService.getGroupMemberList(groupId);
        if (result.isSuccess()){

            List<SysUserInfo> parentUserList = new ArrayList<SysUserInfo>();
            List<SysUserInfo> childUserList = new ArrayList<SysUserInfo>();

            List<SysUserInfo> list = (List<SysUserInfo>) result.getData();

            if (list!=null && list.size()!=0){
                //转成前端结构
                for(SysUserInfo user : list){
                    //找出父专案组
                    if (StringUtils.isEmpty(user.getPgroupId())){
                        parentUserList.add(user);
                    }else {
                        childUserList.add(user);
                    }
                }

                List<List<SysUserInfo>> perChildGroupUserList = new ArrayList<>(childUserList.size());
                if (childUserList!=null && childUserList.size()!=0){
                    for (int i=0 ; i < childUserList.size();i++){
                        List<SysUserInfo> perList = new ArrayList<SysUserInfo>();
                        for (SysUserInfo u:childUserList){
                            if (perList.size()==0){
                                perList.add(u);
                            }else {
                                if (perList.get(0).getGroupId().equals(u.getGroupId())){
                                    perList.add(u);
                                }
                            }
                        }
                        //从子专案组成员中移除已分好的小组成员
                        childUserList.removeAll(perList);
                        perChildGroupUserList.add(perList);
                    }
                }

                Map<String, Object> map = new HashMap<>();
                map.put("parent",parentUserList);
                map.put("childs",perChildGroupUserList);
                result.setData(map);
                return result;
            }
        }
        return result;
    }

}