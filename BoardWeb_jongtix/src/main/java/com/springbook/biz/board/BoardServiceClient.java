package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		/*
		 * AbstractApplicationContext container = new
		 * GenericXmlApplicationContext("annotationContext.xml");
		 */
		AbstractApplicationContext container = new GenericXmlApplicationContext("aopContext.xml");

		BoardService boardService = (BoardService) container.getBean("boardService");

		BoardVO vo = new BoardVO();
		/*
		 * vo.setTitle("임시 제목"); vo.setWriter("홍길동"); vo.setContent("임시 내용1234567890");
		 * boardService.insertBoard(vo);
		 */

		System.out.println("----- 리스트 불러오기 -----");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO b : boardList) {
			System.out.println("->" + b.toString());
		}

		vo = boardList.get(1);
		vo.setTitle("임시 제목 수정");
		vo.setContent("임시 내용 수정");
		boardService.updateBoard(vo);

		System.out.println("----- 수정 후 리스트 불러오기 -----");
		boardList = boardService.getBoardList(vo);
		for (BoardVO b : boardList) {
			System.out.println("->" + b.toString());
		}

		int seq = vo.getSeq();
		vo = boardService.getBoard(seq);

		System.out.println(vo.toString());

		boardService.deleteBoard(vo);

		System.out.println("----- 삭제 후 리스트 불러오기 -----");
		boardList = boardService.getBoardList(vo);
		for (BoardVO b : boardList) {
			System.out.println("->" + b.toString());
		}

		container.close();
	}

}
