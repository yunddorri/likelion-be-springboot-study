package com.shop.shop.entity;

import com.shop.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Getter
@Setter
@ToString
public class Item {

    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //상품코드

    @Column(nullable = false, length = 50)
    private String itemNm; // 삼품명

    @Column(name = "price", nullable = false)
    private int price; // 가격

    @Column(nullable = false)
    private int stockNumber; // 재고수량

    @Lob
    @Column(nullable = false)
    private String itemDetail; // 상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; // 상품 판매 상패

    private LocalDateTime regTime; // 등록시강

    private LocalDateTime updateTime; // 수정시간
}
