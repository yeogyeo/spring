package com.java.www.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.www.dto.EmpDepartDto;
import com.java.www.dto.EmpDto;
import com.java.www.dto.MemBoardDto;
import com.java.www.dto.MemberDto;
import com.java.www.sercive.EService;

@Controller
public class FController {
	
	@Autowired
	EService eService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("list")
	public String list(EmpDto edto, Model model) {
		
		ArrayList<EmpDto> list = eService.selectAll(); 
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("list2")
	public String list2(EmpDto edto, Model model) {
		
		ArrayList<EmpDepartDto> list = eService.selectAll2(); 
		model.addAttribute("list", list);
		return "list2";
	}
	
	@GetMapping("list3")
	public String list3(Model model) {
		
		ArrayList<MemBoardDto> list = eService.selectAll3(); 
		model.addAttribute("list", list);
		return "list3";
	}
	
	
	
	
	
	
	
	
	

}
