package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController/* implements Controller*/{
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			HttpServletResponse response) {*/
	@RequestMapping("/logout.do")
	public ModelAndView logOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 String view ="";
		 ModelAndView mav = new ModelAndView();
	        if(id==null|"".equals(id))
	       	 	mav.setViewName("redirct:login.do");
	        else {   
	        	try {
	        		System.out.println("로그아웃 처리");
	    	    	//세션 종료 처리
	    	    	session.invalidate();
	    	    	// 로그인 화면으로 이동
	    	    	mav.setViewName("login.jsp");	
	        	}catch(Exception e) {System.out.println(e.getMessage());}
	        }  
    	return mav;
	}

}
