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

// @Controller
public class BoardController_backup {

	@RequestMapping(value = "/deleteBoard.do")
	public ModelAndView deleteBoard(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String view = "";
		ModelAndView mav = new ModelAndView();
		if (id == null | "".equals(id))
			mav.setViewName("login.do");
		else {
			try {
				System.out.println("글 삭제 처리");
				String seq = request.getParameter("seq");
				BoardDAO dao = new BoardDAO();
				int result = dao.deleteBoard(Integer.parseInt(seq));
				if (result > 0)
					mav.setViewName("redirect:getBoardList.do");
				else {
					PrintWriter out = response.getWriter();
					out.print("<script>");
					out.print("alert('삭제오류');");
					out.print("history.back();");
					out.print("</script>");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return mav;
	}

	@RequestMapping(value = "/getBoard.do")
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

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(HttpServletRequest request) {
		System.out.println("글 목록 검색 처리1");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		ModelAndView mav = new ModelAndView();
		if (id == null | "".equals(id))
			mav.setViewName("login");
		else {
			// 1.Board 정보 출력
			BoardDAO dao = new BoardDAO();
			BoardVO vo = new BoardVO();
			List<BoardVO> list = dao.getBoardList(vo);

			mav.addObject("boardList", list);
			mav.setViewName("getBoardList");
		}
		return mav;
	}

	@RequestMapping("/insertBoard.do")
	public ModelAndView insertBoard(HttpServletRequest request) {
		System.out.println("글 등록 처리");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		ModelAndView mav = new ModelAndView();
		if (id == null | "".equals(id)) {
			mav.setViewName("login.do");
		} else {
			mav.setViewName("insertBoard");
		}
		return mav;
	}

	@RequestMapping(value = "/insertBoardProc.do")
	public ModelAndView insertBoardProc(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		ModelAndView mav = new ModelAndView();
		String view = "";
		if (id == null | "".equals(id))
			mav.setViewName("login.do");
		else {
			try {
				System.out.println("글 등록 처리");
				// 1. 파라미터 받기
				request.setCharacterEncoding("utf-8");
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				String writer = request.getParameter("writer");

				// 2.DB연동 처리
				BoardVO vo = new BoardVO();
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);

				BoardDAO dao = new BoardDAO();
				dao.insertBoard(vo);

				// 3. 화면이동
				mav.setViewName("redirect:getBoardList.do");

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return mav;
	}

	@RequestMapping("/updateBoard.do")
	public ModelAndView updateBoard(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String view = "";
		ModelAndView mav = new ModelAndView();
		if (id == null | "".equals(id))
			mav.setViewName("login.do");
		else {
			try {
				System.out.println("글 수정 처리");
				// 1. 파라미터 받기
				request.setCharacterEncoding("utf-8");
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				String seq = request.getParameter("seq");

				// 2. DB연동처리
				BoardVO vo = new BoardVO();
				vo.setTitle(title);
				vo.setContent(content);
				vo.setSeq(Integer.parseInt(seq));

				BoardDAO dao = new BoardDAO();
				dao.updateBoard(vo);

				// 3. 화면 이동
				mav.setViewName("redirect:getBoardList.do");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return mav;
	}
}
