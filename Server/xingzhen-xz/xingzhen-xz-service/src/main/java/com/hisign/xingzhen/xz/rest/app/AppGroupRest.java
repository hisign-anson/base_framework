package com.hisign.xingzhen.xz.rest.app;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bif.BaseRest;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.Group;
import com.hisign.xingzhen.xz.api.model.GroupModel;
import com.hisign.xingzhen.xz.api.param.GroupParam;
import com.hisign.xingzhen.xz.api.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


/**
 * 《专案组》 rest服务类
 *
 * @author 何建辉
 */
@Api(description = "App专案组")
@RestController
@RequestMapping("/xz/app/group")
public class AppGroupRest {

    @Autowired
    private GroupService groupService;

    /**
     * 查询分页
     * @param groupParam 专案组
     * @return 返回JsonResult
     */
    @ApiOperation(value = "专案组查询分页",httpMethod ="POST",response = GroupModel.class)
    @RequestMapping(value = "/getGroupPage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getGroupPage(@RequestBody GroupParam groupParam) {
        JsonResult result = groupService.getGroupPage(groupParam);
        if (result.getFlag()==1){
            List<GroupModel> parentList = (List<GroupModel>) result.getData();
            if (parentList!=null && parentList.size()!=0){
                for (GroupModel groupModel : parentList) {
                    JsonResult jr = groupService.getChildGroupList(groupModel.getId());
                    if (jr.getFlag()==1){
                        List<GroupModel> chlidList = (List<GroupModel>) jr.getData();
                        if (chlidList!=null && chlidList.size()!=0){
                            groupModel.setChildGroupList(chlidList);
                        }
                    }
                }
                result.setData(parentList);
            }
        }
        return result;
    }

}