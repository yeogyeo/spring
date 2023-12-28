package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.MemberDto;
import com.java.www.dto.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("member")
public class MController {
	
	@Autowired
	MService mService;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("login") //로그인 페이지 이동
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login") //로그인 확인
	public String login(String id, String pw, Model model) {
		int result=0;
		MemberDto mdto = mService.login(id,pw);
		if(mdto!=null) {
			session.setAttribute("session_id", mdto.getId());
			session.setAttribute("session_name", mdto.getName());
			result=1;
		}
		model.addAttribute("result",result);
		return "member/doLogin";
	}
	
	@GetMapping("logout") //로그아웃 
	public String logout() {
		session.invalidate();
		return "member/logout";
	}
	
	
	@GetMapping("join01")
	public String join01() {
		return "member/join01";
	}
	
	@PostMapping("join02")
	public String join02() {
		return "member/join02";
	}
	
	@PostMapping("idCheck")
	@ResponseBody
	public String idCheck(String id) {
		System.out.println("MController idCheck id : "+id);
		String result = "사용가능";
		//db접근
		result = mService.idCheck(id);
		return result;
	}
	
	@PostMapping("mInsert")
	@ResponseBody
	public String mInsert(MemberDto mdto,String f_tell,String m_tell,String l_tell) {
		
		String phone=f_tell+"-"+m_tell+"-"+l_tell;
		mdto.setPhone(phone);
		String result = mService.mInsert(mdto);
		return result;
	}
	
	@GetMapping("join03")
	public String join03() {
		return "member/join03";
	}

}
