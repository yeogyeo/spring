package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.BoardDto;

@Mapper
public interface BoardMapper {
	public int bListCount();

	//게시글 전체 가져오기
	public ArrayList<BoardDto> selectAll();

	//게시글 1개 가져오기 현재글
	public BoardDto selectOne(int bno);

	//게시글 1개 가져오기 이전글
	public BoardDto selectOnePrev(int bno);

	//게시글 1개 가져오기 다음글
	public BoardDto selectOneNext(int bno);

	//글쓰기 저장
	int bInsert(BoardDto bdto);
	
	
	
	
	
	

}
