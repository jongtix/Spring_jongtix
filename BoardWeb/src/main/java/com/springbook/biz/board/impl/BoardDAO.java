package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

//BoardDAOSpring을 사용하기위해 @Repository 주석처리
//@Repository("boardDao")
public class BoardDAO {
	// JDBC관련 변수
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	// sql문
	private final String BOARD_INSERT = "insert into boardvo(seq,title,writer,content)"
			+ " values((select nvl(max(seq),0)+1 from boardvo),?,?,?)";
	private final String BOARD_LIST = "select * from boardvo order by seq desc";
	private final String BOARD_UPDATE = "update boardvo set writer=?,title=?,content=? where seq=?";
	private final String BOARD_GET = "select * from boardvo where seq=?";
	private final String BOARD_DELETE = "delete from boardvo where seq=?";
	private final String BOARD_CNTUPDATE = "update boardvo set cnt=nvl(cnt,0)+1 where seq=?";
	// Title
	private final String BOARD_LIST_T = "select * from boardvo where title like '%'||?||'%' order by seq desc";
	// Content
	private final String BOARD_LIST_C = "select * from boardvo where content like '%'||?||'%' order by seq desc";
	// ALL
	private final String BOARD_LIST_A = "select * from boardvo where title like '%'||?||'%' or content like '%'||?||'%' order by seq desc";

	public Connection getConnection() {
		try {
			/*
			 * Class.forName("org.h2.Driver"); conn=
			 * DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			 */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void insertBoard(BoardVO vo) {
		Connection conn = null;
		try {
			conn = getConnection();
			if (conn != null) {
				pstmt = conn.prepareStatement(BOARD_INSERT);
				int i = 0;
				pstmt.setString(++i, vo.getTitle());
				pstmt.setString(++i, vo.getWriter());
				pstmt.setString(++i, vo.getContent());
				pstmt.executeUpdate();
			} else
				System.out.println("connection is null");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

		}
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> list = new ArrayList<>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int i = 0;
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt(++i));
				board.setTitle(rs.getString(++i));
				board.setWriter(rs.getString(++i));
				board.setContent(rs.getString(++i));
				board.setRegDate(rs.getDate(++i));
				board.setCnt(rs.getInt(++i));
				list.add(board);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
		}
		return list;
	}

	// 검색조건 처리
	public List<BoardVO> getBoardList(String condition, String keyword) {
		List<BoardVO> list = new ArrayList<>();
		try {
			conn = getConnection();

			if (condition.equals("TITLE")) {
				pstmt = conn.prepareStatement(BOARD_LIST_T);
				pstmt.setString(1, keyword);
			} else if (condition.equals("CONTENT")) {
				pstmt = conn.prepareStatement(BOARD_LIST_C);
				pstmt.setString(1, keyword);
			} else {
				pstmt = conn.prepareStatement(BOARD_LIST_A);
				pstmt.setString(1, keyword);
				pstmt.setString(2, keyword);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int i = 0;
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt(++i));
				board.setTitle(rs.getString(++i));
				board.setWriter(rs.getString(++i));
				board.setContent(rs.getString(++i));
				board.setRegDate(rs.getDate(++i));
				board.setCnt(rs.getInt(++i));
				list.add(board);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
		}
		return list;
	}

	// BOARD수정
	public void updateBoard(BoardVO vo) {
		Connection conn = null;
		try {
			conn = getConnection();
			if (conn != null) {
				pstmt = conn.prepareStatement(BOARD_UPDATE);
				int i = 0;
				pstmt.setString(++i, vo.getWriter());// 작성자 수정용으로 추가
				pstmt.setString(++i, vo.getTitle());
				pstmt.setString(++i, vo.getContent());
				pstmt.setInt(++i, vo.getSeq());
				pstmt.executeUpdate();
			} else
				System.out.println("connection is null");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

	// 상세정보
	public BoardVO getBoard(int seq) {
		BoardVO vo = new BoardVO();
		try {
			updateCount(seq);// 조회수 증가
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int i = 0;
				vo.setSeq(rs.getInt(++i));
				vo.setTitle(rs.getString(++i));
				vo.setWriter(rs.getString(++i));
				vo.setContent(rs.getString(++i));
				vo.setRegDate(rs.getDate(++i));
				vo.setCnt(rs.getInt(++i));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return vo;

	}

	// 삭제 메소드
	public int deleteBoard(int seq) {
		int result = 0;
		try {
			conn = getConnection();
			if (conn != null) {
				pstmt = conn.prepareStatement(BOARD_DELETE);
				int i = 0;
				pstmt.setInt(++i, seq);
				result = pstmt.executeUpdate();
			} else
				System.out.println("connection is null");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}

	// 조회수 증가 메소드
	public void updateCount(int seq) {
		try {
			conn = getConnection();
			if (conn != null) {
				pstmt = conn.prepareStatement(BOARD_CNTUPDATE);
				pstmt.setInt(1, seq);
				pstmt.executeUpdate();
			} else
				System.out.println("connection is null");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

}
