package com.springbook.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.impl.BoardDAOMybatis;
import com.springbook.biz.board.impl.BoardDAOSpring;
import com.springbook.biz.board.impl.BoardDAOSpring2;
import com.springbook.biz.board.impl.BoardDAOSpringOracle;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAOMybatis dao;

	@Override
	public void insertBoard(BoardVO vo) {
		/*
		 * if (vo.getSeq() == 0) { throw new
		 * IllegalArgumentException("0번 글은 등록할 수 없습니다."); }
		 */
		dao.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		dao.updateBoard(vo);
	}

	@Override
	public int deleteBoard(int seq) {
		return dao.deleteBoard(seq);
	}

	@Override
	public BoardVO getBoard(int seq) {
		return dao.getBoard(seq);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return dao.getBoardList(vo);
	}

}
