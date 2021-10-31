package com.newlecture.web.controller.customer;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@Controller	//일단 클래스자체가 객체화 되어야 매핑을 시킬 수 있으므로 클래스를 꼬옥 객체화 시켜야함 !!! 
@RequestMapping("/customer/notice/")	//공통 url
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping("list")		//@RequestParam("p") : 쿼리스트링의 p 값을 page로 받기 , defaultValue = "1" -> ...notice/list여도 page값은 1
	public String list(@RequestParam(defaultValue = "1", name = "p") int page) throws ClassNotFoundException, SQLException {
		
		//String p = request.getParameter("p");
		System.out.println("page : " + page);
		
		List<Notice> list = noticeService.getList(1, "TITLE", "");	//db에서 notice받아옴
		
		return "notice.list";
	}
	
	@RequestMapping("detail")
	public String detail() {
		return "notice.detail";
	}
	
}
