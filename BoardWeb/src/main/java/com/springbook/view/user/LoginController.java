package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController /*implements Controller*/{
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {*/
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(HttpServletRequest request) {
		System.out.println("로그인 처리");
    	//1.사용자 정보
    	String id = request.getParameter("id");
    	String password = request.getParameter("password");
    	
    	if(id==null||"".equals(id)) {
    		throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
    	}
    	
    	//2.dB처리
    	UserVO user = new UserVO();
    	user.setId(id);
    	user.setPassword(password);
    	
    	UserDAO dao = new UserDAO();
    	UserVO user2 = dao.getUser(user);
    	

    	HttpSession session = request.getSession();
    	ModelAndView mav = new ModelAndView();
    	String view="";
    	//3. 세션처리 및 화면 이동
    	if(user2!=null){
    		session.setAttribute("id", user2.getId());
    		session.setAttribute("userName", user2.getName());
    		//return "getBoardList.do";
    		view = "redirect:getBoardList.do";
    	}
    	else
    		 view = "login.jsp";
    		//mav.setViewName("login.jsp");
    		//return "login";
    	return view;
	}
	
	//모델객체(UserVO)를 다른 이름으로 저장하기위한 어노테이션@ModelAttribute
	//@ModelAttribute는 RequestMapping보다 먼저 실행됨.
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test123");
		ModelAndView mav = new ModelAndView();
		String view = "";
		view = "login.jsp";
		return view;
	}
}
