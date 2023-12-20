package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	public int bListCount();

	public ArrayList<BoardDto> selectAll();

	public BoardDto selectOne(int bno);

	public BoardDto selectOneP(int bno);

	public BoardDto selectOneN(int bno);

	public int bInsert(BoardDto bdto);

	public int bDelete(int bno);

	public int doBUpdate(BoardDto bdto);

	public void bstepUp(BoardDto bdto);

	public int doBReply(BoardDto bdto);

	
		

}
