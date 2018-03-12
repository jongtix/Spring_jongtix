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

//jdbcTemplate 객체를 얻는 두가지 방법중 두번째
//bean으로 등록된 jdbcTemplate를 얻는 방법(POJO객체)
@Repository("boardDao")
public class BoardDAOSpringOracle/* extends JdbcDaoSupport*/{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//JDBC관련 변수
	private Connection conn=null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	//sql문
	private final String BOARD_INSERT 
	        ="insert into board3(seq,title,writer,content,files)"
			+ " values((select nvl(max(seq),0)+1 from board3),?,?,?,?)";
	private final String BOARD_LIST 
	        ="select * from board3 order by seq desc";
	private final String BOARD_UPDATE
	        ="update board3 set title=?,content=?,files=? where seq=?";
	private final String BOARD_GET
	        = "select * from board3 where seq=?";
	private final String BOARD_DELETE
	        = "delete from board3 where seq=?";
	
	//CRUD 기능 메소드 구현
	//글등록
	public void insertBoard(BoardVO vo) {
		 System.out.println("===> Spring insertBoard() 기능 처리");
		 jdbcTemplate.update(BOARD_INSERT,vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getFiles());
	}
	//글 목록 리스트
	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> list = new ArrayList<>();
		System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");
		list = jdbcTemplate.query(BOARD_LIST, new BoradRowMapper());
		return list;
	}
	//BOARD수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring updateBoard() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE,vo.getTitle(),vo.getContent(),vo.getFiles(),vo.getSeq());
	}
	//상세정보
	public BoardVO getBoard(int seq) {
		BoardVO board = new BoardVO();
		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
		Object[] args = {seq};
		board = jdbcTemplate.queryForObject(BOARD_GET, args,new BoradRowMapper());
	    return board;
	}
	//삭제 메소드
	public int deleteBoard(int seq) {
		 int result =0;
		 System.out.println("===> Spring deleteBoard() 기능 처리");
		 result = jdbcTemplate.update(BOARD_DELETE, seq);
		return result;
	}
	
}
