package com.gram.alarm.domain;

import com.gram.alarm.util.UrlBox;
import java.io.IOException;
import java.util.List;
import java.util.Map;
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
        headers.set("Authorization", "token 052841258aa97c5e2b42009956ed10b10a246959");
        httpEntity = new HttpEntity(headers);
    }


    public void getPrInfo() throws IOException {
        PullData pullData = mapper.mappingPullData(crawlData());
        checkSize(pullData);
        //pr이 있으면 작업
//        System.out.println(wow.get(0).get("url"));
    }

    private void checkSize(PullData pullData) {
        if(pullData.size()==0){
            System.out.println("앗 모든 pr close");
        }
    }

    public String crawlData(){
        return restTemplate
            .exchange(UrlBox.GRALARM.getUrl(), HttpMethod.GET, httpEntity,
                String.class).getBody();
    }
}
