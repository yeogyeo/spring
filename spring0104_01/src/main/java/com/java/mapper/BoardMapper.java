package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	//전체게시글 가져오기
	List<BoardDto> blist();

	//게시글 저장
	void write(BoardDto bdto);

	//게시글 1개 가져오기
	BoardDto selectOne(int bno);

}
