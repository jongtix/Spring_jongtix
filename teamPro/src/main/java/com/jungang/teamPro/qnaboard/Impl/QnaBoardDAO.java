package com.jungang.teamPro.qnaboard.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jungang.teamPro.common.JDBCUtil;
import com.jungang.teamPro.qnaboard.QnaBoard;

@Repository("qnaBoarDao")
public class QnaBoardDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private final String QNABOARD_GETNUM = "select max(num) from pj_QnAboard";
	private final String QNABOARD_REUPDATE = "update pj_QnAboard set re_step = re_step + 1 where ref = ? and re_step > ?";
	private final String QNABOARD_INSERT = "insert into pj_QnAboard(num, flag, writer, subject, content, email, readcount, password, ref, re_step, re_level, ip, reg_date) "
			+ "values(?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?, ?, sysdate)";
	private final String QNABOARD_TOTAL = "select count(*) from pj_QnAboard where flag like '1%' and del != 'Y'";
	private final String FAQBOARD_TOTAL = "select count(*) from pj_QnAboard where (flag like '11' and del != 'Y') or (flag like '1%' and readcount > 20 and del != 'Y')";
	private final String QNABOARD_LIST = "select * from (select rownum rn, a.* from (select * from pj_QnAboard where flag like '1%' order by ref desc, re_step) a) where rn between ? and ?";
	private final String FAQBOARD_LIST = "select * from (select rownum rn, a.* from (select * from pj_QnAboard where (flag like '11') or (flag like '1%' and readcount > 20) order by ref desc, re_step) a) where rn between ? and ?";
	private final String QNABOARD_READCNT = "update pj_QnAboard set readcount = nvl(readcount, 0) + 1 where num = ?";
	private final String QNABOARD_GET = "select * from (select rownum rn, a.* from (select * from pj_QnAboard where flag like '1%' order by num asc) a) where num = ?";
	private final String QNABOARD_UPDATE = "update pj_qnaboard set subject = ?, email = ?, content = ? where num = ?";
	private final String QNABOARD_MOVE = "update pj_qnaboard set flag = 11 where num = ?";
	private final String QNABOARD_DELETE = "delete pj_qnaboard where num = ?";
	private final String QNABOARD_CHECKRE = "";

	// 글 등록
	public int insertQnaBoard(QnaBoard board) {
		int result = 0;
		int number = 0; // 글 번호
		int num = board.getNum(); // 글 존재 확인
		try {
			conn = JDBCUtil.getConnection();
			// 게시판에서 가장 큰 글번호
			pstmt = conn.prepareStatement(QNABOARD_GETNUM);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = rs.getInt(1);
				number += 1; // 새로운 글번호
				pstmt.close();
				if (num != 0) { // 답변글일 경우
					pstmt = conn.prepareStatement(QNABOARD_REUPDATE);
					int i = 0;
					pstmt.setInt(++i, board.getRef());
					pstmt.setInt(++i, board.getRe_step());
					pstmt.executeUpdate();
					pstmt.close();
					board.setRe_level(board.getRe_level() + 1);
					board.setRe_step(board.getRe_step() + 1);
				} else if (num == 0) { // 답변글이 아닐 경우
					board.setRef(number);
				}
				pstmt = conn.prepareStatement(QNABOARD_INSERT);
				int i = 0;
				pstmt.setInt(++i, number);
				pstmt.setInt(++i, board.getFlag());
				pstmt.setString(++i, board.getWriter());
				pstmt.setString(++i, board.getSubject());
				pstmt.setString(++i, board.getContent());
				pstmt.setString(++i, board.getEmail());
				pstmt.setString(++i, board.getPassword());
				pstmt.setInt(++i, board.getRef());
				pstmt.setInt(++i, board.getRe_step());
				pstmt.setInt(++i, board.getRe_level());
				pstmt.setString(++i, board.getIp());
				result = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}

	// Q&A 게시판 글 수
	public int getQnaBoardTotal() {
		int total = 0;
		try {
			conn = JDBCUtil.getConnection();
			// 카테고리가 1로 시작하고 지워지지 않은 글 선택
			pstmt = conn.prepareStatement(QNABOARD_TOTAL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return total;
	}

	// FAQ 게시판 글 수
	public int getFaqBoardTotal() {
		int total = 0;
		try {
			conn = JDBCUtil.getConnection();
			// FAQ로 옮겨진 게시글이거나 Q&A 글 중 조회수가 20 이상인 글 선택
			pstmt = conn.prepareStatement(FAQBOARD_TOTAL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return total;
	}

	// Q&A 게시판 글 목록
	public List<QnaBoard> selectQnaBoardList(int startRow, int endRow) {
		List<QnaBoard> list = new ArrayList<QnaBoard>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(QNABOARD_LIST);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnaBoard b = new QnaBoard();
				int i = 1;
				b.setNum(rs.getInt(++i));
				b.setFlag(rs.getInt(++i));
				b.setWriter(rs.getString(++i));
				b.setSubject(rs.getString(++i));
				b.setContent(rs.getString(++i));
				b.setEmail(rs.getString(++i));
				b.setReadcount(rs.getInt(++i));
				b.setPassword(rs.getString(++i));
				b.setRef(rs.getInt(++i));
				b.setRe_step(rs.getInt(++i));
				b.setRe_level(rs.getInt(++i));
				b.setIp(rs.getString(++i));
				b.setReg_date(rs.getDate(++i));

				list.add(b);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	// FAQ 게시판 글 목록
	public List<QnaBoard> selectFaqBoardList(int startRow, int endRow) {
		List<QnaBoard> list = new ArrayList<QnaBoard>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(FAQBOARD_LIST);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnaBoard b = new QnaBoard();
				int i = 1;
				b.setNum(rs.getInt(++i));
				b.setFlag(rs.getInt(++i));
				b.setWriter(rs.getString(++i));
				b.setSubject(rs.getString(++i));
				b.setContent(rs.getString(++i));
				b.setEmail(rs.getString(++i));
				b.setReadcount(rs.getInt(++i));
				b.setPassword(rs.getString(++i));
				b.setRef(rs.getInt(++i));
				b.setRe_step(rs.getInt(++i));
				b.setRe_level(rs.getInt(++i));
				b.setIp(rs.getString(++i));
				b.setReg_date(rs.getDate(++i));

				list.add(b);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	// 조회수 증가
	public void updateReadCount(int num) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(QNABOARD_READCNT);
			pstmt.setInt(1, num);
			pstmt.executeQuery();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

	// Q&A 게시글 얻기
	public QnaBoard getQnaBoard(int num) {
		QnaBoard board = new QnaBoard();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(QNABOARD_GET);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int i = 0;
				board.setNum(rs.getInt(++i));
				board.setFlag(rs.getInt(++i));
				board.setWriter(rs.getString(++i));
				board.setSubject(rs.getString(++i));
				board.setContent(rs.getString(++i));
				board.setEmail(rs.getString(++i));
				board.setReadcount(rs.getInt(++i));
				board.setPassword(rs.getString(++i));
				board.setRef(rs.getInt(++i));
				board.setRe_step(rs.getInt(++i));
				board.setRe_level(rs.getInt(++i));
				board.setIp(rs.getString(++i));
				board.setReg_date(rs.getDate(++i));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return board;
	}

	// Q&A 게시글 수정
	public int updateQnaBoard(QnaBoard board) {
		int result = 0;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(QNABOARD_UPDATE);
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getNum());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}

	// FAQ 게시판으로 글 옮기기
	public int moveFaq(int num) {
		int result = 0;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(QNABOARD_MOVE);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}

	// Q&A 글 삭제
	public int deleteQnaBoard(int num) {
		int result = 0;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(QNABOARD_DELETE);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}

	// 댓글 존재 확인
	public boolean isReply(int num) {
		boolean isTrue = false;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(QNABOARD_CHECKRE);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) > 0) {
					isTrue = true; // 댓글 존재
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return isTrue;
	}
}
