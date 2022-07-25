package com.care.mvc04;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("mvc04") //하위 경로 설정
public class mvc04Controller {
	@GetMapping("index") //GET 방식으로 페이지 요청 //해당 매핑 경로를 요청하게 되면 해당 메소드 실행
	public String index() {
		return "mvc04_get_post/index"; //JSP페이지로 연결
	}
	
	@GetMapping("/result") //GET 방식
	//@RequestMapping("mvc04/result") //GET방식과 POST방식 둘다 받을 수 있다.
	public String get_result(HttpServletRequest req, Model model) { //Request객체로 받아서 getParameter로 꺼내서 사용 //값 전달을 하기위해 Model을 사용
		System.out.println("get 통신");
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("age"));
		
		model.addAttribute("n", req.getParameter("name"));
		model.addAttribute("a", req.getParameter("age"));
		model.addAttribute("method", req.getMethod());
		
		return "mvc04_get_post/result"; //error404 : 경로에 대한 오류
	}
	
	@PostMapping("result") //POST 방식
	public String post_result(@RequestParam("name") String n, @RequestParam("age") int a, Model model, HttpServletRequest request) { //넘어오는 값의 이름과 받는 값의 이름이 같아야 한다 //@RequestParam을 통해서 넘어오는 값을 지정 변수에 저장
		System.out.println(n);
		System.out.println(a);
		model.addAttribute("method", request.getMethod()); //getMethod: 현재 통신 방식(GET/POST)을 얻어옴
		model.addAttribute("n", n);
		model.addAttribute("a", a);
		return "mvc04_get_post/result";
	}
	
	@PostMapping("obj_result") //POST 방식
	public String obj_result(Model model, TestDTO dto, HttpServletRequest request) { //해당하는 페이지의 넘어오는 값을 한번에 받아줌
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		
		model.addAttribute("dto", dto);
		
		return "mvc04_get_post/obj_result";
	}
}
