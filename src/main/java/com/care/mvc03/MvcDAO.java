package com.care.mvc03;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class MvcDAO {
	public ArrayList<MvcDTO> members(){
		ArrayList<MvcDTO> list = new ArrayList<MvcDTO>();
		for(int i=0; i< 10; i++) {
			MvcDTO dto = new MvcDTO();
			dto.setName("홍길동 : "+i);
			dto.setAddr("산골짜기 : "+i);
			dto.setAge(i*10);
			list.add(dto);
		}
		return list;
	}
	public MvcDTO member() {
		MvcDTO dto = new MvcDTO();
		dto.setName("김말이");
		dto.setAddr("분식집");
		dto.setAge(1000);
		return dto;
	}
}
