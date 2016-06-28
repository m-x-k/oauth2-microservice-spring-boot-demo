package com.mxk.service.exception.handler;

import com.mxk.service.exception.MyRestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {MyRestException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest webRequest) {
        String bodyOfResponse = "Well that's another fine mess you got me into";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, webRequest);
    }

}
