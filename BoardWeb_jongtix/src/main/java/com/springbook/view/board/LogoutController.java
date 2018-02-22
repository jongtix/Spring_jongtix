package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class LogoutController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 String view ="";
		 ModelAndView mav = new ModelAndView();
	        if(id==null|"".equals(id))
	       	 	mav.setViewName("login.do");
	        else {   
	        	try {
	        		System.out.println("로그아웃 처리");
	    	    	//세션 종료 처리
	    	    	session.invalidate();
	    	    	// 로그인 화면으로 이동
	    	    	mav.setViewName("login");	
	        	}catch(Exception e) {System.out.println(e.getMessage());}
	        }  
    	return mav;
	}

}
