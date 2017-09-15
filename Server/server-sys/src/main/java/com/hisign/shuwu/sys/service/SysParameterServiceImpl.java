package com.hisign.shuwu.sys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hisign.shuwu.sys.api.model.SysParam;
import com.hisign.shuwu.sys.api.model.SysParamConfig;
import com.hisign.shuwu.sys.api.service.SysParameterService;
import com.hisign.shuwu.sys.mapper.SysParameterMapper;



/**
 * @author lqf
 * @Date 2017年4月1日
 */
@Service("sysParameterService")
public class SysParameterServiceImpl implements SysParameterService {

    /**
     * 系统参数管理Mapper
     */
    @Resource
    protected SysParameterMapper sysParameterMapper;

    /**
     * 查找所有配置
     */
    @Override
    public List<SysParam> findSysConfigList() throws Exception {
        return  sysParameterMapper.findSysConfigList();
    }

    /**
     * 查询系统参数分组配置
     */
    @Override
    public List<SysParamConfig> findSysParamConfigList() throws Exception {
        return sysParameterMapper.findSysParamConfigList();
    }

    /**
     * 新增系统参数
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String insertSysParameter(SysParam sysParam) throws Exception {
    	int count = sysParameterMapper.checkSysParameter(sysParam.getEnglishName(), sysParam.getConfigId());
    	if(count > 0){
    		return "error";
    	}
    	if ("".equals(sysParam.getValue().trim())) {
            sysParam.setValue(sysParam.getDefaultValue());
        }
        sysParameterMapper.insertSysParameter(sysParam);
        return "success";
    }

    /**
     * 更新系统参数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateSysParameter(SysParam sysParam) throws Exception {
    	SysParam oldParam = sysParameterMapper.findSysParameterById(sysParam.getParamEditId());
    	if(!oldParam.getEnglishName().equals(sysParam.getEnglishName())){
    		int count = sysParameterMapper.checkSysParameter(sysParam.getEnglishName(),sysParam.getConfigId());
    		if(count > 0){
    			return "error";
    		}
    	}
        sysParameterMapper.updateSysParameterConfig(sysParam);
        return "success";
    }

    /**
     * 修改系统参数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editSysParameter(List<SysParam> sysParams) throws Exception {
        sysParameterMapper.batchUpdateSysParameter(sysParams);
    }

    /**
     * 查询字典值
     */
    @Override
    public List<String> findSysDictValueByRootKey(String str) throws Exception {
        return sysParameterMapper.findSysDictValueByRootKey(str);
    }

	@Override
	public SysParam getParamByName(String enName) {
		return sysParameterMapper.getParamByName(enName);
	}
}
