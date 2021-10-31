package com.newlecture.web.controller.api;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@RestController("apiNoticeController")	//식별자 지정해 /customer/NoticeController와 구별 
@RequestMapping("/api/notice/")
public class NoticeController {
	//@Controller 문서기반 반환값을 가진 컨트롤러 생성
	//@RestController restful행태의 결과물 반환하는 클래스임을 명시 
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("list")
	public Notice list() throws ClassNotFoundException, SQLException {
		
		List<Notice> list = noticeService.getList(1, "title", "");
		
		return list.get(0);	//@RestController : 문서를 반환하는것이 아닌 @ResponseBody와 같은 효과(문자열 출력)
	}
	
}

