package com.mxk.service.model;

public class Greeting {
    private final String first;
    private final String second;

    public Greeting(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }
}
