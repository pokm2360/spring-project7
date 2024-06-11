package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;

public interface BoardService {

//	추상메소드 (게시물과 관련된 기능)
	
//	게시물 등록 메소드 (추상 메소드)
	int register(BoardDTO dto);
	
//	게시물 목록조회 메소드 - 컨트롤러에 리스트를 반환
	List<BoardDTO> getList();
	
//	dto를 엔티티로 변환하는 메소드(일반메소드)
	default Board dtoToEntity(BoardDTO dto) {
		
		Board entity = Board.builder()
						.no(dto.getNo())
						.title(dto.getTitle())
						.content(dto.getContent())
						.writer(dto.getWriter())
						.build();
						
		return entity;
	}
//	추상메소드의 목적 : 자식 클래스들이 각자 구현해서 사용하는 기술
//	일반메소드의 목적 : 자식 클래스들이 공통으로 사용하는 기능
	
//	엔티티를 dto로 변환하는 메소드
//	매개변수: 엔티티, 리턴타입: DTO
	default BoardDTO entityToDto(Board entity) {
		
		BoardDTO dto = BoardDTO.builder()
					.no(entity.getNo())
					.title(entity.getTitle())
					.content(entity.getContent())
					.writer(entity.getWriter())
					.redDate(entity.getRegDate())
					.modDate(entity.getModDate())
					.build();
		
		return dto;
	}
}
