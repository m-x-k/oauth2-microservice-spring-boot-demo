package com.mxk.service.model;

public class Greeting {
    private final String hello;
    private final String world;

    public Greeting(String hello, String world) {

        this.hello = hello;
        this.world = world;
    }

    public String getHello() {
        return hello;
    }

    public String getWorld() {
        return world;
    }
}
