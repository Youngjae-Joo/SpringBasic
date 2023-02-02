package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;
import com.simple.command.Quiz03VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	//quiz01
	@RequestMapping("/quiz01")
	public void quiz01() {}
	
	@RequestMapping("/quiz01_ok")
	public String quiz01_ok() {
		return "quiz/quiz01_ok";
	}
	
//	@RequestMapping("/sendBirth")
//	public String sendBirth(@ModelAttribute("birth")Quiz01VO vo) {
//		
//		System.out.println(vo.toString());
//		//출력문을 2023412가 아니라 20230412처럼 하려면 vo setter가 아니라 컨트롤러를 수정해야 한다.
//		return "quiz/quiz01_ok";
//	}
	
	@RequestMapping("/sendBirth")
	public String sendBirth(Quiz01VO vo, Model model) {
		String month="0";
		String day="0";
		if(vo.getMonth().length()==1) {
			month=month.concat(vo.getMonth());
		}else {
			month=vo.getMonth();
		}
		
		if(vo.getDay().length()==1) {
			day=day.concat(vo.getDay());
		}else {
			day=vo.getDay();
		}
		
		
		System.out.println(vo.getYear()+month+day);
		model.addAttribute("birth", vo.getYear()+"년 "+month+"월 "+day+"일");
		return "/quiz/quiz01_ok";
	}
	
	///////////////////////////////////////////////////////////////
	//quiz02
	@RequestMapping("/quiz02")
	public String quiz02() {
		return "quiz/quiz02";
	}
	
	@RequestMapping("/quiz02_ok")
	public String quiz02_ok() {
		return "/quiz/quiz02_ok";
	}
	
	@PostMapping("/join")
	public ModelAndView join(@RequestParam(value="id", required = false,defaultValue = "") String id,
			@RequestParam(value="pw", required = false,defaultValue = "")String pw,
			@RequestParam(value="name", required = false,defaultValue = "")String name,
			@RequestParam(value="email", required = false,defaultValue = "")String email) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",id);
		mv.addObject("pw",pw);
		mv.addObject("name",name);
		mv.addObject("email",email);
		mv.setViewName("/quiz/quiz02_ok");
		
		return mv;
	}
	
	///////////////////////////////////////////////////////////////
	//quiz03
	@RequestMapping("/quiz03")
	public String quiz03() {
	return "quiz/quiz03";
	}
	
	@RequestMapping("/quiz03_ok")
	public String quiz03_ok() {
		return "/quiz/quiz03_ok";
	}
	
	@RequestMapping("join2")
	public String join2(@ModelAttribute("info")Quiz03VO vo,RedirectAttributes ra) {
		if(vo.getId().equals("")) {
			ra.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		}
		
		if(vo.getPw().equals("")||vo.getPw_check().equals("")) {
			ra.addFlashAttribute("msg", "비밀번호를 입력하세요");
			return "redirect:/quiz/quiz03";
		}else if(!vo.getPw().equals(vo.getPw_check())) {
			ra.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		}
		
		return "/quiz/quiz03_ok";
	}
	
	
}
