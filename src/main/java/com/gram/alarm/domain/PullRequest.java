package com.gram.alarm.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PullRequest extends HashMap<String,Object> {

    private Reviewers reviewers;

    public void reviewedBy(List<Map<String,Object>> reviewers) {
        //check리뷰어유무
        this.reviewers =  new Reviewers(reviewers);
    }

    public Reviewers getReviewers() {
        return reviewers;
    }
}
