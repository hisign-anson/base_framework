package com.hisign.xingzhen.xz.service.impl.es;

import cn.jmessage.api.message.MessageType;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hisign.bfun.bmodel.JsonResult;
import com.hisign.bfun.butils.JsonResultUtil;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.xz.api.entity.IMessage;
import com.hisign.xingzhen.xz.api.param.IMessageParam;
import com.hisign.xingzhen.xz.api.service.es.IMessageService;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 16:20 2017/11/16
 */
@Service("iMessageService")
public class IMessageServiceImpl implements IMessageService{

    private Logger log = LoggerFactory.getLogger(IMessageService.class);

    @Autowired
    Client client;

    @Override
    public void save(List<IMessage> list) {
        log.info("保存的对象IMessage=[{}]",list);
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        ObjectMapper mapper = new ObjectMapper();

        for (IMessage iMessage : list) {
            try {
                String json = mapper.writeValueAsString(iMessage);
                bulkRequest.add(client.prepareIndex(IMessage.INDEX,IMessage.TYPE,iMessage.getMsgid()).setSource(json).request());
            } catch (JsonProcessingException e) {
                log.error("批量创建索引出错，e={}",e);
            }
        }
        BulkResponse bulkResponse = bulkRequest.execute().actionGet();
        if (bulkResponse.hasFailures()) {
            Assert.fail("批量创建索引错误！");
        }

    }

    @Override
    public JsonResult findByPage(IMessageParam msg) {
        log.info("IMessageParam={}",msg);
        /*if (StringUtils.isNotBlank(msg.getScrollId())){
            Map<String, Object> map = searchByScrollId(msg.getScrollId());
            List<String> data = (List<String>) map.get("data");
            String scrollId = (String) map.get("scrollId");
            JsonResult result = JsonResultUtil.success(data);
            result.setMsg(scrollId);
            return result;
        }*/

        SearchRequestBuilder searchRequestBuilder = client.prepareSearch();
        searchRequestBuilder.setIndices(IMessage.INDEX)
        .setTypes(IMessage.TYPE)
        .setFrom(msg.getBegin())
        //searchRequestBuilder.setScroll(new TimeValue(30000));
        .setSize(msg.getSize())
        //searchRequestBuilder.setExplain(true);
        .addSort("create_time", SortOrder.DESC);
        //设置高亮显示
        /*HighlightBuilder highlightBuilder = new HighlightBuilder().field("msgText").requireFieldMatch(false);
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");
        searchRequestBuilder.highlighter(highlightBuilder);*/

        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();

        if (StringUtils.isNotBlank(msg.getMsg_type())){
            queryBuilder.must(QueryBuilders.termQuery("msg_type", msg.getMsg_type()));
        }else{
            queryBuilder.should(QueryBuilders.termQuery("msg_type", MessageType.TEXT.getValue()))
                    .should(QueryBuilders.termQuery("msg_type", MessageType.CUSTOM.getValue()));
        }

        //发送人
        if (msg.getFrom_id()!=null && msg.getFrom_id().length>0){
            queryBuilder.filter(QueryBuilders.matchQuery("from_id", msg.getFrom_id()));
        }

        //接收方 人或极光群组id
        if (StringUtils.isNotBlank(msg.getTarget_id())){
            queryBuilder.filter(QueryBuilders.matchQuery("target_id", msg.getTarget_id()));
        }

        //查询聊天信息
        if (StringUtils.isNotBlank(msg.getMsgText())){
            if (msg.isUseRegexp()){
                queryBuilder.must(QueryBuilders.regexpQuery("msgText",msg.getMsgText()));
            }else{
                queryBuilder.must(QueryBuilders.matchPhraseQuery("msgText",msg.getMsgText()));
            }
        }

        //发送时间
        if (msg.getBeginTime()!=null && msg.getEndTime()!=null){
            queryBuilder.filter(QueryBuilders.rangeQuery("msg_ctime").gte(msg.getBeginTime().getTime()).lt(msg.getEndTime().getTime()));
        }

        searchRequestBuilder.setQuery(queryBuilder);
        log.info("searchRequestBuilder=[{}]",searchRequestBuilder);
        // 执行
        SearchResponse searchResponse = searchRequestBuilder.execute().actionGet();
        //String scrollId = searchResponse.getScrollId();
        log.info("--------- searchResponse={}", searchResponse);
        SearchHit[] searchHits = searchResponse.getHits().getHits();
        List<IMessage> list = new ArrayList<>(searchHits.length);
        log.info("result:[{}]",searchHits);
        if (searchHits.length==0){
            log.info("no result");
            return JsonResultUtil.success(list);
        }
        for (SearchHit searchHit : searchHits) {
//            String json = searchHit.getSourceAsString();
//            list.add(json);
            hisigLight(list, searchHit);
        }
        return JsonResultUtil.success(searchResponse.getHits().getTotalHits(),list);
    }


    public Map<String,Object> searchByScrollId(String scrollId){
        TimeValue timeValue = new TimeValue(30000);
        SearchScrollRequestBuilder searchScrollRequestBuilder;
        SearchResponse response;
        // 结果
        log.info("--------- searchByScroll scrollID {}", scrollId);
        searchScrollRequestBuilder = client.prepareSearchScroll(scrollId);
        // 重新设定滚动时间
        searchScrollRequestBuilder.setScroll(timeValue);
        // 请求
        response = searchScrollRequestBuilder.get();
        // 每次返回下一个批次结果 直到没有结果返回时停止 即hits数组空时
        if (response.getHits().getHits().length == 0) {
            return null;
        }
        // 这一批次结果
        SearchHit[] searchHits = response.getHits().getHits();
        List<IMessage> list = new ArrayList<>(searchHits.length);
        for (SearchHit searchHit : searchHits) {
            hisigLight(list, searchHit);
        }
        // 只有最近的滚动ID才能被使用
        scrollId = response.getScrollId();
        HashMap<String, Object> map = new HashMap<>(searchHits.length);
        map.put("data",list);
        map.put("scrollId",scrollId);
        return map;
    }

    private void hisigLight(List<IMessage> list, SearchHit searchHit) {
        String source = searchHit.getSourceAsString();
        IMessage iMessage = JSON.parseObject(source, IMessage.class);
        //JSONObject jsonObject = JSONObject.parseObject(source);
        log.info("--------- searchByScroll source {}", source);
        // 获取对应的高亮域
        Map<String, HighlightField> result = searchHit.highlightFields();
        // 从设定的高亮域中取得指定域
        HighlightField titleField = result.get("msgText");
        // 取得定义的高亮标签
        if (titleField!=null){
            Text[] titleTexts = titleField.fragments();
            // 为title串值增加自定义的高亮标签
            String title = "";
            for (Text text : titleTexts) {
                title += text;
            }
            iMessage.setMsgText(title);
        }

        //jsonObject.put("msgText",title);
        list.add(iMessage);
    }
}
