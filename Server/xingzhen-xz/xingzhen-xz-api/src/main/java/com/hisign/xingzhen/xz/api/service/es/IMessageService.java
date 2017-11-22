package com.hisign.xingzhen.xz.api.service.es;

import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.xz.api.entity.IMessage;
import com.hisign.xingzhen.xz.api.param.IMessageParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 16:15 2017/11/16
 */
@FeignClient(name = "xzService",path = "/xz/iMessageService")
public interface IMessageService {

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    void save(@RequestBody List<IMessage> message);

    @RequestMapping(value = "/findBy", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    JsonResult findByPage(@RequestBody IMessageParam msg);


}
