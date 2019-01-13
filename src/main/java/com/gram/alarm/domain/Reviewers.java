package com.gram.alarm.domain;

import java.util.List;
import java.util.Map;

public class Reviewers {
    private List<Map<String,Object>> reviewers;

    public Reviewers(List<Map<String,Object>> reviewers) {
        this.reviewers = reviewers;
    }

    public String getName(int index){
        return (String) reviewers.get(index).get("login");
    }

}
