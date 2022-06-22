package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//인증이 안된 사용자 /auth/** 허용
//주소가 index.jsp 허용
//static 이하의 /js/** /css/** /image/** 허용
@Controller
public class UserController {

    @GetMapping("/auth/joinForm")
    public String joinForm(){

        return "user/joinForm";
    }

    @GetMapping("auth/loginForm")
    public String loginForm(){

        return "user/loginForm";
    }
}
