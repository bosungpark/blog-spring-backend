package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//User 클래스가 MySQL에 자동으로 생성되도록 하는 어노테이션
//ORM: 언어로 만든 객체를 데이터베이스와 연결 시켜주는 것
@Entity
//@DynamicInsert: insert시 null값인 필드는 생략하고 퀴리를 진행한다.
//만약 이 어노테이션이 없으면, default값을 설정한 필드에 null값이 저장되어 잘못된 값이 들어가게 된다.
//@DynamicInsert
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

    @Column(nullable = false, length = 50, unique = true)
    private String email;

//    ColumnDefault에서 문자열을 인식하기 위해서는 "'기본값'"의 형식으로 작성한다.
//    @ColumnDefault("'user'")
//    private String role;

//    DB는 RoleType이라는 형식이 없다. 따라서 형식을 지정해준다.
    @Enumerated(EnumType.STRING)
    private RoleType role;

//    시간이 자동으로 입력되는 어노테이션
    @CreationTimestamp
    private Timestamp createDate;
}
