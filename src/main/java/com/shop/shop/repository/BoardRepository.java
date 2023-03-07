package com.shop.shop.repository;

import com.shop.shop.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {
    //JpaRepository를 상속받는 BoardRepository를 작성하였다.
    //2개의 제네릭 타입을 사용하는데 첫 번째에는 엔티티 타입 클래스인 board를 넣었고
    //2번째는 기본키 타입을 넣어주었다.


    List<Board> findByBoardNm(int boardNm);

    List<Board> findByBoardTitleOrBoardDetail(String boardTitle, String boardDetail);

    List<Board> findByBoardNmLessThan(int boardNm);

    @Query("select i from Board i where i.boardDetail like %:boardDetail% order by i.boardNm desc")
    List<Board> findByBoardDetail(@Param("boardDetail") String boardDetail);
}
