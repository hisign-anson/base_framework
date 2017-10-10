package com.hisign.framework.sys.api.service;

import java.util.List;

import com.hisign.framework.sys.api.model.SysParam;
import com.hisign.framework.sys.api.model.SysParamConfig;


/**
 * @author lqf
 * @Date 2017年4月1日
 */
public interface SysParameterService {

    /**
     * 查询系统参数配置
     */
     public List<SysParam> findSysConfigList() throws Exception;

    /**
     * 查询系统参数分组配置
     */
    public List<SysParamConfig> findSysParamConfigList() throws Exception;

    /**
     * 插入系统参数
     */
    public String insertSysParameter(SysParam sysParam) throws Exception;

    /**
     * 修改系统参数
     */
    public void editSysParameter(List<SysParam> sysParams) throws Exception;

    /**
     * 查询字典中文
     */
    public List<String> findSysDictValueByRootKey(String str) throws Exception;
    
    /**
     * 根据英文名查找参数实体
     */
    public SysParam getParamByName(String enName);

    /**
     * 更新系统参数
     */
    public String updateSysParameter(SysParam sysParam) throws Exception;
}
