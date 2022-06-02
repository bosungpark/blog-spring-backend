package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

//    fetch = FetchType.EAGER -> 실행과 동시에 모든 데이터를 가져온다.
//    fetch = FetchType.LAZY -> 필요할 때, 필요한 만큼의 정보만을 가져온다.
    @ManyToOne(fetch = FetchType.EAGER) //Many=Board, One=User
    @JoinColumn(name = "userId")
    private User user; //작성자. DB는 객체를 저장할 수 없다. 하자만 자바 orm 에서는 객체를 사용할 수 있다.

    //mappedBy가 적히면 연관관계의 주인이 아니다. 즉 외래키가 아니라는 의미. DB에 컬럼을 만들지 않는다.
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<Reply> replies;

    @CreationTimestamp
    private Timestamp createDate;
}
