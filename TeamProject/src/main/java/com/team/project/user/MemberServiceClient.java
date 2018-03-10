package com.team.project.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		MemberService service = (MemberService) container.getBean("memberService");

		MemberVO vo = new MemberVO();
		vo.setId("MemberId1");
		vo.setPassword("1111");

		MemberVO member = service.getMember(vo);
		System.out.println(member.getName() + "님 환영");

		container.close();
	}
}
