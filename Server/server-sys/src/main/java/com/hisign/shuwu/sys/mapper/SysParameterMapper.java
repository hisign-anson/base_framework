package com.hisign.shuwu.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hisign.shuwu.sys.api.model.SysParam;
import com.hisign.shuwu.sys.api.model.SysParamConfig;


/**
 * @author lqf
 * @Date 2017年4月1日
 */
public interface SysParameterMapper {

    /**
     * 计入系统参数管理页面
     * @return
     */
    public List<SysParam> findSysConfigList() ;

    /**
     * 查询系统参数分组配置
     */
    public List<SysParamConfig> findSysParamConfigList() ;

    /**
     * 新增系统管理参数
     */
    public void insertSysParameter(SysParam sysParam);


    /**
     * 检查参数是否存在
     */
    public int checkSysParameter(@Param("englishName") String englishName, @Param("configId") String configId);

    /**
     * 字典查询
     * @return
     */
    public List<String> findSysDictValueByRootKey(String str);
    
    /**
     * 根据英文名查找参数实体
     */
    public SysParam getParamByName(String enName);

    /**
     * 更新系统参数
     */
    public void updateSysParameterConfig(SysParam sysParam);

	public SysParam findSysParameterById(@Param("id") String id);

	public void batchUpdateSysParameter(List<SysParam> sysParams);
    
}
