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
        headers.set("Authorization", "token 693938c0206239d5a59e09f5e707b337c6240a4a");
        httpEntity = new HttpEntity(headers);
    }


    public PullData getPrInfo() throws IOException {
        PullData pullData = mapper.mappingPullData(crawlData());
        return pullData;
    }

    public List<String> getReviewer(PullData pulldata){
        return (List<String>) pulldata.get(0).get("reviewer");
    }


    public String crawlData(){
        return restTemplate
            .exchange(UrlBox.GRALARM.getUrl(), HttpMethod.GET, httpEntity,
                String.class).getBody();
    }
}
