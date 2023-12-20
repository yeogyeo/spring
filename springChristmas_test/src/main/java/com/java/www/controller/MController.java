package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.www.dto.MemberDto;
import com.java.www.service.MService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MController {
	
	@Autowired
	MService mService;
	
	@Autowired
	HttpSession session;

	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("logout")
	public String logout() {
		session.invalidate();
		
		return "logout";
	}
	
	@RequestMapping("doLogin")
	public String doLogin(MemberDto mdto, Model model, HttpServletRequest request) {
		int result = 0;
		
		MemberDto memdto = mService.loginSelect(mdto);
		
		if(memdto!=null) {
			session.setAttribute("session_id", memdto.getId());
			session.setAttribute("session_name", memdto.getName());
			result = 1;
		}
		model.addAttribute("result", result);
		return "doLogin";
	}
	
}
