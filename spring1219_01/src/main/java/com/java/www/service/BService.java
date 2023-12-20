package com.java.www.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.www.dto.BoardDto;

public interface BService {

	//게시글 전체 가져오기
	ArrayList<BoardDto> selectAll();

	//게시글 1개 가져오기
	Map<String, Object> selectOne(int bno);

	//글쓰기 저장
	void bInsert(BoardDto bdto);

	//게시글 삭제
	void bDelete(int bno);

	//게시글 수정 저장
	void doBUpdate(BoardDto bdto);

	//답변달기 저장
	void doBReply(BoardDto bdto);

}
