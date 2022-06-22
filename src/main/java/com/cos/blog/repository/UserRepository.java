package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@Repository 생략가능. 자동으로 bean 등록이 된다.
public interface UserRepository extends JpaRepository<User, Integer>{
    //jpa 네이밍 쿼리 전략
    // SELECT * FROM user WHERE username=? AND password=?;
    User findByUsernameAndPassword(String username, String password);

    //nativeQuery를 이용하는 방법
//    @Query(value = "SELECT * FROM user WHERE username=?1 AND password=?2", nativeQuery = true)
//    User login(String username, String password);
}
