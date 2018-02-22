package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class InsertBoardController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 ModelAndView mav = new ModelAndView();
	        if(id==null|"".equals(id))
	       	 	mav.setViewName("login.do");
	        else    
	        	mav.setViewName("insertBoard");	
	        
    	return mav;
	}

}
