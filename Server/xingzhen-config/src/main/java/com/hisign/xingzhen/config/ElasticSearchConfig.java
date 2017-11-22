package com.hisign.xingzhen.config;

import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.net.InetAddress;

public class ElasticSearchConfig {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;

    @Value("${elasticsearch.clustername}")
    private String clustername;

    @Bean
    public Client client() throws Exception {
        Settings esSettings = Settings.builder()
                .put("cluster.name", clustername) //设置ES实例的名称
                .put("client.transport.sniff", true) //自动嗅探整个集群的状态，把集群中其他ES节点的ip添加到本地的客户端列表中
                .build();

        /**
         * 这里的连接方式指的是没有安装x-pack插件,如果安装了x-pack则参考{@link ElasticsearchXPackClient}
         * 1. java客户端的方式是以tcp协议在9300端口上进行通信
         * 2. http客户端的方式是以http协议在9200端口上进行通信
         */
        PreBuiltTransportClient preBuiltTransportClient = new PreBuiltTransportClient(esSettings);

        TransportClient client = preBuiltTransportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));

        System.out.println("ElasticsearchClient 连接成功");
        return client;
    }

    /**
     * imessage索引
     * @param indices
     * @param mappingType
     * @throws Exception
     */
    public void imessageMapping(String indices,String mappingType)throws Exception{
        new XContentFactory();
        XContentBuilder builder=XContentFactory.jsonBuilder()
                .startObject()
                .startObject(indices)
                .startObject("properties")
                .startObject("msgid").field("type", "string").field("store", "yes").endObject()
                .startObject("version").field("type", "string").field("store", "yes").endObject()
                .startObject("target_type").field("type", "string").field("store", "yes").endObject()
                .startObject("target_name").field("type", "string").field("store", "yes").endObject()
                .startObject("target_id").field("type", "string").field("store", "yes").endObject()
                .startObject("from_type").field("type", "string").field("store", "yes").endObject()
                .startObject("from_name").field("type", "string").field("store", "yes").endObject()
                .startObject("from_id").field("type", "string").field("store", "yes").endObject()
                .startObject("msg_type").field("type", "string").field("store", "yes").endObject()
                .startObject("msg_body").field("type", "string").field("store", "yes").endObject()
                .startObject("create_time").field("type", "long").field("store", "yes").endObject()
                .startObject("msg_ctime").field("type", "long").field("store", "yes").endObject()
                .startObject("msgText").field("type", "string").field("store", "yes").field("indexAnalyzer", "ik").field("searchAnalyzer", "ik").endObject()
                .endObject()
                .endObject()
                .endObject();
        PutMappingRequest mapping = Requests.putMappingRequest(indices).type(mappingType).source(builder);
        client().admin().indices().putMapping(mapping).actionGet();
        client().close();
    }



}