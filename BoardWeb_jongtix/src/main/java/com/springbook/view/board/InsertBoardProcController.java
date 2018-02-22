package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class InsertBoardProcController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 ModelAndView mav = new ModelAndView();
		 String view ="";
	        if(id==null|"".equals(id))
	       	 	mav.setViewName("login.do");
	        else {   
	        	try {
	        	System.out.println("글 등록 처리");
		    	//1. 파라미터 받기
		    	request.setCharacterEncoding("utf-8");
		    	String title = request.getParameter("title");
		    	String content = request.getParameter("content");
		    	String writer = request.getParameter("writer");
		    	
		    	//2.DB연동 처리
		    	BoardVO vo = new BoardVO();
		    	vo.setTitle(title);
		    	vo.setContent(content);
		    	vo.setWriter(writer);
		    	
		    	BoardDAO dao = new BoardDAO();
		    	dao.insertBoard(vo);
		    	
		    	//3. 화면이동
		    	
	        	mav.setViewName("getBoardList.do");	
	        	}catch(Exception e) {System.out.println(e.getMessage());}
	        }  
    	return mav;
	}

}
