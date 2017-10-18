package com.hisign.xingzhen.sys.rest;

import com.hisign.xingzhen.sys.api.model.SysParam;
import com.hisign.xingzhen.sys.api.model.SysParamConfig;
import com.hisign.xingzhen.sys.api.service.SysParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/sys/sysParameterService")
@RestController
public class SysParameterRest implements SysParameterService {

    @Autowired
    @Resource(name = "sysParameterService")
    private SysParameterService sysParameterService;

    @Override
    @RequestMapping(value = "/findSysConfigList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysParam> findSysConfigList() throws Exception {
        return sysParameterService.findSysConfigList();
    }

    @Override
    @RequestMapping(value = "/findSysParamConfigList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<SysParamConfig> findSysParamConfigList() throws Exception {
        return sysParameterService.findSysParamConfigList();
    }

    @Override
    @RequestMapping(value = "/insertSysParameter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insertSysParameter(@RequestBody SysParam sysParam) throws Exception {
        return sysParameterService.insertSysParameter(sysParam);
    }

    @Override
    @RequestMapping(value = "/editSysParameter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public void editSysParameter(@RequestBody List<SysParam> sysParams) throws Exception {
        sysParameterService.editSysParameter(sysParams);
    }

    @Override
    @RequestMapping(value = "/findSysDictValueByRootKey", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<String> findSysDictValueByRootKey(@RequestParam(value = "str") String str) throws Exception {
        return sysParameterService.findSysDictValueByRootKey(str);
    }

    @Override
    @RequestMapping(value = "/getParamByName", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SysParam getParamByName(@RequestParam(value = "enName") String enName) {
        return sysParameterService.getParamByName(enName);
    }

    @Override
    @RequestMapping(value = "/updateSysParameter", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String updateSysParameter(@RequestBody SysParam sysParam) throws Exception {
        return sysParameterService.updateSysParameter(sysParam);
    }
}
