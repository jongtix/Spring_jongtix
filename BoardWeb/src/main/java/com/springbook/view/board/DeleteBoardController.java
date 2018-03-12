package com.springbook.view.board;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class DeleteBoardController/* implements Controller*/{
/*	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			HttpServletResponse response) {*/
	   @RequestMapping(value="/deleteBoard.do")//getMethod가 기본
	   public ModelAndView deleteBoard(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 String view ="";
		 ModelAndView mav = new ModelAndView();
	        if(id==null|"".equals(id))
	       	 	mav.setViewName("redirect:login.do");
	        else {   
	        	try {
	        		System.out.println("글 삭제 처리");
	    	    	String seq = request.getParameter("seq");
	    	    	BoardDAO dao = new BoardDAO();
	    	    	int result = dao.deleteBoard(Integer.parseInt(seq));
	    	    	if(result>0)
	    	    		mav.setViewName("redirect:getBoardList.do");
	    	    	else {
	    	    		PrintWriter out = response.getWriter();
	    	    		out.print("<script>");
	    	    		out.print("alert('삭제오류');");
	    	    		out.print("history.back();");
	    	    		out.print("</script>");
	    	    	}	
		    		
	        	}catch(Exception e) {System.out.println(e.getMessage());}
	        }  
    	return mav;
	}

}
