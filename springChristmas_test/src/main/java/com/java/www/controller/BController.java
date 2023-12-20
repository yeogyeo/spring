package com.java.www.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.www.dto.BoardDto;
import com.java.www.service.BService;

@Controller
public class BController {

	@Autowired
	BService bService;
	
	@GetMapping("bList")
	public String bList(Model model) {
		
		ArrayList<BoardDto> list = bService.selectAll();
		
		model.addAttribute("list", list);
		
		return "bList";
	}//bList
	
	@GetMapping("bView")
	public String bView(@RequestParam(defaultValue = "1")int bno, Model model) {
		
		Map<String, Object> map = bService.selectOne(bno);
		model.addAttribute("map",map);
		return "bView";
	}//bView
	
	@GetMapping("bInsert")
	public String bInsert() {
		return "bInsert";
	}//bInsert
	
	@PostMapping("bInsert")
	public String bInsert(BoardDto bdto, @RequestPart MultipartFile files,
			Model model) throws Exception {
		if(!files.isEmpty()) {
			String orgName = files.getOriginalFilename();
			System.out.println("BCon 파일이름 : "+ orgName);
			long time = System.currentTimeMillis();
			String newName = time+"_ "+orgName;
			String upload = "c:/upload/";
			File f = new File(upload+newName);
			files.transferTo(f);
			bdto.setBfile(newName);
		}else {
			bdto.setBfile("");
			System.out.println("파일 없음");
		}
		
		bService.bInsert(bdto);
		
		
		return "doBInsert";
	}//bInsert 글쓰기 저장
	
	@GetMapping("bInsert2")
	public String bInsert2() {
		
		return "bInsert2";
  }
	
	@PostMapping("bInsert2")
	public String bInsert2(BoardDto bdto, List<MultipartFile> files, Model model) throws Exception {
		String orgName = "";
		String newName = "";
		String mergeName = "";
		int i=0;
		for(MultipartFile file:files) {
			orgName = file.getOriginalFilename();
			System.out.println("BCon 파일이름 : "+ orgName);
			long time = System.currentTimeMillis();
			newName += time+"_"+orgName;
			String upload = "c:/upload/";
			File f = new File(upload+newName);
			file.transferTo(f);
			
			if(i==0) mergeName += time+"_"+orgName;
			else mergeName += ","+time+"_"+orgName;
			i++;
		} //for
		
		bdto.setBfile(mergeName);
		System.out.println("BCon 최종 파일 이름 : "+ mergeName);
		
		bService.bInsert(bdto);
		
		return "bInsert2";
	}// bInsert2
	
	@PostMapping("bDelete")
	public String bDelete(@RequestParam(defaultValue = "1")int bno) {
		bService.bDelete(bno);
		
		return "bDelete";
	}//bDelect
	
	@PostMapping("bUpdate")
	public String bUpdate(@RequestParam(defaultValue = "1")int bno, Model model) {
		Map<String, Object> map = bService.selectOne(bno);
		model.addAttribute("map",map);
		return "bUpdate";
	}
	
	@PostMapping("doBUpdate")
	public String doBUpdate(BoardDto bdto, @RequestPart MultipartFile files) throws Exception {
		String orgName = "";
		String newName = "";
		if(!files.isEmpty()) {
			orgName = files.getOriginalFilename();
			long time = System.currentTimeMillis();
			newName = time+"_"+orgName;
			String upload = "c:/upload/";
			File f = new File(upload+newName);
			files.transferTo(f);
			bdto.setBfile(newName);
		}
		
		bService.doBUpdate(bdto);
		return "doBUpdate";
		
	}//doBUpdate
	
	@PostMapping("bReply")
	public String bReply(@RequestParam(defaultValue = "1")int bno, Model model) {
		Map<String, Object> map = bService.selectOne(bno);
		model.addAttribute("map",map);
		
		return "bReply";
	}//bReply
	
	@PostMapping("doBReply")
	public String doBReply(BoardDto bdto, @RequestPart MultipartFile files, Model model) throws Exception {
		if(!files.isEmpty()) {
			String orgName = files.getOriginalFilename();
			long time = System.currentTimeMillis();
			String newName = time+"_"+orgName;
			String upload = "c:/upload/";
			File f = new File(upload+newName);
			files.transferTo(f);
			bdto.setBfile(newName);
		
		}else {
			bdto.setBfile("");
			System.out.println("doB 파일없음");
		}
		
		bService.doBReply(bdto);
		
		return "doBReply";
	} // doBReply
	


	
	
	
	
	
	
	
	
	
	
	
	

}//class
