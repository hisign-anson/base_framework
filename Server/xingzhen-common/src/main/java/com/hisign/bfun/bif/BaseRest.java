package com.hisign.bfun.bif;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.bmodel.UpdateParams;
import com.hisign.bfun.butils.JsonResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class BaseRest<T,M,PK,C extends BaseService<T,M, PK>> implements BaseService<T,M, PK> {
    protected C baseService;

    public static ThreadLocal<HttpServletRequest> Thread_Local_Request = new ThreadLocal<HttpServletRequest>();
    public static ThreadLocal<HttpServletResponse> Thread_Local_Response = new ThreadLocal<HttpServletResponse>();

    public void setBaseService(C baseService){
        this.baseService = baseService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

    @Override
    @ApiOperation(value = "添加",httpMethod ="POST",response = JsonResult.class,hidden = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult add(@RequestBody T entity) throws BusinessException {
        return baseService.add(entity);
    }

    @Override
    @ApiOperation(value = "添加非空",httpMethod ="POST",response = JsonResult.class,hidden = true)
    @RequestMapping(value = "/addNotNull", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult addNotNull(@RequestBody T entity) throws BusinessException {
        return baseService.addNotNull(entity);
    }

    @Override
    @ApiOperation(value = "添加列表",httpMethod ="POST",response = JsonResult.class,hidden = true)
    @RequestMapping(value = "/addList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult add(@RequestBody List<T> list) throws BusinessException {
        return baseService.add(list);
    }

    @Override
    @ApiOperation(value = "更新",httpMethod ="PUT",response = JsonResult.class,hidden = true)
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult update(@RequestBody T entity) throws BusinessException {
        return baseService.update(entity);
    }

    @Override
    @ApiOperation(value = "更新非空",httpMethod ="PUT",response = JsonResult.class,hidden = true)
    @RequestMapping(value = "/updateNotNull", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult updateNotNull(@RequestBody T entity) throws BusinessException {
        return baseService.updateNotNull(entity);
    }

    @Override
    @ApiOperation(value = "批量更新",httpMethod ="PUT",response = JsonResult.class,hidden = true)
    @RequestMapping(value = "/updateBatch", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult updateBatch(@RequestBody List<T> entity) throws BusinessException {
        return baseService.updateBatch(entity);
    }

    @Override
    @ApiOperation(value = "自定义更新",httpMethod ="PUT",response = JsonResult.class,hidden = true)
    @RequestMapping(value = "/updateParams", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public JsonResult update(@RequestBody UpdateParams params) throws BusinessException {
        return baseService.update(params);
    }

    @Override
    @ApiOperation(value = "根据id删除",httpMethod ="DELETE",response = JsonResult.class,hidden = true)
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public JsonResult delById(@PathVariable(value="id") PK id) throws BusinessException {
        return baseService.delById(id);
    }

    @Override
    @ApiOperation(value = "根据id集合删除",httpMethod ="DELETE",response = JsonResult.class,hidden = true)
    @RequestMapping(value = "/delByIds", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public JsonResult delByIds(@RequestBody List<PK> ids) throws BusinessException {
        return baseService.delByIds(ids);
    }

    @Override
    @ApiOperation(value = "自定义删除",httpMethod ="DELETE",response = JsonResult.class,hidden = true)
    @RequestMapping(value = "/delBy", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public JsonResult delBy(@RequestBody Conditions conditions) throws BusinessException {
        return baseService.delBy(conditions);
    }

    @Override
    @ApiOperation(value = "根据id查询",response = JsonResult.class)
    @RequestMapping(value = "/getById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public M getById(@RequestParam(value="id") PK id) {
        return baseService.getById(id);
    }

    @Override

    @ApiOperation(value = "根据id查询",response = JsonResult.class)
    @RequestMapping(value = "/getEntityById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public T getEntityById(@RequestParam(value="id") PK id) throws InstantiationException, IllegalAccessException {
        return baseService.getEntityById(id);
    }

    @Override
    @ApiOperation(value = "根据对象获取",response = JsonResult.class,hidden = true)
    @RequestMapping(value = "/getByEntity", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public M getByEntity(@RequestBody T entity) {
        return baseService.getByEntity(entity);
    }

    @Override

    @ApiOperation(value = "获取列表",response = JsonResult.class,hidden = true)
    @RequestMapping(value = "/getList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public List<M> getList(@RequestBody Conditions conditions) {
        return baseService.getList(conditions);
    }

    @Override


    @ApiOperation(value = "获取对象",response = JsonResult.class,hidden = true)
    @RequestMapping(value = "/getBy", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public M getBy(@RequestBody Conditions conditions) {
        return baseService.getBy(conditions);
    }

    @Override


    @ApiOperation(value = "获取数量",response = JsonResult.class,hidden = true)
    @RequestMapping(value = "/getCount", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Long getCount(@RequestBody Conditions conditions) {
        return baseService.getCount(conditions);
    }

    @Override


    @ApiOperation(value = "获取分页",response = JsonResult.class,hidden = true)
    @RequestMapping(value = "/getPage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getPage(@RequestBody Conditions conditions) {
        return baseService.getPage(conditions);
    }


    @Override
    @ApiOperation(value = "根据对象获取",response = JsonResult.class,hidden = true)
    @RequestMapping(value = "/getListByEntity", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getListByEntity(@RequestBody T entity) {
        return baseService.getListByEntity(entity);
    }

    /**
     * 处理校验结果
     * @param result
     * @return
     */
    protected JsonResult handleResult(BindingResult result){
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= list.size(); i++) {
                sb.append(i).append("、").append(list.get(i-1).getDefaultMessage()).append("  ");
            }
            return JsonResultUtil.error(sb.toString());
        }else{
            return JsonResultUtil.success();
        }
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
