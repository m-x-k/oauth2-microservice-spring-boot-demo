package com.mxk.service.controller;

import com.mxk.service.model.Greeting;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingControllerTest {

    private GreetingController greetingController = new GreetingController();

    @Test
    public void testHello() throws Exception {
        Greeting greeting = greetingController.hello();
        assertEquals("hello" , greeting.getFirst());
        assertEquals("world" , greeting.getSecond());
    }
}