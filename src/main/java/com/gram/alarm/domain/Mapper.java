package com.gram.alarm.domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private PullData pullData;
    private ObjectMapper objectMapper;

    public Mapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        pullData = new PullData();
    }

    public PullData mappingPullData(String pullData) throws IOException {
        return objectMapper.readValue(pullData, new TypeReference<PullData>() {});
    }


}
