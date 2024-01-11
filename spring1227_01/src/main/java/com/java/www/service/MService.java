package com.java.www.service;

import com.java.www.dto.Member2Dto;
import com.java.www.dto.MemberDto;

public interface MService {

	//로그인 확인
	int login(Member2Dto mdto);

	//회원가입
	void minsert(MemberDto mdto);

	

	//비밀번호 찾기 - id, email검색
	String pwsearch(String id, String email);

	Member2Dto idsearch(String name, String email);

	//아이디 중복체크
	Member2Dto idCheck(String id);

}
