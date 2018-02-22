package com.springbook.view.board;

import java.io.PrintWriter;
import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목 + 내용", "ALL");
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		conditionMap.put("작성자", "WRITER");
		return conditionMap;
	}

	@RequestMapping("/getBoardList.do")
	public String getBoardList(HttpServletRequest request, Model model,
			@RequestParam(value = "searchCondition", required = false) String condition,
			@RequestParam(value = "searchKeyword", required = false) String keyword) {
		System.out.println("글 목록 검색 처리1");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String view = "";
		if (id == null | "".equals(id)) {
			view = "login";
		} else {
			// 1.Board 정보 출력
			BoardDAO dao = new BoardDAO();
			BoardVO vo = new BoardVO();
			List<BoardVO> list = new ArrayList<BoardVO>();
			if ((condition != null && !condition.equals("")) && (keyword != null && !keyword.equals(""))) {
				if (condition.equals("TITLE")) {
					list = dao.getBoardListTitle(condition, keyword);
				} else if (condition.equals("CONTENT")) {
					list = dao.getBoardListContent(condition, keyword);
				} else if (condition.equals("WRITER")) {
					list = dao.getBoardListWriter(condition, keyword);
				} else if (condition.equals("ALL")) {
					list = dao.getBoardListAll(condition, keyword);
				}
				model.addAttribute("condition", condition);
				model.addAttribute("keyword", keyword);
			} else {
				list = dao.getBoardList(vo);
			}

			model.addAttribute("boardList", list);
			view = "getBoardList";
		}
		return view;
	}

	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String view = "";
		if (id == null | "".equals(id)) {
			view = "login.do";
		} else {
			try {
				System.out.println("글 삭제 처리");
				String seq = request.getParameter("seq");
				BoardDAO dao = new BoardDAO();
				int result = dao.deleteBoard(Integer.parseInt(seq));
				if (result > 0)
					view = "redirect:getBoardList.do";
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
		return view;
	}

	@RequestMapping(value = "/getBoard.do")
	public String getBoard(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("글 상세 처리");
		String seq = request.getParameter("seq");
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));// 순번 입력
		BoardDAO dao = new BoardDAO();
		vo = dao.getBoard(vo.getSeq());// 객체 저장

		session.setAttribute("board", vo);
		String view = "";
		view = "getBoard";
		return view;
	}

	@RequestMapping("/insertBoard.do")
	public String insertBoard(HttpServletRequest request) {
		System.out.println("글 등록 처리");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String view = "";
		if (id == null | "".equals(id)) {
			view = "login.do";
		} else {
			view = "insertBoard";
		}
		return view;
	}

	@RequestMapping(value = "/insertBoardProc.do")
	public String insertBoardProc(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String view = "";
		if (id == null | "".equals(id)) {
			view = "login.do";
		} else {
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
				view = "redirect:getBoardList.do";

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return view;
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String view = "";
		if (id == null | "".equals(id)) {
			view = "login.do";
		} else {
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
				view = "redirect:getBoardList.do";
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return view;
	}
}
