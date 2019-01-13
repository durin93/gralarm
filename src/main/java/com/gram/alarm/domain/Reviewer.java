package com.gram.alarm.domain;

import java.util.Map;

public class Reviewer {
  private    Map<String,Object> reviewer;

  public String getId(){
      return (String) reviewer.get("login");
  }
}
