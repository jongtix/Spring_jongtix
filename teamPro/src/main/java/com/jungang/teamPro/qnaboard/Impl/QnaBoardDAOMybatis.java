package com.jungang.teamPro.qnaboard.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jungang.teamPro.qnaboard.QnaBoard;

@Repository
public class QnaBoardDAOMybatis extends SqlSessionDaoSupport {

	@Autowired
	private SqlSessionTemplate mybatis;

	// 글 등록
	public int insertQnaBoard(QnaBoard board) {
		return mybatis.insert("QnaBoardDAO.insertQnaBoard", board);
	}

	// Q&A 게시판 글 수
	public int getQnaBoardTotal() {
		return mybatis.selectOne("QnaBoardDAO.getQnaBoardTotal");
	}

	// FAQ 게시판 글 수
	public int getFaqBoardTotal() {
		return mybatis.selectOne("QnaBoardDAO.getFaqBoardTotal");
	}

	// Q&A 게시판 글 목록
	public List<QnaBoard> selectQnaBoardList(@Param("startRow") int startRow, @Param("endRow") int endRow) {
		Map<String, Integer> rows = new HashMap<String, Integer>();
		rows.put("startRow", startRow);
		rows.put("endRow", endRow);
		return mybatis.selectList("QnaBoardDAO.selectQnaBoardList", rows);
	}

	// FAQ 게시판 글 목록
	public List<QnaBoard> selectFaqBoardList(int startRow, int endRow) {
		Map<String, Integer> rows = new HashMap<String, Integer>();
		rows.put("startRow", startRow);
		rows.put("endRow", endRow);
		return mybatis.selectList("QnaBoardDAO.selectFaqBoardList", rows);
	}

	// 조회수 증가
	public void updateReadCount(int num) {
		mybatis.update("QnaBoardDAO.updateReadCount", num);
	}

	// Q&A 게시글 얻기
	public QnaBoard getQnaBoard(int num) {
		return mybatis.selectOne("QnaBoardDAO.getQnaBoard", num);
	}

	// Q&A 게시글 수정
	public int updateQnaBoard(QnaBoard board) {
		return mybatis.update("QnaBoardDAO.updateQnaBoard", board);
	}

	// FAQ 게시판으로 글 옮기기
	public int moveFaq(int num) {
		return mybatis.update("QnaBoardDAO.moveFaq", num);
	}

	// Q&A 글 삭제
	public int deleteQnaBoard(int num) {
		return mybatis.delete("QnaBoardDAO.deleteQnaBoard", num);
	}

	// 댓글 존재 확인
	public boolean isReply(int num) {
		boolean isTrue = false;
		return isTrue;
	}

}
