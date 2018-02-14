package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("annotationContext.xml");

		UserService userService = (UserService) container.getBean("userService");

		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test1234");

		UserVO user = userService.getUser(vo);
		System.out.println(user.toString());

		vo.setId("user1");
		vo.setPassword("user1234");
		vo.setName("테스트");
		vo.setRole("user");
		userService.setUser(vo);

		user = userService.getUser(vo);
		System.out.println(user.toString());

		container.close();

	}
}
