package sam01;

public class Ex01 {
	public static void main(String[] args) {
		MessageBeanKor mk = new MessageBeanKor();
		mk.sayHello("홍길동"); // 홍길동님 안녕하세요!
		MessageBeanEn me = new MessageBeanEn();
		me.sayHello("Hong"); // Hello, Hong!
	}
}
