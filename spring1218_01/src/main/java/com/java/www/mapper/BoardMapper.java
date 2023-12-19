package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.BoardDto;

@Mapper
public interface BoardMapper {

	//게시글 전체가져오기
	ArrayList<BoardDto> bList();

	//게시글 1개 가져오기
	BoardDto selectOne(int bno);

}
