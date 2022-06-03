package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

//    DummyControllerTest가 메모리에 로드될 때, userRepository 역시 로딩시켜준다. -> 의존성 주입(DI)
    @Autowired
    private UserRepository userRepository;

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
