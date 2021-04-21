package com.lyhace.chainsavees.service;

import com.lyhace.chainsavees.util.ESClient;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Service
@Slf4j
public class EsService {

    RestHighLevelClient client = ESClient.getInstance().getHighLevelClient();

    public IndexResponse save(String jsonString) {
        IndexRequest indexRequest = new IndexRequest("sms_corp_call_info");
        indexRequest.source(jsonString, XContentType.JSON);
        IndexResponse indexResponse = null;
        try {
            indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
           log.error("写入ES失败：", e);
        }

        return indexResponse;
    }
}
