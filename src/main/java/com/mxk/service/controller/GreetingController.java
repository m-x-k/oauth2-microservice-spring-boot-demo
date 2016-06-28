package com.mxk.service.controller;

import com.mxk.service.exception.MyRestException;
import com.mxk.service.model.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping("/greeting")
    public @ResponseBody Greeting hello() {
        return new Greeting("hello", "world");
    }

    @RequestMapping("/my/exception")
    public @ResponseBody ResponseEntity<String> myException() {
        if (true)
            throw new MyRestException("should see me");
        return new ResponseEntity<String>("don't see me", HttpStatus.OK);
    }

}
