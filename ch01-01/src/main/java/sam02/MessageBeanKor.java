package sam02;

public class MessageBeanKor implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println(name + ", 안녕~");
	}

}
