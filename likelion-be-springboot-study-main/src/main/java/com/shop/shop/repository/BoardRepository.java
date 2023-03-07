package com.shop.shop.repository;

import com.shop.shop.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board> {

    List<Board> findByTitleOrDetail(String title, String detail); // 제목 혹은 내용 검색


    List<Board> findByPriceLessThanOrderByPriceDesc(Integer price); //OrderBy로 정렬 처리하기

    //@Query 어노테이션으로 복잡한 쿼리 처리하기
    @Query("select i from Board i where i.detail like %:detail% order by i.num desc")
    List<Board> findByDetail(@Param("detail") String detail);

}