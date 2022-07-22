package com.care.mvc03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {
	@Autowired
	MvcServiceImpl ms;
	
	@GetMapping("m_index")
	public String mvc_index() {
		return "mvc/index";
	}
	@GetMapping("m_members")
	public String mvc_members(Model model) {
		model.addAttribute("list", ms.members());
		return "mvc/members";
	}
	@GetMapping("m_member")
	public String mvc_member(Model model) {
		ms.member(model);
		return "mvc/member";
	}
}