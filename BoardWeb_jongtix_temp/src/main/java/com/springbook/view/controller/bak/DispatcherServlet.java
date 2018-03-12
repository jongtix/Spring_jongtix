package com.springbook.view.controller.bak;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session ;
	//dispatcher서블릿 수정
	private HandleMapping handerMapping;
	private ViewResolver viewResolver;
	
	@Override
	public void init() throws ServletException {
		handerMapping = new HandleMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, 
			 HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	private void process(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		//1.클라언트 요청 uri 
		String uri = request.getRequestURI();//요청 uri
	    String path = uri.substring(uri.lastIndexOf("/"));//command 추출
	    System.out.println(path);
	    
	    //2. HandlerMapping에서 path 추출하여 해당 controller 검색
	    Controller ctrl = handerMapping.getController(path);
	    
	    //3. 검색된 controller 실행
	    String viewName = ctrl.handleRequest(request, response);
	    
	    //4. viewResolver에 의한 화면 이동.
	    String view = null;
	    if(!viewName.contains(".do")) {
	    	view = viewResolver.getView(viewName);
	    }else {
	    	view = viewName;
	    }
	    //5. 이동
	    response.sendRedirect(view);
	    
	    
	    /*//분기처리
	    if(path.equals("/login.do")) {
	    	System.out.println("로그인 처리");
	    	//1.사용자 정보
	    	String id = request.getParameter("id");
	    	String password = request.getParameter("password");
	    	
	    	//2.dB처리
	    	UserVO user = new UserVO();
	    	user.setId(id);
	    	user.setPassword(password);
	    	
	    	UserDAO dao = new UserDAO();
	    	UserVO user2 = dao.getUser(user);
	    	

	    	session = request.getSession();
	    	//3. 세션처리 및 화면 이동
	    	if(user2!=null){
	    		session.setAttribute("id", user2.getId());
	    		response.sendRedirect("getBoardList.do");
	    	}
	    	else
	    		response.sendRedirect("login.jsp");
	    	
	    }else if(path.equals("/logout.do")) {
	    	System.out.println("로그아웃 처리");
	    	//세션 종료 처리
	    	session.invalidate();
	    	// 로그인 화면으로 이동
	    	response.sendRedirect("login.jsp");
	    	
	    }else if(path.equals("/insertBoard.do")) {
	    	//3. 화면이동
	    	response.sendRedirect("insertBoard.jsp");	
	    }else if(path.equals("/insertBoardProc.do")) {
	    	System.out.println("글 등록 처리");
	    	//1. 파라미터 받기
	    	request.setCharacterEncoding("utf-8");
	    	String title = request.getParameter("title");
	    	String content = request.getParameter("content");
	    	String writer = request.getParameter("writer");
	    	Date date = new Date();
	    	java.sql.Date date1 = new java.sql.Date(date.getTime());
	    	
	    	//2.DB연동 처리
	    	BoardVO vo = new BoardVO();
	    	vo.setTitle(title);
	    	vo.setContent(content);
	    	vo.setWriter(writer);
	    	vo.setRegDate(date1);
	    	
	    	BoardDAO dao = new BoardDAO();
	    	dao.insertBoard(vo);
	    	
	    	//3. 화면이동
	    	response.sendRedirect("getBoardList.do");
	    	
	    }else if(path.equals("/updateBoard.do")) {
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
	    	response.sendRedirect("getBoardList.do");
	    	
	    }else if(path.equals("/deleteBoard.do")) {
	    	System.out.println("글 삭제 처리");
	    	String seq = request.getParameter("seq");
	    	BoardDAO dao = new BoardDAO();
	    	int result = dao.deleteBoard(Integer.parseInt(seq));
	    	if(result>0)
	    		response.sendRedirect("getBoardList.do");
	    	else {
	    		PrintWriter out = response.getWriter();
	    		out.print("<script>");
	    		out.print("alert('삭제오류');");
	    		out.print("history.back();");
	    		out.print("</script>");
	    	}	
	    }else if(path.equals("/getBoard.do")) {
	    	System.out.println("글 상세 처리");
	    	String seq = request.getParameter("seq");
	    	BoardVO vo = new BoardVO();
	    	vo.setSeq(Integer.parseInt(seq));//순번 입력
	    	BoardDAO dao = new BoardDAO();
	    	vo = dao.getBoard(vo.getSeq());//객체 저장
	    	
	    	session.setAttribute("board", vo);
	    	response.sendRedirect("getBoard.jsp");
	    	
	    }else if(path.equals("/getBoardList.do")) {
	    	System.out.println("글 목록 검색 처리");
	    	 String id = (String)session.getAttribute("id");
	         if(id==null|"".equals(id))
	        	 response.sendRedirect("login.jsp");
	         
	    	//1.Board 정보 출력
	    	BoardDAO dao = new BoardDAO();
	    	BoardVO vo = new BoardVO();
	    	List<BoardVO> list = dao.getBoardList(vo);
	    	session.setAttribute("boardList", list);
	    	response.sendRedirect("getBoardList.jsp");
	    }*/
	}

}
