package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

//    DummyControllerTest가 메모리에 로드될 때, userRepository 역시 로딩시켜준다. -> 의존성 주입(DI)
    @Autowired
    private UserRepository userRepository;

    // {id} 주소로 파라미터를 전달 받을 수 있다.
    //@PathVariable int id
    // http://localhost:8000/blog/dummy/user/3
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){

//        방법1: 반환타입 수정-> Optional<User>: null값이 되면 문제가 생길 수 있다. 만약 null이라면 null을 반환한다.
//        Optional<User> user=userRepository.findById(id);

        User user=userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 사용자가 없습니다.");
            }
        });
//        요청: 웹브라우저
//        user 객체= 자바 오브젝트
//        변환(웹브라우저가 이해할 수 있는 데이터) -> json
//        스프링부트= MessageConverter가 자동작동. 자바 오브젝트 리턴 시, Jackson을 통해 json 타입으로 변환.
        return user;
    }

    @PostMapping("/dummy/join")
//    public String join(String username, String password, String email){ //key=value 값을 받는다
    public String join(User user){
//        System.out.println("id = " + user.getId());
//        System.out.println("username = " + user.getUsername());
//        System.out.println("password = " + user.getPassword());
//        System.out.println("email = " + user.getEmail());
//        System.out.println("roll = " + user.getRole());
//        System.out.println("createDate = " + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
