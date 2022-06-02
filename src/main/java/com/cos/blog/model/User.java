package com.cos.blog.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

//User 클래스가 MySQL에 자동으로 생성되도록 하는 어노테이션
@Entity
public class User {

//    PK설정
    @Id
//    프로젝트에 연결된 DB에 넘버링 전략을 따른다.
//    use-new-id-generator-mappings: false
//    jpa가 아닌 MySQL의 전략을 따른다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

//    ColumnDefault는 "'기본값'"의 형식으로 작성
    @ColumnDefault("'user'")
    private String role;

//    시간이 자동으로 입력되는 어노테이션
    @CreationTimestamp
    private Timestamp createDate;
}
