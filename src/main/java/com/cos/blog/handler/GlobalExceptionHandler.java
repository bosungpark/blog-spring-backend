package com.cos.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

//모든 예외발생시, 클래스를 실행시키기 위한 어노테이션
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    //특정 예외발생시, 메서드를 실행시키기 위한 어노테이션
    @ExceptionHandler(value = IllegalArgumentException.class)
    public String handleArgumentExcetion(IllegalArgumentException e){
        return "<h1>"+e.getMessage()+"</h1>";
    }
}
