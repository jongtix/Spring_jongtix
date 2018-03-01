package com.springbook.view.board;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardListVO;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

/*
 * Controller 클래스의 메소드들을 하나로 통합한 후
 * Component 어노테이션을 주석처리하여 원래의 POJO 클래스로 변환처리함
 * */
@Controller
@SessionAttributes("board") // board라는 이름으로 객체를 session에 저장하는 Annotation
public class BoardController {

	@Autowired
	BoardService boardService;

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

	// JSON타입 데이터 변환
	@RequestMapping("/dataTransferJSON.do")
	@ResponseBody
	public List<BoardVO> dataTransferJSON(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> list = boardService.getBoardList(vo);
		return list;
	}

	// JSON타입 데이터 변환
	@RequestMapping("/dataTransferXml.do")
	@ResponseBody
	public BoardListVO dataTransferXml(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> list = boardService.getBoardList(vo);
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(list);
		return boardListVO;
	}

	// 글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(HttpServletRequest request) {
		System.out.println("글 등록 폼");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String writer = request.getParameter("title");
		String content = request.getParameter("content");

		String view = "";
		if (id == null || "".equals(id)) {
			view = "redirect:login.do";
		} else {
			view = "insertBoard.jsp";
		}
		return view;
	}

	// 글 등록 처리
	@RequestMapping("/insertBoardProc.do")
	public String insertBoardProc(HttpServletRequest request, BoardVO vo) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String view = "";
		if (id == null || "".equals("id")) {
			view = "login.do";
		} else {
			try {
				System.out.println("글 등록 처리");

				// 1. 파일 업로드 처리
				MultipartFile uploadFile = vo.getUploadFile();
				String path = "C:/upLoads/";
				if (!uploadFile.isEmpty()) {
					String fileName = uploadFile.getOriginalFilename();
					uploadFile.transferTo(new File(path + fileName));
					vo.setFiles(path + fileName);
				}

				// 2. DB연동 처리
				boardService.insertBoard(vo);
				view = "redirect:getBoardList.do";
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return view;
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(HttpServletRequest request, @ModelAttribute("board") BoardVO vo) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String view = "";
		if (id == null || "".equals(id)) {
			view = "redirect:login.do";
		} else {
			try {
				System.out.println("글 수정 처리");

				// 1. 파일 업로드 처리
				MultipartFile uploadFile = vo.getUploadFile();
				String path = "C:/upLoads/";
				if (!uploadFile.isEmpty()) {
					String fileName = uploadFile.getOriginalFilename();
					uploadFile.transferTo(new File(path + fileName));
					vo.setFiles(path + fileName);
				} else {
					vo.setFiles("");
				}

				// 2. DB연동 처리
				boardService.updateBoard(vo);

				// 3. 화면이동
				view = "redirect:getBoardList.do";
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return view;
	}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String view = "";
		if (id == null | "".equals(id))
			view = "redirect:login.do";
		else {
			try {
				System.out.println("글 삭제 처리");
				String seq = request.getParameter("seq");

				int result = boardService.deleteBoard(Integer.parseInt(seq));
				if (result > 0) {
					view = "redirect:getBoardList.do";
				} else {
					view = "redirect:getBoardList.do";
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return view;
	}

	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(HttpServletRequest request, BoardVO vo, Model model) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String view = "";
		if (id == null | "".equals(id)) {
			view = "redirect:login.do";
		} else {
			System.out.println("글 상세 처리");
			vo = boardService.getBoard(vo.getSeq());
			model.addAttribute("board", vo);

			view = "getBoard.jsp";
		}
		return view;
	}

	// 글 목록 검색
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(HttpServletRequest request, Model model, BoardVO vo) {
		System.out.println("글 목록 검색 처리");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String view = "";
		if (id == null | "".equals(id)) {
			view = "redirect:login.do";
		} else {
			// 1.Board 정보 출력
			BoardDAO dao = new BoardDAO();

			// @RequestParam으로 넘어온 값이 없으면 처리
			if (vo.getSearchCondition() == null)
				vo.setSearchCondition("TITLE");
			if (vo.getSearchKeyword() == null)
				vo.setSearchKeyword("");
			List<BoardVO> list = boardService.getBoardList(vo); // businessLayer쪽의 메소드 사용

			model.addAttribute("boardList", list);
			view = "getBoardList.jsp";
		}
		return view;
	}
}
