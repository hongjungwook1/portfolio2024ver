package com.spring.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.portfolio.entity.Board;
import com.spring.portfolio.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService; 
	
	// 메인 화면
	@GetMapping("/")
	public String mainBoard(Model model) {
		model.addAttribute("list" , boardService.boardList());
		
		return "mainBoard";
	}
	
	// 글 작성
	@GetMapping("/board/write")
	public String boardWrite() {
		return "boardWrite";
	}
	
	
	// 글 추가
	@PostMapping("/board/insertBoard")
	public String boardInsertBoard(Board board) {
		boardService.write(board);
		return "redirect:/";
	}
	
	/* 사용 안함
	 * @GetMapping("/board/boardList") 
	 * public String boardList(Model model) {
	 * model.addAttribute("list" , boardService.boardList()); return "boardList"; 
	 * }
	 */
	
	
	// 게시글 상세보기
	@GetMapping("/board/view")
	public String boardView(Model model , Integer id) {
		model.addAttribute("board" , boardService.boardView(id));
		return "boardView";
	}
	
	
	// 게시글 삭제
	@GetMapping("/board/delete")
	public String boardDelete(Integer id) {
		boardService.boardDelete(id);
		
		return "redirect:/";
	}
	
	
	
	
}
