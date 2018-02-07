package sam01;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageBeanImpl implements MessageBean, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
	private String greeting;
	private String beanName;
	private BeanFactory beanFactory;

	public MessageBeanImpl() {
		System.out.println("1. Bean의 생성자 실행");
	}

	public void setGreeting(String greeting) {
		System.out.println("2. 세터 메소드 실행");
		this.greeting = greeting;
	}

	private void init() {
		System.out.println("초기화 메소드 실행");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.print("4. BeanFactory 지정 ");
		System.out.println("-> " + beanFactory.getClass());
		this.beanFactory = beanFactory;
	}

	@Override
	public void sayHello() {
		System.out.println(greeting + " " + beanName);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("종료");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("6. 프로퍼티 설정 완료");
	}

	@Override
	public void setBeanName(String name) {
		System.out.print("3. Bean명 지정 ");
		this.beanName = name;
		System.out.println("-> " + name);
	}

}
