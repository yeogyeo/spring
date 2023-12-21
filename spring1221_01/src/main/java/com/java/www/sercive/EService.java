package com.java.www.sercive;

import java.util.ArrayList;

import com.java.www.dto.EmpDepartDto;
import com.java.www.dto.EmpDto;
import com.java.www.dto.MemBoardDto;

public interface EService {

	ArrayList<EmpDto> selectAll();

	ArrayList<EmpDepartDto> selectAll2();

	ArrayList<MemBoardDto> selectAll3();

	

}
