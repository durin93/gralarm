package com.gram.alarm;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AlarmApplicationTests {

    private TestRestTemplate restTemplate;

    @Before
    public void setUp(){
        restTemplate = new TestRestTemplate();
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void getPrInfo() throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","token 593dc12f1929c1a514d1c93cb1e622d76db4139c");

        HttpEntity httpEntity = new HttpEntity<>(headers);

        ResponseEntity<String> exchange = restTemplate
            .exchange("https://api.github.com/repos/durin93/gralarm/pulls", HttpMethod.GET, httpEntity,
                String.class);

        String body = exchange.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        List<
            Map<String,Object>> test = objectMapper.readValue(body, new TypeReference<ArrayList<Map<String,Object>>>() {
        });

        Map<String, Object> wow =  test.get(0);
        System.out.println(wow.get("url"));

    }

}

