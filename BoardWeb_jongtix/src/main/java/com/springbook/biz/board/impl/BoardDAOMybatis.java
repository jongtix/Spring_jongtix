package com.springbook.biz.board.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis extends SqlSessionDaoSupport {

	@Autowired
	private SqlSessionTemplate mybatis;

	/*
	 * public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
	 * super.setSqlSessionFactory(sqlSessionFactory); }
	 */

	/*
	 * private SqlSession mybatis;
	 * 
	 * public BoardDAOMybatis() { mybatis = SqlSessionFactoryBean.geti }
	 */

	// CRUD 기능 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("=> Spring insertBoard() 기능 처리");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	// 글 목록
	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		if (vo.getSearchCondition().equals("TITLE")) {
			list = mybatis.selectList("BoardDAO.getBoardList_T", vo);
		} else if (vo.getSearchCondition().equals("CONTENT")) {
			list = mybatis.selectList("BoardDAO.getBoardList_C", vo);
		} else {
			list = mybatis.selectList("BoardDAO.getBoardList_A", vo);
		}
		return list;
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("=> Spring updateBoard() 기능 처리");
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	// 상세정보
	public BoardVO getBoard(int seq) {
		System.out.println("=> Spring JDBC로 getBoard() 기능 처리");
		System.out.println(mybatis.update("BoardDAO.updateCount", seq));
		return mybatis.selectOne("BoardDAO.selectOne", seq);
	}

	// 글 삭제
	public int deleteBoard(int seq) {
		System.out.println("=> Spring deleteBoard() 기능 처리");
		return mybatis.delete("BoardDAO.deleteBoard", seq);
	}
}
