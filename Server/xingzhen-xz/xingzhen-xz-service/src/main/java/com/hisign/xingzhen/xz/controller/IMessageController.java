package com.hisign.xingzhen.xz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hisign.bfun.bexception.BusinessException;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.xingzhen.common.controller.BaseController;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.nt.api.model.JMessage;
import com.hisign.xingzhen.nt.api.service.NtService;
import com.hisign.xingzhen.xz.api.entity.IMessage;
import com.hisign.xingzhen.xz.api.param.IMessageParam;
import com.hisign.xingzhen.xz.api.service.es.IMessageService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 9:34 2017/11/17
 */
@Api(description = "极光消息")
@RestController
@RequestMapping("/xz/imessage")
public class IMessageController extends BaseController{

    @Resource
    private IMessageService iMessageService;

    /**
     *@Author: 何建辉
     *@Description:
     *@Date: 2017/11/1 17:07
     *@Email: hejianhui@hisign.com.cn
     */
    @ApiOperation(value = "getByIMessage",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/getByIMessage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult getByIMessage(@RequestBody IMessageParam param) throws BusinessException {
        return iMessageService.findByPage(param);
    }

    /**
     *@Author: 何建辉
     *@Description:
     *@Date: 2017/11/1 17:07
     *@Email: hejianhui@hisign.com.cn
     */
    @ApiOperation(value = "add",httpMethod ="POST",response = JsonResult.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public JsonResult add(@RequestBody List<JMessage> list) throws BusinessException, IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置RabbitMQ相关信息
        factory.setHost("192.168.1.83");
        factory.setUsername("xingji_test");
        factory.setPassword("xingji_test");
        factory.setVirtualHost("/xingji_test");
        factory.setPort(5672);

        //创建一个新的连接
        Connection connection = factory.newConnection();

        //创建一个通道
        Channel channel = connection.createChannel();

        // 声明一个队列
        channel.queueDeclare("queue.im.appmsgcallback", false, false, false, null);

        //发送消息到队列中
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows",list);
        String json = mapper.writeValueAsString(map);
        channel.basicPublish("", "queue.im.appmsgcallback", null, json.getBytes("UTF-8"));

        //关闭通道和连接
        channel.close();
        connection.close();
        return success();
    }

}
