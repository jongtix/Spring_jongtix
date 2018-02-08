package sam04;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greet;

	public void setName(String name) {
		this.name = name;
	}

	public void setGreet(String greet) {
		this.greet = greet;
	}

	@Override
	public void sayHello() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(name + "님 " + greet);
	}

}
