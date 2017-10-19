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

public interface BaseService<T,M,PK> {
	
	/**
	 * 保存对象
	 * 
	 * @param entity
	 *            
	 * @return id 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public abstract JsonResult add(@RequestBody T entity) throws BusinessException;

	/**
	 * @category 为空的不添加，效率最高 
	 * @param entity
	 * @return
	 * @time 2016年10月11日 下午9:55:59
	 */
	@RequestMapping(value = "/addNotNull", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public abstract JsonResult addNotNull(@RequestBody T entity) throws BusinessException;

	/**
	 * 批量保存对象
	 * 
	 * @param entity
	 *            
	 * @return id 
	 */
	@RequestMapping(value = "/addList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public abstract JsonResult add(@RequestBody List<T> list) throws BusinessException;
	
	/**
	 * 根据主键更新对象
	 * 
	 * @param entity
	 *            
	 * @return int 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public abstract JsonResult update(@RequestBody T entity) throws BusinessException;

	/**
	 * @category 更新不为空的值 效率最高 
	 * @param entity
	 * @return
	 * @time 2016年10月11日 下午9:58:43
	 */
	@RequestMapping(value = "/updateNotNull", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public abstract JsonResult updateNotNull(@RequestBody T entity) throws BusinessException;
	
	/**
	 * @category 更新不为空的值 效率最高 
	 * @param entity
	 * @return
	 * @time 2016年10月11日 下午9:58:43
	 */
	@RequestMapping(value = "/updateBatch", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public abstract JsonResult updateBatch(@RequestBody List<T> entity) throws BusinessException;

	/**
	 * @category 自定义更新 
	 * @param params
	 * @return
	 * @time 2016年10月13日 下午5:18:52
	 */
	@RequestMapping(value = "/updateParams", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public abstract JsonResult update(@RequestBody UpdateParams params) throws BusinessException;

	/**
	 * @category 根据主键删除，慎用
	 * @param params
	 * @return
	 * @time 2016年10月13日 下午5:18:52
	 */
	@RequestMapping(value = "/delById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public abstract JsonResult delById(@RequestBody PK id) throws BusinessException;

	/**
	 * @category 根据主键批量删除，慎用
	 * @param ids
	 * @return
	 * @time 2016年10月14日 下午4:50:14
	 */
	@RequestMapping(value = "/delByIds", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public abstract JsonResult delByIds(@RequestBody List<PK> ids) throws BusinessException;

	/**
	 * @category 自定义删除，慎用 
	 * @param conditions
	 * @return
	 * @time 2016年10月14日 下午4:54:06
	 */
	@RequestMapping(value = "/delBy", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public abstract JsonResult delBy(@RequestBody Conditions conditions) throws BusinessException;

	/**
	 * @category 根据主键查询
	 * @param params
	 * @return
	 * @time 2016年10月13日 下午5:18:52
	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public abstract M getById(@RequestBody PK id);

	/**
	 * @category 根据主键查询
	 * @param params
	 * @return
	 * @time 2016年10月13日 下午5:18:52
	 */
	@RequestMapping(value = "/getEntityById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public T getEntityById(PK id) throws IllegalAccessException, InstantiationException;
	
	/**
	 * @category 根据主键查询
	 * @param params
	 * @return
	 * @time 2016年10月13日 下午5:18:52
	 */
	@RequestMapping(value = "/getByEntity", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public abstract M getByEntity(@RequestBody T entity);

	/**
	 * @category 自定义查询
	 * @param params
	 * @return
	 * @time 2016年10月13日 下午5:18:52
	 */
	@RequestMapping(value = "/getList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public abstract List<M> getList(@RequestBody Conditions conditions);

	/**
	 * @category 自定义查询
	 * @param params
	 * @return
	 * @time 2016年10月13日 下午5:18:52
	 */
	@RequestMapping(value = "/getBy", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public abstract M getBy(@RequestBody Conditions conditions);
	
	/**
	 * @category 获取数量 
	 * @param condition
	 * @return
	 * @time 2016年10月18日 下午2:21:02
	 */
	@RequestMapping(value = "/getCount", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public abstract Long getCount(@RequestBody Conditions conditions);

	/**
	 * @category 分页 
	 * @param condition
	 * @param page
	 * @return
	 * @time 2016年10月14日 下午8:13:05
	 */
	@RequestMapping(value = "/getPage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public abstract JsonResult getPage(@RequestBody Conditions conditions);

}
