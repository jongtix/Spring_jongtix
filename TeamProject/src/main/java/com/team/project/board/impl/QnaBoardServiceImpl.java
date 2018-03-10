package com.team.project.board.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.project.board.QnaBoardService;
import com.team.project.board.QnaBoardVO;

@Service("qnaBoardService")
public class QnaBoardServiceImpl implements QnaBoardService {
	@Autowired
	private QnaBoardDAO dao;

	@Override
	public void insertQnaBoard(QnaBoardVO vo) {
		dao.insertQnaBoard(vo);
	}

}
