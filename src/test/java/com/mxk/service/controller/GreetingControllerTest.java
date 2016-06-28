package com.mxk.service.controller;

import com.mxk.service.exception.MyRestException;
import com.mxk.service.model.Greeting;
import org.junit.Test;
import org.springframework.ejb.access.EjbAccessException;
import org.springframework.expression.ExpressionException;

import static org.junit.Assert.assertEquals;

public class GreetingControllerTest {

    private GreetingController greetingController = new GreetingController();

    @Test
    public void testHello() throws Exception {
        Greeting greeting = greetingController.hello();
        assertEquals("hello" , greeting.getFirst());
        assertEquals("world" , greeting.getSecond());
    }

    @Test(expected = MyRestException.class)
    public void testMyException() throws Exception {
        greetingController.myException();
    }
}