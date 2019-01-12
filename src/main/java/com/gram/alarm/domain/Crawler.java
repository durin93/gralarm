package com.gram.alarm.domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Crawler {

    private RestTemplate restTemplate;

    public Crawler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void getPrInfo() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token 3b0455ef514f1c4226d6fcb07aa35a48c2cf0d03");

        HttpEntity httpEntity = new HttpEntity<>(headers);

        ResponseEntity<String> exchange = restTemplate
            .exchange("https://api.github.com/repos/durin93/gralarm/pulls", HttpMethod.GET, httpEntity,
                String.class);

        String body = exchange.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        List<
            Map<String, Object>> test = objectMapper
            .readValue(body, new TypeReference<ArrayList<Map<String, Object>>>() {
            });

        Map<String, Object> wow = test.get(0);
        System.out.println(wow.get("url"));
    }
}
