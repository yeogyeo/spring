package com.java.www.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;

public interface BService {

	//게시글 전체 가져오기
	ArrayList<BoardDto> selectAll();

	//게시글 1개 가져오기
	Map<String, Object> selectOne(int bno);

	//댓글 1개 저장 후 댓글 1개 가져오기
	BCommentDto bCommentInsert(BCommentDto cdto);

	//댓글삭제
	String bCommentDelete(int cno);

	//댓글 수정 저장
	BCommentDto bCommentUpdate(BCommentDto cdto);

	

}
