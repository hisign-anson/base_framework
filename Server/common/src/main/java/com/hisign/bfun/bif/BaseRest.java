package com.hisign.bfun.bif;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.bmodel.UpdateParams;

import java.util.List;

public abstract class BaseRest<T,PK,C extends BaseService<T, PK>> implements BaseService<T, PK> {
    protected C baseService;

    public void setBaseService(C baseService){
        this.baseService = baseService;
    }

    @Override
    public JsonResult add(T entity) throws BusinessException {
        return baseService.add(entity);
    }

    @Override
    public JsonResult addNotNull(T entity) throws BusinessException {
        return baseService.addNotNull(entity);
    }

    @Override
    public JsonResult add(List<T> list) throws BusinessException {
        return baseService.add(list);
    }

    @Override
    public JsonResult update(T entity) throws BusinessException {
        return baseService.update(entity);
    }

    @Override
    public JsonResult updateNotNull(T entity) throws BusinessException {
        return baseService.updateNotNull(entity);
    }

    @Override
    public JsonResult updateBatch(List<T> entity) throws BusinessException {
        return baseService.updateBatch(entity);
    }

    @Override
    public JsonResult update(UpdateParams params) throws BusinessException {
        return baseService.update(params);
    }

    @Override
    public JsonResult delById(PK id) throws BusinessException {
        return baseService.delById(id);
    }

    @Override
    public JsonResult delByIds(List<PK> ids) throws BusinessException {
        return baseService.delByIds(ids);
    }

    @Override
    public JsonResult delBy(Conditions conditions) throws BusinessException {
        return baseService.delBy(conditions);
    }

    @Override
    public T getById(PK id) {
        return baseService.getById(id);
    }

    @Override
    public T getByEntity(T entity) {
        return baseService.getByEntity(entity);
    }

    @Override
    public List<T> getList(Conditions conditions) {
        return baseService.getList(conditions);
    }

    @Override
    public T getBy(Conditions conditions) {
        return baseService.getBy(conditions);
    }

    @Override
    public Long getCount(Conditions conditions) {
        return baseService.getCount(conditions);
    }

    @Override
    public JsonResult getPage(Conditions conditions) {
        return baseService.getPage(conditions);
    }
}
