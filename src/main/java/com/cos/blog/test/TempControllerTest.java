package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

    @GetMapping("/temp/home")
    public String tempHome(){
        System.out.println("temp-home operated");

//        파일리턴 기본경로: src/main/resources/static
//        리턴명: /home.html
//        풀경로: src/main/resources/static/home.html
        return "/home.html";
    }

//    @GetMapping("/temp/jsp")
//    public String tempJsp(){
//        // prefix: /WEB-INF/views
//        // suffix: .jsp
//        // 풀경로: /WEB-INF/views/test.jsp
//        return "test";
//    }

    @GetMapping("/temp/thymeleaf")
    public String tempThymeleaf(){
//        풀경로: src/main/resources/templates/thymeleafTest.html
        return "thymeleafTest";
    }
}
