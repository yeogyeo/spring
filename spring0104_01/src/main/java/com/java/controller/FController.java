package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@Autowired BService bService;
	@Autowired HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("bview")
	public String bview(@RequestParam(defaultValue = "1") int bno, Model model) {
		//게시글 1개 가져오기
		BoardDto bdto = bService.selectOne(bno);
		model.addAttribute("bdto",bdto);
		return "bview";
	}
	
	@GetMapping("bwrite")
	public String bwrite() {
		return "bwrite";
	}
	
	@GetMapping("write")
	public String write() {
		return "write";
	}
	
	//내용부분 - 이미지추가 시 호출
	@PostMapping("summernoteUpload")
	@ResponseBody
	public String summernoteUpload(@RequestPart MultipartFile file) throws Exception {
		String urllink = "";
		if(!file.isEmpty()) {
			String oriFName = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			String upFName = time+"_"+oriFName;
			String fupload = "c:/upload/";
			
			//파일서버에 업로드 부분
			File f = new File(fupload+upFName);
			file.transferTo(f);
			
			//파일저장위치
			urllink = "/upload/"+upFName;
			System.out.println("summernoteUpload 파일 저장위치 : "+urllink);
		
		}
		
		return urllink;
	}//summernoteUpload
	
	//submit버튼 클릭 시 파일 업로드
	@PostMapping("write")
	public String write(BoardDto bdto, @RequestPart MultipartFile file, Model model) throws Exception {
		System.out.println("FC bdto btitle : "+bdto.getBtitle());
		System.out.println("FC bdto bcontent : "+bdto.getBcontent());
		if(!file.isEmpty()) {
			String oriFName = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			String upFName = time+"_"+oriFName;
			String fupload = "c:/upload/";
			
			//파일서버에 업로드 부분
			File f = new File(fupload+upFName);
			file.transferTo(f);
			
			//bdto bfile 추가
			bdto.setBfile(upFName);
			
		}else {
			bdto.setBfile("");
		}
		
		System.out.println("파일첨부 이름 : "+bdto.getBfile());
		//service연결 - 게시글 저장
		bService.write(bdto);
		model.addAttribute("result","write-s");
		return "doFboard";
	}//write
	
	@GetMapping("blist")
	public String blist(Model model) {
		//전체게시글 가져오기
		List<BoardDto> list = bService.blist();
		model.addAttribute("list",list);
		
		return "blist";
	}

}
