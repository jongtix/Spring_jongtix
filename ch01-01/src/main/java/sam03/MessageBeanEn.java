package sam03;

public class MessageBeanEn implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println(name + ", Hello~");
	}

}
