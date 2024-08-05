package com.spring.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.portfolio.entity.Board;
import com.spring.portfolio.service.BoardService;
import org.springframework.web.bind.annotation.RequestParam;



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
	
	@GetMapping("/board/boardList")
	public String boardList(Model model) {
		model.addAttribute("list" , boardService.boardList());
		return "boardList";
	}
	
	@GetMapping("/board/view")
	public String boardView(Model model , Integer id) {
		model.addAttribute("board" , boardService.boardView(id));
		return "boardView";
	}
	
	
	
}
