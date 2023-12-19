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
@RequestMapping("member")
public class MController {
	
	@Autowired //IOC컨테이너에 있는 객체 가져오기 
	MService mService;
	
	@Autowired
	HttpSession session;
	//HttpSession session = request.getSession();//이렇게 할필요 없이 위처럼 선언하면 됨
	
	
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("logout")
	public String logout() {
		session.invalidate();
		return "member/logout";
	}
	
	@RequestMapping("doLogin")
	public String doLogin(MemberDto mdto, Model model, HttpServletRequest request) {
		int result = 0;
		System.out.println("MController id : "+mdto.getId() );
		System.out.println("MController pw : "+mdto.getPw() );
		//db연결 - 리턴값:dto dto있는지 확인
		
		MemberDto  memberDto = mService.loginSelect(mdto); //id,pw
		
		if(memberDto!=null) {
			session.setAttribute("session_id", mdto.getId());
			session.setAttribute("session_name", mdto.getName());
			System.out.println("MController memberDto :null");
			result = 1;
		}
		
		//result 1로그인 성공, 0로그인실패
		model.addAttribute("result", result);
		return "member/doLogin";
	}
	
	

}
