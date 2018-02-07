package sam08;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greet;
	private Outputter outputter; // 객체 의존관계

	public void setName(String name) {
		this.name = name;
	}

	public void setGreet(String greet) {
		this.greet = greet;
	}

	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}

	@Override
	public void sayHello() {
		String msg = name + "님 " + greet;
		System.out.println(msg);
		if (outputter != null) {
			FileOutputter fo = new FileOutputter();
			outputter.output(msg);
		}
	}

}
