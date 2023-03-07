package com.shop.shop.entity;

import com.shop.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Getter
@Setter
@ToString
public class Board {

    @Id
    @Column(name="board_num")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int num; // 게시글 번호

    @Column(nullable = false, length = 50)
    private String title; // 제목


    @Lob
    @Column(nullable = false)
    private String detail; // 내용


    private LocalDateTime regTime; // 등록 시간

    private LocalDateTime updateTime; // 수정 시간

    public void setPrice(int i) {
    }
}
