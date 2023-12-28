package com.java.www.dto.service;

import com.java.www.dto.MemberDto;

public interface MService {

	//로그인 확인
	MemberDto login(String id, String pw);

	//아이디 중복 확인
	String idCheck(String id);

	//회원가입
	String mInsert(MemberDto mdto);

}
