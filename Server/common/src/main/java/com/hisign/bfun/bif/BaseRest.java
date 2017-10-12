package com.hisign.bfun.bif;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.bmodel.UpdateParams;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public abstract class BaseRest<T,PK,C extends BaseService<T, PK>> implements BaseService<T, PK> {
    protected C baseService;

    public void setBaseService(C baseService){
        this.baseService = baseService;
    }

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult add(@RequestBody T entity) throws BusinessException {
        return baseService.add(entity);
    }

    @Override
    @RequestMapping(value = "/addNotNull", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult addNotNull(@RequestBody T entity) throws BusinessException {
        return baseService.addNotNull(entity);
    }

    @Override
    @RequestMapping(value = "/addList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult add(@RequestBody List<T> list) throws BusinessException {
        return baseService.add(list);
    }

    @Override
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult update(@RequestBody T entity) throws BusinessException {
        return baseService.update(entity);
    }

    @Override
    @RequestMapping(value = "/updateNotNull", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult updateNotNull(@RequestBody T entity) throws BusinessException {
        return baseService.updateNotNull(entity);
    }

    @Override
    @RequestMapping(value = "/updateBatch", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult updateBatch(@RequestBody List<T> entity) throws BusinessException {
        return baseService.updateBatch(entity);
    }

    @Override
    @RequestMapping(value = "/updateParams", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult update(@RequestBody UpdateParams params) throws BusinessException {
        return baseService.update(params);
    }

    @Override
    @RequestMapping(value = "/delById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult delById(@RequestBody PK id) throws BusinessException {
        return baseService.delById(id);
    }

    @Override
    @RequestMapping(value = "/delByIds", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult delByIds(@RequestBody List<PK> ids) throws BusinessException {
        return baseService.delByIds(ids);
    }

    @Override
    @RequestMapping(value = "/delBy", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult delBy(@RequestBody Conditions conditions) throws BusinessException {
        return baseService.delBy(conditions);
    }

    @Override
    @RequestMapping(value = "/getById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public T getById(@RequestBody PK id) {
        return baseService.getById(id);
    }

    @Override
    @RequestMapping(value = "/getByEntity", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public T getByEntity(@RequestBody T entity) {
        return baseService.getByEntity(entity);
    }

    @Override
    @RequestMapping(value = "/getList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<T> getList(@RequestBody Conditions conditions) {
        return baseService.getList(conditions);
    }

    @Override
    @RequestMapping(value = "/getBy", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public T getBy(@RequestBody Conditions conditions) {
        return baseService.getBy(conditions);
    }

    @Override
    @RequestMapping(value = "/getCount", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Long getCount(@RequestBody Conditions conditions) {
        return baseService.getCount(conditions);
    }

    @Override
    @RequestMapping(value = "/getPage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult getPage(@RequestBody Conditions conditions) {
        return baseService.getPage(conditions);
    }
}
