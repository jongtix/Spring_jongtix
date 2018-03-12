package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/*import org.springframework.web.servlet.mvc.Controller;*/

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController /* implements Controller */ {

	/*
	 * @Override public ModelAndView handleRequest(HttpServletRequest request,
	 * HttpServletResponse response) {
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request) {
		System.out.println("로그인 처리");
		// 1.사용자 정보
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2.dB처리
		UserVO user = new UserVO();
		user.setId(id);
		user.setPassword(password);

		UserDAO dao = new UserDAO();
		UserVO user2 = dao.getUser(user);

		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();

		// 3. 세션처리 및 화면 이동
		String view = "";
		if (user2 != null) {
			session.setAttribute("id", user2.getId());
			session.setAttribute("userName", user2.getName());
			// return "getBoardList.do";
			view = "redirect:getBoardList.do";
		} else
			view = "login.jsp";
		// return "login";
		return view;
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("로그인 화면으로 이동");

		vo.setId("test");
		vo.setPassword("test1234");

		String view = "";

		view = "login";

		return view;
	}

}
