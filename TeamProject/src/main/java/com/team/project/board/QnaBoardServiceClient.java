package com.team.project.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class QnaBoardServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		QnaBoardService service = (QnaBoardService) container.getBean("qnaBoardService");

		QnaBoardVO vo = new QnaBoardVO();
		vo.setFlag(1);
		vo.setWriter("작성자");
		vo.setSubject("제목");
		vo.setContent("내용");
		vo.setEmail("이메일");
		vo.setPassword("1111");
		vo.setRef(1);
		vo.setIp("127.0.0.1");
		service.insertQnaBoard(vo);

		System.out.println("1");

		container.close();
	}
}
