package com.gram.alarm.domain;

import com.gram.alarm.util.UrlBox;
import java.io.IOException;
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

    @Autowired
    public Crawler(RestTemplate restTemplate, Mapper mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }


    @PostConstruct
    private void setUp() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token fc929e644bf932fa12155ae1ec3e75282099766e");
        httpEntity = new HttpEntity(headers);
    }


    public PullData getPrInfo() throws IOException {
        return  PullData.of(mapper.mappingPullData(crawlData()));
    }

    //
    public PullRequest getReviewer(PullData pulldata) throws IOException {
        PullRequest pullRequest =  pulldata.get(0); //일단은 PR1

        Reviewers reviewers = pullRequest.getReviewers();


        System.out.println(        reviewers.getName(0));
        return null;
    }


    public String crawlData(){
        return restTemplate
            .exchange(UrlBox.GRALARM.getUrl(), HttpMethod.GET, httpEntity,
                String.class).getBody();
    }
}
