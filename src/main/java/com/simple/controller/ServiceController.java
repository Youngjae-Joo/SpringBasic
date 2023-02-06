package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ScoreVO;
import com.simple.score.service.ScoreService;

@Controller
@RequestMapping("service")
public class ServiceController {
	//1st
	//ScoreServiceImpl service =new ScoreServiceImpl();

	//2nd-service를 bean으로 생성한다. 의존객체자동주입
	
	//3rd -@Service로 빈으로 생성하고, 의존객체 자동주입
	@Autowired
	@Qualifier("service")
	private ScoreService service; //인터페이스 타입 선언
	
	
	//화면출력
	@RequestMapping("/scoreRegist")
	public void rigistView() {}
	
	//폼요청
	@PostMapping("/regist")
	public String regist(ScoreVO vo) {
		//System.out.println(vo.toString()) 넘어오는지 확인용;
		service.regist(vo);
		
		return "service/scoreResult";
	}
	
	//목록화면
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
		//데이터조회
		ArrayList<ScoreVO> list=service.getList();
		model.addAttribute("list",list);
		return "service/scoreList";
	}
	
	//삭제요청
	@RequestMapping("/delete")
	public String delete(@RequestParam("num")int num) {
		service.delete(num);
		return "redirect:/service/scoreList";//삭제후에 목록으로
	}
	
	//수정
	@RequestMapping("/modify")
	public String modify(@ModelAttribute("num")int num,
						@ModelAttribute("name")String name,
						@ModelAttribute("kor")String kor,
						@ModelAttribute("eng")String eng) {
		return	"service/scoreModify";
	}
	
	
	@RequestMapping("/modifyThis")
	public String modifyThis(ScoreVO vo) {
		service.modify(vo.getNum(),vo.getName(),vo.getKor(),vo.getEng());
		return "redirect:/service/scoreList";
	}
	
	
}
