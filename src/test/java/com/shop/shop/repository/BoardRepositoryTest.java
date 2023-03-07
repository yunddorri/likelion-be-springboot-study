package com.shop.shop.repository;

import com.shop.shop.entity.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import java.time.LocalDateTime;

import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    //insert query문 없이 게시판 테이블에 데이터를 insert하는 테스트를 작성하였습니다.
    @Test
    @DisplayName("게시글 저장 테스트")
    public void createBoardTest(){
        Board board = new Board();
        board.setBoardNm(1);
        board.setBoardTitle("제목");
        board.setBoardDetail("내용");
        board.setRegTime(LocalDateTime.now());

        Board savedBoard = boardRepository.save(board);
        System.out.println(savedBoard.toString());
    }

    //테스트 코드 실행 시 db에 게시글 데이터가 없기 때매 테스트 데이터 생성을 위해 게시글을 저장하는 메서드를 작성하였습니다.
    public void createBoardList(){
        for(int i=2;i<=11;i++){
            Board board = new Board();
            board.setBoardNm(i);
            board.setBoardTitle("제목"+i);
            board.setBoardDetail("내용"+i);
            board.setRegTime(LocalDateTime.now());

            Board savedBoard2 = boardRepository.save(board);
        }
    }

    @Test
    @DisplayName("게시판 조회 테스트")
    public void findByBoardNmTest(){
        this.createBoardList();
        List<Board> boardList = boardRepository.findByBoardNm(3);
        for(Board board : boardList){
            System.out.println(board.toString());
        }
    }

    @Test
    @DisplayName("제목, 내용 OR 테스트")
    public void findByTitleOrDetailTest(){
        this.createBoardList();
        List<Board> boardList = boardRepository.findByBoardTitleOrBoardDetail("제목4", "내용5");
        for(Board board : boardList){
            System.out.println(board.toString());
        }
    }


    @Test
    @DisplayName("게시글 번호 LessThan 테스트")
    public void findByNumLessThanTest(){
        this.createBoardList();
        List<Board> boardList = boardRepository.findByBoardNmLessThan(5);
        for(Board board : boardList){
            System.out.println(board.toString());
        }
    }

    @Test
    @DisplayName("Query를 이용한 게시물 조회 테스트")
    public void findByBoardDetailTest(){
        this.createBoardList();
        List<Board> boardList = boardRepository.findByBoardDetail("내용");
        for(Board board : boardList){
            System.out.println(board.toString());
        }
    }

}