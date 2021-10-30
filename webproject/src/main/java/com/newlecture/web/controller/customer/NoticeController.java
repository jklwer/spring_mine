package com.newlecture.web.controller.customer;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@Controller	//일단 클래스자체가 객체화 되어야 매핑을 시킬 수 있으므로 클래스를 꼬옥 객체화 시켜야함 !!! 
@RequestMapping("/customer/notice/")	//공통 url
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping("list")
	public String list() throws ClassNotFoundException, SQLException {
		
		List<Notice> list = noticeService.getList(1, "TITLE", "");	//db에서 notice받아옴
		
		return "notice.list";
	}
	
	@RequestMapping("detail")
	public String detail() {
		return "notice.detail";
	}
	
}
