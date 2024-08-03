package com.spring.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.portfolio.entity.Board;
import com.spring.portfolio.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService; 
	
	@GetMapping("/")
	public String mainBoard() {
		return "mainBoard";
	}
	
	@GetMapping("/board/write")
	public String boardWrite() {
		return "boardWrite";
	}
	
	@PostMapping("/board/insertBoard")
	public String boardInsertBoard(Board board) {

		boardService.write(board);
		
		return "";
	}
}
