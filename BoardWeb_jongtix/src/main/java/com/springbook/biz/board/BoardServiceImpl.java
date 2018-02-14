package com.springbook.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.impl.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	@Qualifier("boardDao")
	private BoardDAO dao;

	@Override
	public void insertBoard(BoardVO vo) {
		dao.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		dao.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		dao.deleteBoard(vo);
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
