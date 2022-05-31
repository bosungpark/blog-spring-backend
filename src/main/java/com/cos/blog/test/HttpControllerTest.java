package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

//사용자의 요청에 대한 데이터 또는 파일의 응답을 하는 역할: 컨트롤러
@RestController
public class HttpControllerTest {

//    http://localhost:8080/http/get
    @GetMapping("/http/get")
//    @RequestParam을 통해 직접 매개변수 값을 지정해줘도 되고, 스프링의 기능을 이용해 객체를 사용해도 된다.
//    public String getTest(@RequestParam int id, @RequestParam String username){
    public String getTest(Member member){
        return "get 요청:"+member.getId()+member.getUsername()+member.getPassword();
    }

    @PostMapping("/http/post")
//    @RequestBody를 통해 직접 매개변수 값을 지정해줘도 되고, 스프링의 기능을 이용해 객체를 사용해도 된다.
//    post요청은 쿼리파라미터가 아닌 Body에 데이터를 담아 보내기 때문이다.
    public String postTest(Member member){
        return "post 요청:"+member.getId()+member.getUsername()+member.getPassword();
    }

    @PutMapping("/http/put")
//    @RequestBody를 통해 직접 매개변수 값을 지정해줘도 되고, 스프링의 기능을 이용해 객체를 사용해도 된다.
//    put요청은 쿼리파라미터가 아닌 Body에 데이터를 담아 보내기 때문이다.
    public String putTest(Member member){
        return "put 요청:"+member.getId()+member.getUsername()+member.getPassword();
    }

    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete 요청";
    }
}
