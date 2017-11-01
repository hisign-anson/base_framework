package com.hisign.bfun.bif;

import com.hisign.bfun.benum.BaseEnum.BusinessExceptionEnum;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class BaseServiceImpl<T,M,PK> implements BaseService<T,M, PK>{

	private BaseMapper<T,M, PK> mapper;

	protected Class<T> entityClass;

	protected Class<M> modelClass;
	
	protected abstract BaseMapper<T,M, PK> initMapper();

	public BaseServiceImpl(){
		fillInClass();
	}

	public void fillInClass(){
		this.entityClass = null;
		this.modelClass = null;
		Class c = this.getClass();
		//获取父类
		Type type = c.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			//获取泛型参数类型
			Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
			//获取实体类型
			this.entityClass = (Class<T>) parameterizedType[0];
			//获取vo类型
			this.modelClass = (Class<M>) parameterizedType[1];
		}
	}
	
	private BaseMapper<T,M, PK> getMapper(){
		if (mapper==null) {
			mapper = initMapper();
		}
		if (this.entityClass==null && this.modelClass==null){
			fillInClass();
		}
		return mapper;
	}
	
	@Override
	public JsonResult add(T entity) throws BusinessException{
		try {
			long i = getMapper().insert(entity);
			if (i<1) {
				return error("添加记录失败,请稍后再试");
			}
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionEnum.INSERT,e);
		}
		return success();
	}

	@Override
	public JsonResult addNotNull(T entity) throws BusinessException{
		try {
			long i = getMapper().insertNotNull(entity);
			if (i<1) {
				return error("添加记录失败,请稍后再试");
			}
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionEnum.INSERT,e);
		}
		return success();
	}
	
	@Override
	public JsonResult update(T entity) throws BusinessException{
		try {
			long i = getMapper().update(entity);
			if (i<1) {
				return error("更新记录失败,请稍后再试");
			}
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionEnum.UPDATE,e);
		}
		return success();
	}

	@Override
	public JsonResult updateNotNull(T entity) throws BusinessException{
		try {
			long i = getMapper().updateNotNull(entity);
			if (i<1) {
				return error("更新记录失败,请稍后再试");
			}
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionEnum.UPDATE,e);
		}
		return success();
	}
	
	@Override
	public JsonResult updateBatch(List<T> list) throws BusinessException{
		try {
			long i = getMapper().updateBatch(list);
			if (i<1) {
				return error("更新记录失败,请稍后再试");
			}
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionEnum.UPDATE,e);
		}
		return success();
	}

	@Override
	public JsonResult delById(PK id) throws BusinessException{
		try {
			long i = getMapper().deleteById(id);
			if (i<1) {
				return error("删除记录失败,请稍后再试");
			}
		} catch (Exception e) {
			throw new BusinessException(BusinessExceptionEnum.DELETE,e);
		}
		return success();
	}

	@Override
	public M getById(PK id) {
		return getMapper().findById(id);
	}


	@Override
	public T getEntityById(PK id) throws IllegalAccessException, InstantiationException {
		M model = getMapper().findById(id);
		T entity = entityClass.newInstance();
		BeanUtils.copyProperties(model,entity);
		return entity;
	}

	@Override
	public M getByEntity(T entity) {
		return getMapper().findByEntity(entity);
	}
	
	@Override
	public Long getCount(Conditions condition) {
		return getMapper().findCount(condition);
	}

	@Override
	public List<M> getList(Conditions condition) {
		return getMapper().findList(condition);
	}

	@Override
	public M getBy(Conditions condition) {
		return getMapper().findByCondition(condition);
	}

	@Override
	public JsonResult getPage(Conditions condition) {
		List<M> list = getMapper().findList(condition);
		Long num = getMapper().findCount(condition);
		return success(num,list);
	}
	
	//-------------------------------------------------------
	
	public static JsonResult success(Object data) {
    	JsonResult jsonResult = new JsonResult();
        jsonResult.setFlag(1);
        jsonResult.setData(data);
        return jsonResult;
    }
	
	public static JsonResult success(long num,Object data) {
		JsonResult jsonResult = new JsonResult();
        jsonResult.setFlag(1);
        jsonResult.setTotalCount(num);
        jsonResult.setData(data);
        return jsonResult;
    }

    public static JsonResult success() {
    	JsonResult jsonResult = new JsonResult();
        jsonResult.setFlag(1);
        return jsonResult;
    }
    
    public static JsonResult error(String msg) {
    	JsonResult jsonResult = new JsonResult();
        jsonResult.setFlag(0);
        jsonResult.setMsg(msg);
        return jsonResult;
    }

    @Override
    public JsonResult getListByEntity(@RequestBody T entity) {
        List<M> list = getMapper().findListByEntity(entity);
        return success(list);
    }
}
