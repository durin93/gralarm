package com.gram.alarm.domain;

import java.util.List;
import java.util.Map;

public class PullData {

    private List<PullRequest> pullRequests;

    public PullData(List<PullRequest> pullRequests) {
        this.pullRequests = pullRequests;
    }

    public static PullData of(List<PullRequest> mappingPullData) {

        for(int i = 0 ; i < mappingPullData.size(); i++){
            List<Map<String,Object>> reviewrs = (List<Map<String, Object>>) mappingPullData.get(i).get("requested_reviewers");
            mappingPullData.get(i).reviewedBy(reviewrs);
        }


         return new PullData(mappingPullData);
    }


    public PullRequest get(int i) {
      return pullRequests.get(i);
    }
}
