package com.springbook.biz.user;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		//1.Spring 컨테이너 구동
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("annotationAopContext.xml");
		//2.Spring 컨테이너로부터 UserServieImpl 객체 lookup
		UserService userService =
				(UserService)container.getBean("userService");
		
		//3. 로그인 테스트
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = userService.getUser(vo);
		if(user!=null)
			System.out.println(user.getName()+"님 환영합니다.");
		else
			System.out.println("로그인 실패");
		
		//4. 사용자 추가 테스트
		//Scanner scanner = new Scanner(System.in);
		/*vo.setId(null);
		vo.setPassword("1234");
		vo.setName("홍길동");
		vo.setRole("User");*/
	
		/*System.out.print("id를 입력하세요:");
		 vo.setId(scanner.next());
		System.out.print("password를 입력하세요:");
		 vo.setPassword(scanner.next());
		 System.out.print("이름을 입력하세요:");
		 vo.setName(scanner.next());
		 vo.setRole("User");*/

		 //user = userService.setUser(vo);
		  System.out.println(user);
		
		
		
	   //4. Spring 컨테이너 종료.
		container.close();

	}

}
