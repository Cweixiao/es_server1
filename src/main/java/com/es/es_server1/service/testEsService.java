package com.es.es_server1.service;

import com.alibaba.fastjson.JSON;
import com.es.es_server1.pojo.Test_Es;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class testEsService {


    @Autowired
    private RestHighLevelClient client;

    /**
     * 添加索引数据
     * @throws IOException
     */
    public void insertIkIndex() throws IOException {

        Test_Es test_es = new Test_Es();
        test_es.setId(10);
        test_es.setName("JAVA_test");

        IndexRequest request = new IndexRequest("test_es");
//        request.id("1");
        request.source(JSON.toJSONString(test_es), XContentType.JSON);

        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);

        System.out.println(indexResponse.status());
        System.out.println(indexResponse.toString());
    }



    public void searchIndex() throws IOException {
        SearchRequest searchRequest = new SearchRequest("sg_sw_app");
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        QueryBuilder qb = new MatchQueryBuilder("abbr","京");
        ssb.query(qb);
        searchRequest.source(ssb);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            String record = hit.getSourceAsString();
            System.out.println(record);
        }
    }


}
