package polymorphism;

public class TVUser {
	public static void main(String[] args) {
		/* SamsungTV tv = new SamsungTV(); */
		/* LgTV tv = new LgTV(); */
		/* TV tv = new SamsungTV(); */
		/* TV tv = new LgTV(); */

		BeanFactory factory = new BeanFactory();
		TV tv = (TV) factory.getBean("samsung");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}
}
