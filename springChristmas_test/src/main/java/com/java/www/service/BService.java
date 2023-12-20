package com.java.www.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.www.dto.BoardDto;

public interface BService {

	//전체 게시글 불러오기
	ArrayList<BoardDto> selectAll();

	//게시글 하나 불러오기
	Map<String, Object> selectOne(int bno);

	//글쓰기저장
	void bInsert(BoardDto bdto);
	
	//삭제
	void bDelete(int bno);

	//수정저장
	void doBUpdate(BoardDto bdto);

	//답변달기 저장
	void doBReply(BoardDto bdto);

}
