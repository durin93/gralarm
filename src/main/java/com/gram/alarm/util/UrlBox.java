package com.gram.alarm.util;

public enum UrlBox {
    GRALARM("gralarm","https://api.github.com/repos/durin93/gralarm/pulls");

    private String name;
    private String url;

    UrlBox(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
