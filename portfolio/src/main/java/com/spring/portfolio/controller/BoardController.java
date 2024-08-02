package com.spring.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BoardController {

	@GetMapping("/")
	public String mainBoard() {
		return "mainBoard";
	}
	
	@GetMapping("/board/write")
	public String boardWrite() {
		return "boardWrite";
	}
	
}
