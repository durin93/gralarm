package com.gram.alarm.domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.gram.alarm.util.UrlBox;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Crawler {

    private RestTemplate restTemplate;
    private HttpEntity httpEntity;
    private PullData pullData;

    @Autowired
    public Crawler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @PostConstruct
    private void setUp() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token 4918acdd9c4545c9b7d748d3b02c199f6b4c93ec");
        httpEntity = new HttpEntity(headers);
    }


    public PullData crawlRepositoryData() {
        this.pullData =  PullData.of(restTemplate
            .exchange(UrlBox.GRALARM.getUrl(), HttpMethod.GET, httpEntity,
                JsonNode.class).getBody());

        return pullData;
    }
}
