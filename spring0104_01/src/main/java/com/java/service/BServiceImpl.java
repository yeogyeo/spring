package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {

	@Autowired BoardMapper boardMepper;
	
	@Override //전체게시글 가져오기
	public List<BoardDto> blist() {
		
		List<BoardDto> list = boardMepper.blist();
		return list;
	}

	@Override //게시글 저장
	public void write(BoardDto bdto) {
		boardMepper.write(bdto);
		
	}

	@Override //게시글 1개 가져오기
	public BoardDto selectOne(int bno) {
		BoardDto bdto = boardMepper.selectOne(bno);
		return bdto;
	}

}
