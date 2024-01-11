package com.java.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.Member2Dto;
import com.java.www.dto.MemberDto;

@Mapper
public interface MemberMapper {

	//로그인 확인
	Member2Dto login(Member2Dto mdto);

	//회원가입
	void minsert(MemberDto mdto);



	// 비밀번호 찾기 - id email검색
	Member2Dto pwsearch(String id, String email);

	//패스워드 변경 - update
	void update_pw(String id, String pwcode);

	Member2Dto idsearch(String name, String email);

	//아이디 중복체크
	Member2Dto idCheck(String id);

	
}
