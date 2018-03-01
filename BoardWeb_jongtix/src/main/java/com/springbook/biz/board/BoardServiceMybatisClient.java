package com.springbook.biz.board;

import java.util.List;

import com.springbook.biz.board.impl.BoardDAOMybatis;

public class BoardServiceMybatisClient {

	public static void main(String[] args) {
		BoardDAOMybatis boardDAO = new BoardDAOMybatis();

		// 글 등록 테스트
		BoardVO vo = new BoardVO();
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용");
		vo.setFiles("C:/upLoads/" + "Desert.jpg");
		boardDAO.insertBoard(vo);

		// 글 목록 기능 테스트
		vo.setSearchCondition("CONTENT");
		vo.setSearchKeyword("테스트");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for (BoardVO b : boardList) {
			System.out.println("-> " + b.toString());
		}

		// 글 수정 테스트
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getSeq() == 8) {
				vo = boardList.get(i);
			}
		}
		vo.setTitle("수정된 임시 제목");
		vo.setContent("수정된 임시 내용");
		System.out.println(vo.toString());
		System.out.println("------ 수정 결과 ------");
		for (BoardVO b : boardList) {
			System.out.println("-> " + b.toString());
		}

		// 상세보기
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getSeq() == 8) {
				vo = boardList.get(i);
			}
		}
		System.out.println("상세정보");
		System.out.println(vo);

		// 글 삭제
		int seq = -1;
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getSeq() == 9) {
				seq = boardList.get(i).getSeq();
			}
		}

		// 삭제 후 리스트
		for (BoardVO b : boardList) {
			System.out.println("-> " + b.toString());
		}
	}

}
