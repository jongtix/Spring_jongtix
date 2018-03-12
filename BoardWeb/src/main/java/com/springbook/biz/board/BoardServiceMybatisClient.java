package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.impl.BoardDAOMybatis;

public class BoardServiceMybatisClient {
	public static void main(String[] args) {
	BoardDAOMybatis boardDAO = new BoardDAOMybatis();
	
	//글 등록 테스트
	BoardVO vo = new BoardVO();
	vo.setTitle("임시 제목");
	vo.setWriter("홍길동");
	vo.setContent("임시내용............");
	vo.setFiles("C:/upLoads/"+"Desert.jpg");
	boardDAO.insertBoard(vo);
	
	//글 목록 검색 기능 테스트
	vo.setSearchCondition("TITLE");
	vo.setSearchKeyword("");
	List<BoardVO> boardList = boardDAO.getBoardList(vo);
	for(BoardVO b:boardList) {
		System.out.println("--->"+b.toString());
	}
	//글 수정 테스트
	for(int i=0;i<boardList.size();i++)
		if(boardList.get(i).getSeq()==8)
			vo = boardList.get(i);//8번 vo객체 저장 
	
	//vo = boardList.get(8);//8번 vo객체 저장
	vo.setTitle("임시제목 수정");
	vo.setContent("임시내용 수정......");
	//수정된 vo객체 출력
	System.out.println(vo.toString());
	//수정 처리
	//boardService.updateBoard(vo);
	//결과리스트
	//글 목록 검색 기능 테스트
	//boardList = boardService.getBoardList(vo);
	System.out.println("------- 수정 결과 -------");
	for(BoardVO b:boardList)
		System.out.println("--->"+b.toString());

	//상세보기
	for(int i=0;i<boardList.size();i++)
		if(boardList.get(i).getSeq()==8)
			vo = boardList.get(i);//8번 vo객체 저장
	
	 //vo = boardService.getBoard(vo.getSeq());
	 System.out.println("상세정보");
	 System.out.println(vo);
	 
	 int seq=-1;
	 //삭제
	 for(int i=0;i<boardList.size();i++)
		 if(boardList.get(i).getSeq()==9)
			 seq = boardList.get(i).getSeq();
	 //글번호로 삭제
	 //int result = boardService.deleteBoard(seq);
	/* if(result>0)
		 System.out.println("삭제성공");
	 else
		 System.out.println("삭제실패");*/
	 
	 //삭제 후 리스트
	// boardList = boardService.getBoardList(vo);
	 for(BoardVO b:boardList) {
			System.out.println("--->"+b.toString());
		}
	}
}
