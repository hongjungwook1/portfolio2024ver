package com.spring.portfolio.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.portfolio.entity.Board;
import com.spring.portfolio.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private PasswordEncoder pWEncoder;
	
	// 글 작성
	public void write(Board board) {
		board.setName(generateRandomAuthor());
		board.setPassword(pWEncoder.encode(board.getPassword()));
		boardRepository.save(board);
	}
	
	// 작성자 랜덤 아이디 생성
    private String generateRandomAuthor() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 8;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                     .limit(targetStringLength)
                     .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                     .toString();
    }
	
	// 게시글 리스트 처리
	public List<Board> boardList() {
		return boardRepository.findAll();
	}
	
	// 게시글 상세 보기
	public Board boardView(Integer id) {
		return boardRepository.findById(id).get();
	}
	
	// 게시글 삭제
	public void boardDelete(Integer id) {
		boardRepository.deleteById(id);
	}
	
	
}
