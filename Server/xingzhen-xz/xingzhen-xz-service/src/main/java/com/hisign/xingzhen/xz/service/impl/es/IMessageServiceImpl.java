package com.hisign.xingzhen.xz.service.impl.es;

import cn.jmessage.api.message.MessageType;
import com.hisign.xingzhen.common.constant.Constants;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.xz.api.entity.IMessage;
import com.hisign.xingzhen.xz.api.param.IMessageParam;
import com.hisign.xingzhen.xz.api.service.es.IMessageService;
import com.hisign.xingzhen.xz.mapper.es.IMessageRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 16:20 2017/11/16
 */
public class IMessageServiceImpl implements IMessageService{

    @Autowired
    IMessageRepository iMessageRepository;

    @Override
    public IMessage save(IMessage book) {
        return iMessageRepository.save(book);
    }

    @Override
    public void delete(IMessage book) {
        iMessageRepository.delete(book);
    }

    @Override
    public IMessage findOne(String id) {
        return iMessageRepository.findOne(id);
    }

    @Override
    public Iterable<IMessage> findAll() {
        return iMessageRepository.findAll();
    }

    @Override
    public Page<IMessage> findBy(IMessageParam msg, PageRequest pageRequest) {
        QueryBuilder query = QueryBuilders.boolQuery();

        //这里的matchPhraseQuery代表精确查询,同样使用matchQuery也可以,matchPhrasePrefixQuery代表的是模糊查询
        if (StringUtils.isNotBlank(msg.getId())) {
            query = QueryBuilders.boolQuery()
                    .must(QueryBuilders.matchPhraseQuery("id", msg.getId()));
        }

        if (StringUtils.isNotBlank(msg.getTarget_type())) {
            query = QueryBuilders.boolQuery()
                    .must(QueryBuilders.matchPhraseQuery("targetType", msg.getTarget_type()));
        }

        if (StringUtils.isNotBlank(msg.getMsg_type())) {
            query = QueryBuilders.boolQuery()
                    .must(QueryBuilders.matchPhraseQuery("msgType", msg.getMsg_type()));
        }

        if (StringUtils.isNotBlank(msg.getTarget_name())) {
            query = QueryBuilders.boolQuery()
                    .must(QueryBuilders.matchPhraseQuery("targetName", msg.getTarget_name()));
        }

        if (StringUtils.isNotBlank(msg.getFrom_id())) {
            query = QueryBuilders.boolQuery()
                    .must(QueryBuilders.matchPhraseQuery("fromId", msg.getFrom_id()));
        }

        if (StringUtils.isNotBlank(msg.getFrom_name())) {
            query = QueryBuilders.boolQuery()
                    .must(QueryBuilders.matchPhraseQuery("fromName", msg.getFrom_name()));
        }

        if (StringUtils.isNotBlank(msg.getFrom_type())) {
            query = QueryBuilders.boolQuery()
                    .must(QueryBuilders.matchPhraseQuery("fromType", msg.getFrom_type()));
        }

        if (StringUtils.isNotBlank(msg.getMsg_body())) {
            query = QueryBuilders.boolQuery()
                    .must(QueryBuilders.matchPhraseQuery("msgType", MessageType.TEXT.getValue()))
                    .should(QueryBuilders.matchPhraseQuery("msgType", MessageType.CUSTOM.getValue()));

        }

        return null;
    }

    @Override
    public List<IMessage> findBy(IMessageParam msg) {
        return null;
    }

    @Override
    public Page<IMessage> findByContent(String content, PageRequest pageRequest) {
        QueryBuilder query = QueryBuilders.boolQuery();

        query = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchPhraseQuery("msgType", MessageType.TEXT.getValue()))
                .should(QueryBuilders.matchPhraseQuery("msgType", MessageType.CUSTOM.getValue()))
                .must(QueryBuilders.matchPhraseQuery("msgType", MessageType.CUSTOM.getValue()));

        return null;
    }
}
