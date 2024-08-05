package com.spring.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.portfolio.entity.Board;
import com.spring.portfolio.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	// 글 작성
	public void write(Board board) {
		boardRepository.save(board);
	}
	// 게시글 리스트 처리
	public List<Board> boardList() {
		return boardRepository.findAll();
	}
	// 게시글 상세 보기
	public Board boardView(Integer id) {
		
		return boardRepository.findById(id).get();
	}
	
}
