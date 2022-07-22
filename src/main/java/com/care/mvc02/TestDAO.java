package com.care.mvc02;

import org.springframework.stereotype.Repository;

@Repository("aaaaaaaaa") //이름 지정 빈으로 생성
public class TestDAO {
	public TestDAO() {
		System.out.println("dao 생성자 실행");
	}
}
