package sam01;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * init() 초기화 작업 직전/직후에 처리할 작업이 있으면 여기서 처리
 */
public class CustomerBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("5. 초기화 전 Bean에 대한 처리 실행");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("7. 초기화 후 Bean에 대한 처리 실행");
		return bean;
	}

}
