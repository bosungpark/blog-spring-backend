package com.cos.blog.service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//spring이 컴포넌트 스캔을 통해 메모리에 띄워줌(IoC)
//서비스의 목적: 트랜잭션 관리
//서비스의 의미:
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public int 회원가입(User user){
        try {
            userRepository.save(user);
            return 1;
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("UserService:"+e.getMessage());
        }
        return -1;
    }

//    @Transactional(readOnly = true)//쿼리 시의 정합성 유지
//    public User 로그인(User user){
//
//        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//    }


}
