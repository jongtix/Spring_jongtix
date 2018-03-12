package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.util.SqlSessionFactoryBean;

@Repository("boardDao")
public class BoardDAOMybatis {
	private SqlSession mybatis;

	public BoardDAOMybatis() {
		mybatis = SqlSessionFactoryBean.getInstance();
	}

	// CRUD 기능 메소드 구현
	// 글등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring insertBoard() 기능 처리");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	// 글 목록 리스트
	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> list = new ArrayList<>();
		if (vo.getSearchCondition().equals("TITLE"))
			list = mybatis.selectList("BoardDAO.getBoardList_T", vo);
		else if (vo.getSearchCondition().equals("CONTENT"))
			list = mybatis.selectList("BoardDAO.getBoardList_C", vo);
		else
			list = mybatis.selectList("BoardDAO.getBoardList_A", vo);
		return list;
	}
	// BOARD수정
	/*
	 * public void updateBoard(BoardVO vo) {
	 * System.out.println("===> Spring updateBoard() 기능 처리");
	 * mybatis.update(BOARD_UPDATE,vo.getTitle(),vo.getContent(),vo.getFiles(),vo.
	 * getSeq()); } //상세정보 public BoardVO getBoard(int seq) { BoardVO board = new
	 * BoardVO(); System.out.println("===> Spring JDBC로 getBoard() 기능 처리"); Object[]
	 * args = {seq}; board = mybatis.queryForObject(BOARD_GET, args,new
	 * BoradRowMapper()); return board; } //삭제 메소드 public int deleteBoard(int seq) {
	 * int result =0; System.out.println("===> Spring deleteBoard() 기능 처리"); result
	 * = mybatis.update(BOARD_DELETE, seq); return result; }
	 */

}
