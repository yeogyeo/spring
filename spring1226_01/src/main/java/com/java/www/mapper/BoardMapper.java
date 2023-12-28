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

	//댓글 전체 가져오기
	List<BCommentDto> BCommentSelectAll(int bno);

	//db에 저장된 댓글 1개 가져오기
	void BCommentInsert(BCommentDto cdto);

	//저장된 댓글 1개 가져오기
	BCommentDto BCommentSelectOne(int cno);
	

}
