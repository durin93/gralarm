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
    private Mapper mapper;
    private PullData pullData;

    @Autowired
    public Crawler(RestTemplate restTemplate, Mapper mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }


    @PostConstruct
    private void setUp() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token d9c8c94cf483a4190e420d47368d330d1d588753");
        httpEntity = new HttpEntity(headers);
        this.pullData = crawlRepositoryData();
    }


    public PullData getPullData() {
        return pullData;
    }

    public PullRequest getPullRequest(int index){
        return PullRequest.of(pullData.getPullRequestByIndex(index));
    }

    private PullData crawlRepositoryData() {
        this.pullData =  PullData.of(restTemplate
            .exchange(UrlBox.GRALARM.getUrl(), HttpMethod.GET, httpEntity,
                JsonNode.class).getBody());

        return pullData;
    }
}
