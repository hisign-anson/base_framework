package com.hisign.bfun.bif;

import java.util.List;

import com.hisign.bfun.benum.BaseEnum.BusinessExceptionEnum;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.Conditions;
import com.hisign.bfun.bmodel.JsonResult;

public abstract class BaseServiceImpl<T,PK> implements BaseService<T, PK>{
	
	private BaseMapper<T, PK> mapper;
	
	protected abstract BaseMapper<T, PK> initMapper();
	
	private BaseMapper<T, PK> getMapper(){
		if (mapper==null) {
			mapper = initMapper();
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
	public T getById(PK id) {
		return getMapper().findById(id);
	}
	
	@Override
	public T getByEntity(T entity) {
		return getMapper().findByEntity(entity);
	}
	
	@Override
	public Long getCount(Conditions condition) {
		return getMapper().findCount(condition);
	}

	@Override
	public List<T> getList(Conditions condition) {
		return getMapper().findList(condition);
	}

	@Override
	public T getBy(Conditions condition) {
		return getMapper().findByCondition(condition);
	}

	@Override
	public JsonResult getPage(Conditions condition) {
		List<T> list = getMapper().findList(condition);
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

}
