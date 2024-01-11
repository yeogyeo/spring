package com.java.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.www.dto.Member2Dto;
import com.java.www.dto.MemberDto;
import com.java.www.service.EmailService;
import com.java.www.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("member")
public class MController {
	
	@Autowired
	MService mService;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	EmailService emailService;
	
	
	@GetMapping("id")
	public String id() {
		return "member/id";
	}
	
	@GetMapping("idsearch") // idsearch 페이지열기 
	public String idsearch() {
		return "member/idsearch";
	}
	
	@PostMapping("idsearch") //ajax 아이디찾기 - name, email
	@ResponseBody
	public String idsearch(String name, String email) {
		System.out.println("MController idsearch name : "+name);
		System.out.println("MController idsearch email : "+email);
		Member2Dto m2dto = mService.idsearch(name, email);
		String result = "";
		String tempId=""; //임시아이디
		//찾은 아이디에 뒤 두자리에 **로 변경
		if(m2dto!=null) { //abc**
			tempId = m2dto.getId().substring(0,m2dto.getId().length()-2);
			tempId += "**";
			System.out.println("찾은 아이디 : "+tempId);
			result = tempId;
			
		}else {
			result = "fail";
		}
		
		return "success";
	} // idsearch
	
	@PostMapping("pwsearch")
	@ResponseBody
	public String pwsearch(String id, String email) {
		System.out.println("MConctroller id : "+id);
		System.out.println("MConctroller email : "+email);
		
		//service 연결 - 비밀번호 찾기 id, email검색 
		String result = mService.pwsearch(id,email);
		
		
		return "result";
	}
	

	
	@GetMapping("step01")
	public String step01() {
		return "member/step01";
	}
	
	@GetMapping("step02")
	public String step02() {
		return "member/step02";
	}
	
	@GetMapping("step03")
	public String step03() {
		return "member/step03";
	}
	
	@PostMapping("idCheck")
	@ResponseBody
	public String idCheck(String id) {
		String result = "";
		Member2Dto m2dto = mService.idCheck(id);
		if(m2dto==null) {
			result = "사용가능";
		}else {
			result = "사용불가";
		}
		
		
		return result;
	}
	
	@PostMapping("step04")
	public String step04(Member2Dto m2dto) {
		System.out.println("mcontroller step04 phone : "+m2dto.getPhone());
		
		
		return "member/step04";
	}
	
	@PostMapping("step03")
	public String step03(MemberDto mdto, String fphone, String mphone, String lphone) {
		String phone = fphone+"-"+mphone+"-"+lphone;
		mdto.setPhone(phone);
		mService.minsert(mdto);
		
		
		return "member/step04";
	}
	
	
	
	@PostMapping("email")
	@ResponseBody
	public String email(String email) {
		System.out.println("MController email : "+email);
		
		//service연결 - 이메일 주소 보냄.
		String result = emailService.mailSend(email);
		
		
		return result;
	}
	
	
	@PostMapping("pwChk") //인증코드 확인
	@ResponseBody
	public String pwChk(String pwcode) {
		System.out.println("MController pwcode : "+pwcode);
		String pw = (String) session.getAttribute("email_pwcode");
		String result = "fail";
		if(pw.equals(pwcode)) {result="success";}
			
		
		return result;
	}
	
	

	
	
	//---- 로그인 부분 ----
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("logout")
	public String logout() {
		session.invalidate();
		return "member/logout";
	}

	//--------- 로그인 확인부분 ----------
	//--------- ajax 형태 ----------
	@PostMapping("ajaxLogin")
	@ResponseBody
	public String ajaxLogin(Member2Dto mdto) {
		System.out.println("MController login id : "+mdto.getId());
		System.out.println("MController login pw : "+mdto.getPw());
		
		//service 연결 - result = 1(로그인), 0(아이디 또는 패스워드가 일치X)
		int result = mService.login(mdto);

		return result+"";
	}
	
	//--------- jsp 형태 ----------
	@PostMapping("login")
	public String login(Member2Dto mdto, Model model) {
		System.out.println("MController login id : "+mdto.getId());
		System.out.println("MController login pw : "+mdto.getPw());
		
		//service 연결 - result = 1(로그인), 0(아이디 또는 패스워드가 일치X)
		int result = mService.login(mdto);
		//model 전송
		model.addAttribute("result",result);
		return "member/doLogin";
	}
}
