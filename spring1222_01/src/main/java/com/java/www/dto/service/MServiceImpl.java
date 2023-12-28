package com.java.www.dto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.MemberDto;
import com.java.www.mapper.MemberMapper;

@Service
public class MServiceImpl implements MService {

	@Autowired
	MemberMapper memberMapper;
	
	//로그인
	@Override
	public MemberDto login(String id, String pw) {
		MemberDto mdto = memberMapper.login(id,pw);
		return mdto;
	}

	//아이디 중복 확인
	@Override
	public String idCheck(String id) {
		String result = "사용불가";
		MemberDto mdto = memberMapper.idCheck(id);
		if(mdto == null) {
			result ="사용가능";
		}
		return result;
	}

	//회원가입
	@Override
	public String mInsert(MemberDto mdto) {
		String result = "가입완료";
		memberMapper.mInsert(mdto);
		return result;
	}

}
