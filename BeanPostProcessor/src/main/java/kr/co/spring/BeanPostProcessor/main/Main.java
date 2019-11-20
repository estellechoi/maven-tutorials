package kr.co.spring.BeanPostProcessor.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.BeanPostProcessor.beans.TestBean;
import kr.co.spring.BeanPostProcessor.beans.TestBean2;

public class Main {

	public static void main(String[] args) {

		// xml 정보로딩시 lazy-init = false 인 bean 객체들은 미리 생성된다.
		// BeanPostProcessor 인터페이스를 구현한 클래스의 bean 객체도 생성되겠지 ?
		ClassPathXmlApplicationContext ctx  = new ClassPathXmlApplicationContext("kr/co/spring/BeanPostProcessor/config/beans.xml");
		
		// bean 객체 생성시 init 메소드가 호출된다.
		// 이 때, postProcessBeforeInitialization, postProcessAfterInitialization 메소드가 전후로 호출된다.
		TestBean testBean = ctx.getBean("testBean", TestBean.class);
		
		System.out.println("------------------------------");
		
		// init-method 미설정시에도, postProcessBeforeInitialization, postProcessAfterInitialization 메소드는 호출된다.
		TestBean2 testBean2 = ctx.getBean("testBean2", TestBean2.class);
		
		ctx.close();
	}

}
