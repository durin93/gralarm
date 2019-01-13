package com.gram.alarm.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import java.io.IOException;
import java.util.Map;

public class AnyParser {

    private AnyParser() {
    }

    public static Map<String, Object> parseByMap(String json) throws IOException {
        // TODO JACKSON 2.9 JAVADOC http://fasterxml.github.io/jackson-databind/javadoc/2.9/

        ObjectMapper mapper = new ObjectMapper();
        MapType type = mapper.getTypeFactory().constructMapType(
            Map.class, String.class, Object.class);

        /*
         1. public MapType constructMapType(Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) 이 호출되어서
         JavaType 객체로 변환되어 2. 로 넘어감
         2. public MapType constructMapType(Class<? extends Map> mapClass, JavaType keyType, JavaType valueType)
         검증과 바인딩 단계
         3. TypeBindings bindings = TypeBindings.createIfNeeded(mapClass, new JavaType[]{keyType, valueType});
         TypeBindings.createIfNeeded 을 통해 바인딩된 MapType 리턴
         */

        Map<String, Object> data = null;
        try {
            data = mapper.readValue(json, type);
        } catch (IOException e) {
            throw e;
        }
        // public <T> T readValue(String content, JavaType valueType) 을 통해 Map<String, Object> 오브젝트로 역직렬화
        return data;
    }
}