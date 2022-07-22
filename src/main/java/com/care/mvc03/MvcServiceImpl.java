package com.care.mvc03;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class MvcServiceImpl {
	@Autowired
	MvcDAO dao;
	public ArrayList<MvcDTO> members(){
		return dao.members();
	}
	public void member(Model model) {
		model.addAttribute("dto", dao.member());
	}
}
