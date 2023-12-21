package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.EmpDepartDto;
import com.java.www.dto.EmpDto;
import com.java.www.dto.MemBoardDto;

@Mapper
public interface EmpMapper {

	ArrayList<EmpDto> selectAll();

	//사원,부서정보
	ArrayList<EmpDepartDto> selectAll2();
	
	ArrayList<MemBoardDto> selectAll3();


	

}
