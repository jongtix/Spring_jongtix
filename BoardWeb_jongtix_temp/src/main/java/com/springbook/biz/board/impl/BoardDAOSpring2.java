package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

/*
 * jdbcTemplate 객체를 얻는 두가지 방법 중 두번째
 * bean으로 등록된 jdbcTemplate를 얻는 방법(POJO객체)
 * */
@Repository("boardDaoSpring2")
public class BoardDAOSpring2 {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
	private final String BOARD_LIST = "select * from board order by seq asc";
	private final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
	private final String BOARD_GET = "select * from board where seq = ?";
	private final String BOARD_DELETE = "delete board where seq = ?";

	public void insertBoard(BoardVO vo) {
		System.out.println("=> Spring insertBoard() 기능 처리");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		System.out.println("=> Spring getBoardList() 기능 처리");
		list = jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		return list;
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("=> Spring updateBoard() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	public BoardVO getBoard(int seq) {
		BoardVO board = new BoardVO();
		System.out.println("=> Spring getBoard() 기능 처리");
		Object[] args = { seq };
		board = jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
		return board;
	}

	public int deleteBoard(BoardVO vo) {
		int result = 0;
		System.out.println("=> Spring deleteBoard() 기능 처리");
		result = jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
		return result;
	}

}