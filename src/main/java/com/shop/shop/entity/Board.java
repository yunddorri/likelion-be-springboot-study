package com.shop.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

//Board 클래스를 entity로 선언
@Entity
//Table 어노테이션을 통해 board 테이블과 매핑되도록 name을 board로 지정하였습니다.
@Table(name="board")
@Getter
@Setter
@ToString
public class Board {

    //entity로 선언한 클래스는 반드시 기본키를 가져야하기 때문에 기본키가 되는 boardNm 변수에 @Id 어노테이션을 붙여주었습니다.
    @Id
    //테이블에 매핑될 컬럼의 이름을 @Column 어노테이션을 통해 설정
    @Column(name="board_num")
    // @GeneratedValue 어노테이션을 통해 기본키 생성 전략을 auto로 지정
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int boardNm;//게시글 번호

    @Column(nullable = false)
    private String boardTitle; //게시글 제목


    @Column(nullable = false)
    private String boardDetail; //게시글 내용

    private LocalDateTime regTime; //등록 시간

}
