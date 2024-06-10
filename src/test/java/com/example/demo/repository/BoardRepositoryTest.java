package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;

//단위테스트의 목적: 리파지토리가 가지고 있는 기능을 단독으로 테스트하기 위함

@SpringBootTest // 컨테이너 환경을 가져옴. 없으면 repository가 null값을 가짐
public class BoardRepositoryTest {

	@Autowired
	BoardRepository repository;
	
	@Test
	void 빈을가지고왔는지확인() {
		System.out.println("repository의 주소:" + repository);
	}
	
	@Test
	void 게시물등록() {
		
		Board board = Board.builder()
							.title("1번글")
							.content("내용입니다")
							.writer("둘리")
							.build();
		
		System.out.println("등록전: " + board.toString());
		
		repository.save(board);
		
		System.out.println("등록후: " + board);
	}
	
	@Test
	void 게시물목록조회() {
		List<Board> list = repository.findAll();
		
		for (Board board : list)
			System.out.println(board);
	}
	
	@Test
	void 게시물단건조회() {
		Optional<Board> result = repository.findById(1);
		
		if(result.isPresent()) {
			Board board = result.get();
			System.out.println(board);
		}
	}
	
	@Test
	void 게시물수정() {
		
		Optional<Board> result = repository.findById(1);
		Board board = result.get();
		board.setContent("내용수정");
		board.setWriter("또치");
		
		repository.save(board); // 수정
		System.out.println(board);
	}
	
	@Test
	void 게시물삭제() {
		repository.deleteAll();
	}
}
