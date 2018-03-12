package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.springbook.biz.board.BoardVO;

public class BoradRowMapper implements RowMapper<BoardVO> {
//쿼리결과를 VO객체의 속성과 1:1매칭 시키는 메소드(mybatis의 ResultMap과 비슷한기능)
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getString("content"));
		board.setRegDate(rs.getDate("regDate"));
		board.setCnt(rs.getInt("cnt"));
		board.setFiles(rs.getString("files"));
		return board;
	}
}
