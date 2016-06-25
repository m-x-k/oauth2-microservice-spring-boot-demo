package com.mxk.service.controller;

import com.mxk.service.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping("/greeting")
    public @ResponseBody Greeting hello() {
        return new Greeting("hello", "world");
    }

}
