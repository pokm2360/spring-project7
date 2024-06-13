package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

@Service
public class BoardServicelmpl implements BoardService {

	@Autowired
	BoardRepository repository;
	
	@Override
	public int register(BoardDTO dto) { 
		
		Board entity = dtoToEntity(dto); // dto -> entity 변환
		
		repository.save(entity); // 변환한 엔티티를 저장 - 저장 후 날짜/시간데이터 추가
		
		int newNo = entity.getNo();
		
		return newNo; // 새로운 글의 번호 반환
	}

	@Override
	public List<BoardDTO> getList() {
		
		List<Board> entityList = repository.findAll(); // 게시물 목록 조회
		
//		Entity 리스트 -> DTO 리스트 변환
		List<BoardDTO> dtoList = new ArrayList<>();
		
		dtoList = entityList.stream()
						.map(entity -> entityToDto(entity))
						.collect(Collectors.toList());
		
		return dtoList; // DTO 리스트 반환
	}

	@Override
	public BoardDTO read(int no) {
		
		Optional<Board> result = repository.findById(no);
		
		if (result.isPresent()) {
			Board board = result.get();
			BoardDTO boardDTO = entityToDto(board); // entity -> dto
			return boardDTO;
		} else {
			return null;
		}
	}

	@Override
	public void modify(BoardDTO dto) {
		
		Optional<Board> result = repository.findById(dto.getNo());
		
		if(result.isPresent()) {
//			제목과 내용 변경
			Board entity = result.get();
			entity.setTitle(dto.getTitle());
			entity.setContent(dto.getContent());
//			게시물 교체
			repository.save(entity);
		}
	}

	@Override
	public int remove(int no) {
		
		Optional<Board> result = repository.findById(no);
		
		if (result.isPresent()) {
			repository.deleteById(no);
			return 1; //성공
		}	else {
			return 0; //실패
		}
	}
}