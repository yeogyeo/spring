package com.java.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.MemberDto;

@Mapper
public interface MemberMapper {

	//로그인
	MemberDto login(String id, String pw);

	//아이디 중복 확인
	MemberDto idCheck(String id);

	//회원가입
	void mInsert(MemberDto mdto);

}
