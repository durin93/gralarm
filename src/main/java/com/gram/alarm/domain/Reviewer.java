package com.gram.alarm.domain;

import com.fasterxml.jackson.databind.JsonNode;

public class Reviewer {

    private String name;
    private Long id;

    private Reviewer(JsonNode reviewer) {
        this.name = reviewer.path("login").asText();
        this.id = reviewer.path("id").asLong();
    }


    public static Reviewer of(JsonNode reviewer){
        return new Reviewer(reviewer);
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
