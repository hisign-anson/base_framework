package com.hisign.xingzhen.xz.api.service.es;

import com.hisign.xingzhen.xz.api.entity.IMessage;
import com.hisign.xingzhen.xz.api.param.IMessageParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Book;
import java.util.List;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 16:15 2017/11/16
 */
public interface IMessageService {

    IMessage save(IMessage book);

    void delete(IMessage book);

    IMessage findOne(String id);

    Iterable<IMessage> findAll();

    Page<IMessage> findBy(IMessageParam msg, PageRequest pageRequest);

    List<IMessage> findBy(IMessageParam msg);

    Page<IMessage> findByContent(String content, PageRequest pageRequest);
}
