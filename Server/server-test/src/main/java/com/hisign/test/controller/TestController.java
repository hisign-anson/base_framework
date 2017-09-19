package com.hisign.test.controller;

import com.hisign.shuwu.sys.api.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private SysDictService sysDicService;

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public void test(){
        sysDicService.getGuid();
    }
}
