package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController{

	@RequestMapping("index")
	@ResponseBody	//return 으로 text출력 
	public String index() {	//(HttpServletResponse response) {	//프론트컨트롤러에서 HttpServletResponse 받아옴 
		//url이 매핑되는것은 IndexController라는 class가 아닌 index()라는 함수임 
//		PrintWriter out;
//		try {
//			out = response.getWriter();
//			out.print("hello hello hello~ ");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		return "hello hello hello~ ";	//@ResponseBody 어노테이션 사용시 jsp매핑이 아닌 body임을 알림 (문자열 출력)
		//return "root.index";	//tiles화면 출력
	}
	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		ModelAndView mv = new ModelAndView("root.index");
//		mv.addObject("data", "hello MVC");
////		mv.setViewName("/WEB-INF/view/index.jsp");	//WEB-INF앞에 / 붙이면 절대경로인 루트부터 탐색함  
//		return mv;
//	}
	

}
