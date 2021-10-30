package com.newlecture.web.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("apiNoticeController")	//식별자 지정해 /customer/NoticeController와 구별 
@RequestMapping("/api/notice/")
public class NoticeController {
	//@Controller 문서기반 반환값을 가진 컨트롤러 생성
	//@RestController restful행태의 결과물 반환하는 클래스임을 명시 
	
	
	@RequestMapping("list")
	public String list() {
		
		return "한글이 깨질까?";	//@RestController : 문서를 반환하는것이 아닌 @ResponseBody와 같은 효과(문자열 출력)
	}
	
}

