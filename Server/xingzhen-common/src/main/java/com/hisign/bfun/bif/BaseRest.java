package com.hisign.bfun.bif;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.bmodel.UpdateParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public abstract class BaseRest<T,M,PK,C extends BaseService<T,M, PK>> implements BaseService<T,M, PK> {
    protected C baseService;

    public static ThreadLocal<HttpServletRequest> Thread_Local_Request = new ThreadLocal<HttpServletRequest>();
    public static ThreadLocal<HttpServletResponse> Thread_Local_Response = new ThreadLocal<HttpServletResponse>();

    public void setBaseService(C baseService){
        this.baseService = baseService;
    }

    @Override
    @ApiOperation(value = "添加",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult add(@RequestBody T entity) throws BusinessException {
        return baseService.add(entity);
    }

    @Override
    @ApiOperation(value = "添加非空",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/addNotNull", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult addNotNull(@RequestBody T entity) throws BusinessException {
        return baseService.addNotNull(entity);
    }

    @Override
    @ApiOperation(value = "添加列表",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/addList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult add(@RequestBody List<T> list) throws BusinessException {
        return baseService.add(list);
    }

    @Override
    @ApiOperation(value = "更新",httpMethod ="PUT",response = JsonResult.class)
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult update(@RequestBody T entity) throws BusinessException {
        return baseService.update(entity);
    }

    @Override
    @ApiOperation(value = "更新非空",httpMethod ="PUT",response = JsonResult.class)
    @RequestMapping(value = "/updateNotNull", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult updateNotNull(@RequestBody T entity) throws BusinessException {
        return baseService.updateNotNull(entity);
    }

    @Override
    @ApiOperation(value = "批量更新",httpMethod ="PUT",response = JsonResult.class)
    @RequestMapping(value = "/updateBatch", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult updateBatch(@RequestBody List<T> entity) throws BusinessException {
        return baseService.updateBatch(entity);
    }

    @Override
    @ApiOperation(value = "自定义更新",httpMethod ="PUT",response = JsonResult.class)
    @RequestMapping(value = "/updateParams", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult update(@RequestBody UpdateParams params) throws BusinessException {
        return baseService.update(params);
    }

    @Override
    @ApiOperation(value = "根据id删除",httpMethod ="DELETE",response = JsonResult.class)
    @RequestMapping(value = "/delById", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult delById(@RequestParam(value="id") PK id) throws BusinessException {
        return baseService.delById(id);
    }

    @Override
    @ApiOperation(value = "根据id集合删除",httpMethod ="DELETE",response = JsonResult.class)
    @RequestMapping(value = "/delByIds", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult delByIds(@RequestBody List<PK> ids) throws BusinessException {
        return baseService.delByIds(ids);
    }

    @Override
    @ApiOperation(value = "自定义删除",httpMethod ="DELETE",response = JsonResult.class)
    @RequestMapping(value = "/delBy", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult delBy(@RequestBody Conditions conditions) throws BusinessException {
        return baseService.delBy(conditions);
    }

    @Override
    @ApiOperation(value = "根据id查询",httpMethod ="GET",response = JsonResult.class)
    @RequestMapping(value = "/getById", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public M getById(@RequestParam(value="id") PK id) {
        return baseService.getById(id);
    }

    @Override
    @ApiOperation(value = "根据id查询",httpMethod ="GET",response = JsonResult.class)
    @RequestMapping(value = "/getEntityById", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public T getEntityById(@RequestParam(value="id") PK id) throws InstantiationException, IllegalAccessException {
        return baseService.getEntityById(id);
    }

    @Override
    @ApiOperation(value = "根据对象获取",httpMethod ="GET",response = JsonResult.class)
    @RequestMapping(value = "/getByEntity", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public M getByEntity(@RequestBody T entity) {
        return baseService.getByEntity(entity);
    }

    @Override
    @ApiOperation(value = "获取列表",httpMethod ="GET",response = JsonResult.class)
    @RequestMapping(value = "/getList", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<M> getList(@RequestBody Conditions conditions) {
        return baseService.getList(conditions);
    }

    @Override
    @ApiOperation(value = "获取对象",httpMethod ="GET",response = JsonResult.class)
    @RequestMapping(value = "/getBy", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public M getBy(@RequestBody Conditions conditions) {
        return baseService.getBy(conditions);
    }

    @Override
    @ApiOperation(value = "获取数量",httpMethod ="GET",response = JsonResult.class)
    @RequestMapping(value = "/getCount", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Long getCount(@RequestBody Conditions conditions) {
        return baseService.getCount(conditions);
    }

    @Override
    @ApiOperation(value = "获取分页",httpMethod ="GET",response = JsonResult.class)
    @RequestMapping(value = "/getPage", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult getPage(@RequestBody Conditions conditions) {
        return baseService.getPage(conditions);
    }


    @Override
    @ApiOperation(value = "根据对象获取",httpMethod ="GET",response = JsonResult.class)
    @RequestMapping(value = "/getListByEntity", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult getListByEntity(@RequestBody T entity) {
        return baseService.getListByEntity(entity);
    }

    //==========================================================

    public static HttpServletRequest getRequest() {

        return Thread_Local_Request.get();
    }

    public static void setRequest(HttpServletRequest request) {

        Thread_Local_Request.set(request);
    }

    public static void removeRequest() {

        Thread_Local_Request.remove();
    }

    public static HttpServletResponse getResponse() {

        return Thread_Local_Response.get();
    }

    public static void setResponse(HttpServletResponse response) {

        Thread_Local_Response.set(response);
    }

    public static void removeResponse() {

        Thread_Local_Response.remove();
    }

}
