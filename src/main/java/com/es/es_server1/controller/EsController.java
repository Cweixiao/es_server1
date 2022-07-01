package com.es.es_server1.controller;


import com.es.es_server1.EsServer1Application;
import com.es.es_server1.service.testEsService;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class EsController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Autowired
    public testEsService testEsService;
//
//    //创建索引
//    @Test
//    public void testCreatIndex() throws IOException {
//        //创建索引请求
//        CreateIndexRequest createIndexRequest = new CreateIndexRequest("songmo");
//        //创建执行请求
//        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
//        System.out.println(createIndexResponse);
//    }
//
//    //获取索引
//    @Test
//    public void testGetIndex() throws IOException {
//        GetIndexRequest getIndexRequest =new GetIndexRequest("songmo");
//        boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
//        System.out.println(exists);
//    }
//
//
//    //删除索引
//    @Test
//    public void testDeleteIndex() throws IOException {
//        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("songmo");
//        AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
//        System.out.println(delete.isAcknowledged());
//    }
//
//
////    //文档添加信息
////    @Test
////    void testDocument() throws IOException {
////        User user = new User("test1", 10);
////        IndexRequest indexRequest = new IndexRequest("songmo");
////        indexRequest.id("1");
////        indexRequest.timeout(TimeValue.timeValueSeconds(1));
////        indexRequest.timeout("1s");
////        IndexRequest source = indexRequest.source(JSON.toJSONString(user), XContentType.JSON);
////        //发送请求
////        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
////        System.out.println(indexResponse.toString());
////    }
//
//    //获取文档
//    @Test
//    public void testGetDocument() throws IOException {
//        GetRequest getRequest = new GetRequest("test_es2", "1");
//        //不获取 _souce上下文
////		getRequest.fetchSourceContext(new FetchSourceContext(false));
//        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
//        if(exists){
//            //获取文档信息
//            GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
//            System.out.println(documentFields.getSourceAsString());
//            System.out.println(documentFields);
//        }
//    }


    @GetMapping("/test_es")
    public void inputFile() throws IOException {
        testEsService.insertIkIndex();
    }

    @GetMapping("/sg_sw_app")
    public void queryFile() throws IOException {
        testEsService.searchIndex();
    }

}
