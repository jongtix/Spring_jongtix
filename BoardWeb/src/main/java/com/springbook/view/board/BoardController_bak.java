package com.springbook.view.board;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
//Controller클래스의 메소드들을 하나로 통합 후
//Component 어노테이션을 주석처리하여 원래의 POJO 클래스로 변환처리함.
//@Controller
public class BoardController_bak {
	//글등록
	@RequestMapping("/insertBoard.do")
	 public ModelAndView insertBoard(HttpServletRequest request) {
	  System.out.println("글 등록 처리");
	 
	HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 String writer = request.getParameter("title");
		 String content = request.getParameter("content");
		 ModelAndView mav = new ModelAndView();
	        if(id==null|"".equals(id))
	       	 	mav.setViewName("redirect:login.do");
	        else    
	        	mav.setViewName("insertBoard.jsp");	
	       return mav;
	}
	//글 수정
	@RequestMapping("/updateBoard.do")
	public ModelAndView updateBoard(HttpServletRequest request) {
		HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 String view ="";
		 ModelAndView mav = new ModelAndView();
	        if(id==null|"".equals(id))
	       	 	mav.setViewName("redirect:login.do");
	        else {   
	        	try {
	        		System.out.println("글 수정 처리");
		    	//1. 파라미터 받기
		    	request.setCharacterEncoding("utf-8");
		    	String title = request.getParameter("title");
		    	String content = request.getParameter("content");
		    	String seq = request.getParameter("seq");
		    	
		    	//2. DB연동처리
		    	BoardVO vo = new BoardVO();
		    	vo.setTitle(title);
		    	vo.setContent(content);
		    	vo.setSeq(Integer.parseInt(seq));
		    	
		    	BoardDAO dao = new BoardDAO();
		    	dao.updateBoard(vo);
		    	//3. 화면 이동
		    	mav.setViewName("redirect:getBoardList.do");
		    		
	        	}catch(Exception e) {System.out.println(e.getMessage());}
	        }  
    	return mav;
	}
	
	//글 삭제
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
	
	//글 상세 조회
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(HttpServletRequest request) {	
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		if (id == null | "".equals(id))
			mav.setViewName("redirect:login.do");
		else {
			System.out.println("글 상세 처리");
			BoardVO vo = new BoardVO();
			
			String seq = request.getParameter("seq");
			vo.setSeq(Integer.parseInt(seq));// 순번 입력
			BoardDAO dao = new BoardDAO();
			vo = dao.getBoard(vo.getSeq());// 객체 저장
			session.setAttribute("board", vo);

			mav.setViewName("getBoard.jsp");
		}
		return mav;
	}
	
	//글 목록 검색
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(HttpServletRequest request) {
		System.out.println("글 목록 검색 처리");
		HttpSession session = request.getSession();
   	  String id = (String)session.getAttribute("id");
   	   String view ="";
    	ModelAndView mav = new ModelAndView();
        if(id==null|"".equals(id))
       	 mav.setViewName("redirect:login.do");
        else {    
   	//1.Board 정보 출력
   	BoardDAO dao = new BoardDAO();
   	BoardVO vo = new BoardVO();
   	List<BoardVO> list = dao.getBoardList(vo);
  
   	mav.addObject("boardList", list);
   	mav.setViewName("getBoardList.jsp");
   	System.out.println("viewName:"+"getBoardList");

        }
    	return mav;
	}
}
