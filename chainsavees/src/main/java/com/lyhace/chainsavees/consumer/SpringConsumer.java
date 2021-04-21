package com.lyhace.chainsavees.consumer;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lyhace.chainsavees.service.EsService;
import com.lyhace.chainsavees.util.ESClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
@RocketMQMessageListener(topic = "${rocketmq.producer.topic}", consumerGroup = "${rocketmq.producer.group}")
public class SpringConsumer implements RocketMQListener<String> {

    @Autowired
    private EsService esService;

    @Override
    public void onMessage(String msgStr) {
        log.info("收到消息:" + msgStr);

        JsonObject serviceInfoJson = new JsonObject();

        Gson g = new Gson();
        JsonObject obj = g.fromJson(msgStr, JsonObject.class);

        if(obj != null){
            JsonElement jsonElement = obj.get("data");

            if(!(jsonElement == null || "null".equals(jsonElement.toString()))){
                JsonArray dataJsonArray = jsonElement.getAsJsonArray();
                String sqlType = obj.get("type").getAsString();

                if(sqlType != null && "INSERT".equals(sqlType)){
                    if(dataJsonArray != null && dataJsonArray.size() > 0){

                        for(int i = 0; i < dataJsonArray.size(); i++){

                            serviceInfoJson = dataJsonArray.get(i).getAsJsonObject();

                            IndexResponse indexResponse = esService.save(serviceInfoJson.toString());

                            if(indexResponse != null){
                                log.info(indexResponse.toString());
                            }else{
                                log.error("indexResponse is null!!!");
                            }

                        }
                    }
                }
            }
        }
    }


}