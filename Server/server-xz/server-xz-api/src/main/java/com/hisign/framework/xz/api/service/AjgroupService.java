
package com.hisign.framework.xz.api.service;

import com.hisign.framework.xz.api.entity.Ajgroup;
import com.hisign.bfun.bif.BaseService;
import com.hisign.framework.xz.api.model.AjgroupModel;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 《案件专案组关联》 业务逻辑服务接口
 * @author 何建辉
 */
public interface AjgroupService extends BaseService<Ajgroup,AjgroupModel, String>{

}