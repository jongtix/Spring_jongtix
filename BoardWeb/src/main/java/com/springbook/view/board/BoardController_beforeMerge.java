package com.springbook.view.board;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
//Controller클래스의 메소드들을 하나로 통합 후
//Component 어노테이션을 주석처리하여 원래의 POJO 클래스로 변환처리함.
///@Controller
//@SessionAttributes("board")//board라는 이름으로 객체를 session에 저장하는 Annotation
public class BoardController_beforeMerge {
	//검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String,String> conditionMap = new HashMap<>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		conditionMap.put("전체", "ALL");
		return conditionMap;
	}
	//글등록
	@RequestMapping("/insertBoard.do")
	 public String insertBoard(HttpServletRequest request) {
	  System.out.println("글 등록 처리");
	 
	HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 String writer = request.getParameter("title");
		 String content = request.getParameter("content");
		 //ModelAndView mav = new ModelAndView();
		 String view = "";
	        if(id==null|"".equals(id))
	       	 	view = "redirect:login.do";
	        else    
	        	view = "insertBoard.jsp";	
	       return view;
	}
	//글 등록 처리
	@RequestMapping(value="/insertBoardProc.do")
	public String insertBoardProc( HttpServletRequest request,
									BoardVO vo,
									BoardDAO dao) {
		HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 String view ="";
	        if(id==null|"".equals(id))
	       	  view = "login.do";
	        else {   
	        	try {
	        	System.out.println("글 등록 처리");
		    	//2.DB연동 처리
		    	dao.insertBoard(vo);
		    	view = "redirect:getBoardList.do";
	        	}catch(Exception e) {System.out.println(e.getMessage());}

	        }
        	return view;
	}
	//글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(HttpServletRequest request,
			                  @ModelAttribute("board") BoardVO vo,
			                  BoardDAO dao) {
		HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 String view ="";
	        if(id==null|"".equals(id))
	       	 	view = "redirect:login.do";
	        else {   
	        	try {
	        		System.out.println("글 수정 처리");
		    	//2. DB연동처리
		    	dao.updateBoard(vo);
		    	//3. 화면 이동
		    	view = "redirect:getBoardList.do";
	        	}catch(Exception e) {System.out.println(e.getMessage());}
	        }  
    	return view;
	}
	
	//글 삭제
	@RequestMapping(value="/deleteBoard.do")//getMethod가 기본
	   public String deleteBoard(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 String view ="";
		 ModelAndView mav = new ModelAndView();
	        if(id==null|"".equals(id))
	       	 	view = "redirect:login.do";
	        else {   
	        	try {
	        		System.out.println("글 삭제 처리");
	    	    	String seq = request.getParameter("seq");
	    	    	BoardDAO dao = new BoardDAO();
	    	    	int result = dao.deleteBoard(Integer.parseInt(seq));
	    	    	if(result>0)
	    	    		view = "redirect:getBoardList.do";
	    	    	else {
	    	    		PrintWriter out = response.getWriter();
	    	    		out.print("<script>");
	    	    		out.print("alert('삭제오류');");
	    	    		out.print("history.back();");
	    	    		out.print("</script>");
	    	    	}	
		    		
	        	}catch(Exception e) {System.out.println(e.getMessage());}
	        }  
 	return view;
	}
	
	//글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(HttpServletRequest request,
							BoardVO vo,
							BoardDAO dao,
							Model model
							) {	
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String view="";
		if (id == null | "".equals(id))
			view = "redirect:login.do";
		else {
			System.out.println("글 상세 처리");
			vo = dao.getBoard(vo.getSeq());// 객체 저장
			model.addAttribute("board", vo);

			view = "getBoard.jsp";
		}
		return view;
	}
	
	//글 목록 검색
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(HttpServletRequest request,Model model,
			                   //request.getParameter("searchCondition")와 비슷한 기능
								/*@RequestParam(value="searchCondition",defaultValue="TITLE",required=false) String condition,
								@RequestParam(value="searchKeyword",defaultValue="",required=false) String keyword*/
			                    BoardVO vo ) {
		System.out.println("글 목록 검색 처리");
		HttpSession session = request.getSession();
   	  String id = (String)session.getAttribute("id");
   	   String view ="";
    	ModelAndView mav = new ModelAndView();
        if(id==null|"".equals(id))
       	 view = "redirect:login.do";
        else {    
   	//1.Board 정보 출력
   	   BoardDAO dao = new BoardDAO();
   	   //@RequestParam으로 넘온값이 없으며 처리...
	       if(vo.getSearchCondition()==null) 
	    	   vo.setSearchCondition("TITLE");
	       if(vo.getSearchKeyword()==null)
	    	   vo.setSearchKeyword("");
  /* 	BoardVO vo = new BoardVO();*/
   /*	List<BoardVO> list = dao.getBoardList(vo);*/
   		List<BoardVO> list = dao.getBoardList(vo.getSearchCondition(),vo.getSearchKeyword());
  
   	model.addAttribute("boardList", list);
   	view = "getBoardList.jsp";
   	System.out.println("viewName:"+"getBoardList");

        }
    	return view;
	}
}
