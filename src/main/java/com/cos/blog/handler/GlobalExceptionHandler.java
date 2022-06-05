package com.cos.blog.handler;

import com.cos.blog.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

//모든 예외발생시, 클래스를 실행시키기 위한 어노테이션
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    //특정 예외발생시, 메서드를 실행시키기 위한 어노테이션
    @ExceptionHandler(value = Exception.class)
    public ResponseDto<String> handleArgumentExcetion(Exception e){
        return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
