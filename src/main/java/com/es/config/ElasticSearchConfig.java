package com.es.config;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author songmo
 * @Description: elasticsearch 配置文件
 * @date 2022/1/14
 */
@Configuration
public class ElasticSearchConfig {

    //restHighLevelClient 相当于spring中的id  RestHighLevelClient相当于class
    @Bean
    public RestHighLevelClient restHighLevelClient(){
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("10.164.15.42", 9201, "http")));
        return client;
    }

}
