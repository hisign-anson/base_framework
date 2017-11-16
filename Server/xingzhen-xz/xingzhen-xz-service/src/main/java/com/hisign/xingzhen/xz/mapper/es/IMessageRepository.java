package com.hisign.xingzhen.xz.mapper.es;

import com.hisign.xingzhen.xz.api.entity.IMessage;
import org.apache.commons.net.nntp.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 15:33 2017/11/16
 */
public interface IMessageRepository extends ElasticsearchRepository<IMessage, String> {

}
