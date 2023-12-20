package com.java.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.MemberDto;
import com.java.www.mapper.MemberMapper;

@Service
public class MServiceImpl implements MService {
	
	@Autowired
	MemberMapper memberMapper;

	@Override // 로그인
	public MemberDto loginSelect(MemberDto mdto) {
		MemberDto memdto = memberMapper.loginSelect(mdto);
		return memdto;
	}

}
