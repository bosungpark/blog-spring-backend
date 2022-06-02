package com.cos.blog.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

//    대용량 데이터
    @Lob
    private String content;

    @ColumnDefault("0")
    private int count; //조회수

    @ManyToOne() //Many=Board, One=User
    @JoinColumn(name = "userId")
    private User user; //작성자. DB는 객체를 저장할 수 없다. 하자만 자바 orm 에서는 객체를 사용할 수 있다.

    @CreationTimestamp
    private Timestamp createDate;
}
