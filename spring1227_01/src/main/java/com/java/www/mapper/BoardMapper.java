package com.java.www.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.BCommentDto;
import com.java.www.dto.BoardDto;

@Mapper
public interface BoardMapper {

	//게시글 전체 가져오기
	ArrayList<BoardDto> selectAll();

	//게시글 1개 가져오기
	BoardDto selectOne(int bno);

	//하단댓글 가져오기
	List<BCommentDto> bCommentSelectAll(int bno);

	//댓글 1개 저장 
	void bCommentInsert(BCommentDto cdto);

	//댓글 1개 가져오기
	BCommentDto bCommentSelectOne(int cno);

	//댓글 삭제
	int bCommentDelete(int cno);

	//댓글 수정 저장
	void bCommentUpdate(BCommentDto cdto);

	
	

}
