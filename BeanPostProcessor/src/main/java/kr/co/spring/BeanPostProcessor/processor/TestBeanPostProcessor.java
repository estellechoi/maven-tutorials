package kr.co.spring.BeanPostProcessor.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBeanPostProcessor implements BeanPostProcessor {

	// init-method 호출 전 postProcessBeforeInitialization() 메소드가 자동으로 호출된다.
	// 파라미터 Object bean 에는 생성되는 bean 객체의 주소값이 들어간다. 
	// 파라미터 String beanName 에는 bean 의 아이디가 들어간다.
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("before Initialization");
		switch(beanName) {
		case "testBean": System.out.println("id='testBean' 인 bean 객체 생성"); break;
		case "testBean2": System.out.println("id='testBean2' 인 bean 객체 생성"); break;
		}
		return bean;
	}
	

	// init-method 호출 후 postProcessAfterInitialization() 메소드가 자동으로 호출된다.
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("after Initialization");
		return bean;
	}

	
}
