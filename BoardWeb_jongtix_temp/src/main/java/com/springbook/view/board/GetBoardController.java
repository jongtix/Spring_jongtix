package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController {

	/*
	 * @Override public ModelAndView handleRequest(HttpServletRequest request,
	 * HttpServletResponse response) {
	 */
	/* @RequestMapping(value = "/getBoard.do") */
	public ModelAndView getBoard(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("글 상세 처리");
		String seq = request.getParameter("seq");
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));// 순번 입력
		BoardDAO dao = new BoardDAO();
		vo = dao.getBoard(vo.getSeq());// 객체 저장

		session.setAttribute("board", vo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoard");
		return mav;
	}

}
