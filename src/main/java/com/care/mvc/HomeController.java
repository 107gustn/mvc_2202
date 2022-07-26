package com.care.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping("re/index")
	public void index() {}
	
	@RequestMapping("re/result")
	public String result(HttpServletRequest request, Model model, RedirectAttributes rs) { //특정값 Model에 저장해서 넘겨줌 //RedirectAttributes: 한단계를 건너뛰어서 다음위치까지 값을 전달시킬수 있게 해준다
		String id = request.getParameter("id");
		if(id.equals("abc")) {
			model.addAttribute("result", "로그인 성공"); //model에 값 저장 //model값은 연결되는 위치까지만 값 전달이 가능하다.
			rs.addFlashAttribute("re", "re로그인 성공=="); //RedirectAttributes 사용시 model이 null값 된다
			return "redirect:rsOK"; //JSP페이지가 아닌 컨트롤러 경로로 요청 //경로를 다시 요청하기때문에 url경로가 남지 않음
		}
		return "redirect:rsNO"; //사용자가 요청시 해당 경로에 연산이 필요하면 redirect 사용(세션 생성시)
	}
	
	@GetMapping("re/rsOK")//성공시
	public String ok(String result, Model model) { //JSP페이지로 값전달하기위해 model 사용
		model.addAttribute("result", result); //Model을 통해 값을 전달받아서 Model에 한번 더 포장해서 값 전달
		System.out.println("result : " + result); //넘어오는 값 확인
		return "re/rsOK"; //rsOK.jsp 페이지로 연결
	}
	
	@GetMapping("re/rsNO")//실패시
	public String no() {
		return "re/rsNO";
	}
	
}
