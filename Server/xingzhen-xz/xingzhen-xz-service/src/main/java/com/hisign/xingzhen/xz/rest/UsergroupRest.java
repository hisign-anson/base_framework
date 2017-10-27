package com.hisign.xingzhen.xz.rest;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.sys.api.model.SysUserInfo;
import com.hisign.xingzhen.xz.api.entity.Usergroup;
import com.hisign.xingzhen.xz.api.model.UsergroupModel;
import com.hisign.xingzhen.xz.api.param.SysUserInfoParam;
import com.hisign.xingzhen.xz.api.service.UsergroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
public class UsergroupRest extends BaseRest<Usergroup,UsergroupModel, String, UsergroupService> implements UsergroupService{

    @Override
    @Autowired
    @Resource(name = "usergroupService")
    public void setBaseService(UsergroupService baseService) {
        super.setBaseService(baseService);
    }

    @ApiOperation(value = "关联组内成员",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/addUserGroupList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult addUserGroupList(@Valid @RequestBody List<Usergroup> usergroupList, BindingResult result) throws BusinessException {
        JsonResult jr = handleResult(result);
        if (jr.getFlag()!=1){
            return jr;
        }
        return baseService.add(usergroupList);
    }

    /**
     * 移除组内成员
     * @param usergroup
     * @return
     */
    @Override
    @ApiOperation(value = "移除组内成员列表",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/deleteUsergroupList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult deleteUsergroupList(@RequestBody List<Usergroup> usergroup) {
        return baseService.deleteUsergroupList(usergroup);
    }

    /**
     * 组内成员分页
     * @param info
     * @return
     */
    @ApiOperation(value = "用户列表/组内成员列表",notes = "groupId传，就是组内成员列表",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/getUsergroupPage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getUsergroupPage(@RequestBody SysUserInfoParam info){
        JsonResult result = baseService.getUsergroupPage(info);
        return result;
    }

    @ApiOperation(value = "首页成果详情-获取所有组内成员",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/getGroupMemberList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getGroupMemberList(@RequestParam String groupId){
        JsonResult result = baseService.getGroupMemberList(groupId);
        if (result.getFlag()==1){

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