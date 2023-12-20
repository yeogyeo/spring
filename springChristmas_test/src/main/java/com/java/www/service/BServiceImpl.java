package com.java.www.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {

	@Autowired
	BoardMapper boardMapper;

	@Override
	public ArrayList<BoardDto> selectAll() {
		ArrayList<BoardDto> list = boardMapper.selectAll();
		return list;
	}

	@Override
	public Map<String, Object> selectOne(int bno) {
		BoardDto bdto = boardMapper.selectOne(bno);
		BoardDto pbdto = boardMapper.selectOneP(bno);
		BoardDto nbdto = boardMapper.selectOneN(bno);
		
		//boardMapper.bhitUp(bno);
		
		Map<String, Object> map = new HashMap<>();
		map.put("bdto", bdto);
		map.put("pbdto", pbdto);
		map.put("nbdto", nbdto);
		
		return map;
		
	}//selectOne

	@Override
	public void bInsert(BoardDto bdto) {
		// 글쓰기저장
		int result = boardMapper.bInsert(bdto);
		System.out.println("bSerIM result : "+result);
		
	}//bInsert

	@Override
	public void bDelete(int bno) {
		// 삭제
		int result = boardMapper.bDelete(bno);
	}

	@Override
	public void doBUpdate(BoardDto bdto) {
		// 수정저장
		int result = boardMapper.doBUpdate(bdto);
		
	}

	@Override
	public void doBReply(BoardDto bdto) {
		//답변저장
		
		boardMapper.bstepUp(bdto);
		int result = boardMapper.doBReply(bdto);
	}
	
	
	
	
}
