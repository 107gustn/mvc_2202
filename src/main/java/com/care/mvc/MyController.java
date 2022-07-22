package com.care.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//경로 요청시 @Controller 인식
@Controller
public class MyController {

	//경로 결정 역할
	@RequestMapping("test")
	public void test() {
		System.out.println("=== test 연결");
	}
	
	//인터넷 URL경로
	@RequestMapping(value="/index")
	public String index() {
		return "member/index"; //JSP 파일 경로 - views까지 기본경로로 설정되어 있음(.jsp 생략)
	}
	
	//값 전달 방법 - Model or ModelAndView
	@RequestMapping(value="login")
	public String login(Model model) { //값을 전달할 때 Model을 이용함 //model: 자동적으로 값이 들어옴
		
		String[] str = {"aaaa", "bbbb", "cccc"};
		model.addAttribute("str", str);
		
		model.addAttribute("test", "로그인페이지"); //값 설정(key, value) //model = request - 연결되어있는 JSP페이지 까지만 값 유지
		return "member/login"; //model에 값을 저장해서 돌려줌
	}
	
	@RequestMapping(value="logout")
	public ModelAndView logout() { //ModelAndView: 매개변수로 자동 주입이 안돼서 따로 객체를 만들어서 사용
		ModelAndView mv = new ModelAndView();
		mv.addObject("logout", "로그아웃페이지입니다");
		mv.setViewName("member/logout");
		return mv;
	}
}
