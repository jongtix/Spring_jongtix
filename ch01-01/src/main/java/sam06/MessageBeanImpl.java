package sam06;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greet;

	// setter 주입(setter-injection)
	public void setName(String name) {
		this.name = name;
	}

	public void setGreet(String greet) {
		this.greet = greet;
	}

	@Override
	public void sayHello() {
		System.out.println(name + "님 " + greet + "!");
	}

}
