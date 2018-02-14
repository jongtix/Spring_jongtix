package com.springbook.biz.board;

import java.util.List;

public interface BoardService {

	// 글등록
	void insertBoard(BoardVO vo);

	// 글수정
	void updateBoard(BoardVO vo);

	// 글삭제
	void deleteBoard(BoardVO vo);

	// 글조회
	BoardVO getBoard(int seq);

	// 글목록
	List<BoardVO> getBoardList(BoardVO vo);

}
