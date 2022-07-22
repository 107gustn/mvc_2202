package com.care.mvc02;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@Inject //bean들을 주입할때 사용 하는 어노테이션( @Autowired == @Inject )
	TestService ts;
	
//	@Autowired //한 어노테이션에 한개씩 들어가야 한다.
//	TestDAO dao;
	
	@GetMapping("test_index") //GET방식으로 요청값만 연결
	public String testIndex() {
		System.out.println("ts : " + ts);
		ts.service();
		return "member/index";
	}
}
