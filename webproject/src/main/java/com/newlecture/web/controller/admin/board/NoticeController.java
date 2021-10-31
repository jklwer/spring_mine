package com.newlecture.web.controller.admin.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller("adminNoticeController")	//bean생성시 이미 noticeController라는 빈(클래스)가 있으므로 충돌남(500) adminNoticeController로 따로 지정해주기 
@RequestMapping("/admin/board/notice/")
public class NoticeController {

	@Autowired
	private ServletContext ctx;
	
	@RequestMapping("list")
	public String list() {
		
		
		return "admin.board.notice.list";
	}
	
	@GetMapping("reg")
	public String reg() {
	
		return "admin.board.notice.reg";
	}
		
	
	@PostMapping("reg")
	public String reg(String title, String content, String category, String[] foods, String food, MultipartFile[] files, HttpServletRequest request) throws IllegalStateException, IOException {
		
//		for (String likefood : foods) {
//			System.out.println(likefood);
//		}

		//ServletContext ctx = request.getServletContext();
		
		
		//files가 null이면 500에러발생 -> get요청일 경우 단순 매핑만, post인경우 파일업로드 
		for (MultipartFile file : files) {
			
			String fileName = file.getOriginalFilename();
			long fileSize = file.getSize();
			
			String webPath =  "/static/upload";
			String realPath = ctx.getRealPath(webPath);
			System.out.println("realPath : " + realPath);
			
			//파일을 업로드 하기 위한 경로가 없을경우 
			File savePath = new File(realPath);
			if(!savePath.exists()) 	//경로 존재 유무 확인 (존재하지 않을경우 경로 생성)
				savePath.mkdirs();	//경로 만들어주기
			
			realPath += File.separator +  fileName;	//File.separator : 각 운영체제 환경에 맞는 구분자를 만듦
			
			File saveFile = new File(realPath);	//new File(); -> 홈디렉토리 패스경로 넣기 
			
			file.transferTo(saveFile);	//파일 저장
			
		}
		
		return "admin.board.notice.reg";

//		return String.format("title : " + title + ", content : " + content + ", category : " + category + ", "
//				+ "favorite food : " + food);
	}
	
	@RequestMapping("edit")
	public String edit() {
		
		
		return "admin.board.notice.edit";
	}
	
	@RequestMapping("del")
	public String del() {
		
		
		return "admin.board.notice.del";
	}
}
