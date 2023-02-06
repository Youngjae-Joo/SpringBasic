package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.BoardVO;
import com.simple.score.service.BoardService;

@Controller
@RequestMapping("/service")
public class BoardServiceController {
	
	@Autowired
	@Qualifier("boardservice")
	private BoardService bservice;
	
	//regist
	@RequestMapping("/boardRegister")
	public String showBoardRegister() {
		return "service/boardRegister";
	}
	
	
	@PostMapping("/boardRegist")
	public String boardRegist(BoardVO vo) {
		bservice.boardRegist(vo);
		return "service/boardResult";
	}
	
	//result
	@RequestMapping("/boardResult")
	public String boardResult() {
		return "service/boardResult";
	}
	
	
	//list
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		ArrayList<BoardVO> list=bservice.getList();
		model.addAttribute("lists",list);
		return "service/boardList";
	}
	
	//delete
	@RequestMapping("/deleteBoard")
	public String deleteBoard(@RequestParam("num")int num) {
		bservice.boardDelete(num);
		return "redirect:/service/boardList";
	}
	
}
