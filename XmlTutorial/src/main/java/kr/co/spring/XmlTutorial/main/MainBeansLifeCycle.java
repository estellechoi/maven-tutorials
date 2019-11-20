package kr.co.spring.XmlTutorial.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.XmlTutorial.beans.BeansLifeCycle;
import kr.co.spring.XmlTutorial.beans.BeansLifeCycle2;
import kr.co.spring.XmlTutorial.beans.BeansLifeCycle3;
import kr.co.spring.XmlTutorial.beans.BeansLifeCycle4;

public class MainBeansLifeCycle {

	public static void main(String[] args) {

		// xml 설정정보 로딩 
		// lazy-init = "true" 설정으로 bean 객체는 미리 생성하지 않는다. 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/spring/XmlTutorial/config/beansLifeCycle.xml");
		
		// bean 객체 생성 -> 생성자 호출
		// init-method = "method" 설정으로, 생성자 호출 직후 init method 가 자동으로 호출된다.
		BeansLifeCycle lifeCycle = ctx.getBean("beansLifeCycle", BeansLifeCycle.class);
		
		System.out.println("------------------------------------");
		
		// bean 객체 생성 -> 생성자 호출
		// default-init-method = "method" 설정으로, 생성자 호출 직추 default init method 가 자동으로 호출된다.
		BeansLifeCycle2 lifeCycle2 = ctx.getBean("beansLifeCycle2", BeansLifeCycle2.class);
		
		System.out.println("------------------------------------");

		// bean 객체 생성 -> 생성자 호출
		// default-init-method = "method" 설정했더라도, init-method 설정으로 default init method 가 아닌 init-method 호출된다.		
		BeansLifeCycle3 lifeCycle3 = ctx.getBean("beansLifeCycle3", BeansLifeCycle3.class);

		System.out.println("------------------------------------");

		// bean 객체 생성 -> 생성자 호출
		// init-method 에 설정된 메소드가 존재하지 않으므로 오류 발생
		BeansLifeCycle4 lifeCycle4 = ctx.getBean("beansLifeCycle4", BeansLifeCycle4.class);

		
		System.out.println("------------------------------------");		
		// IoC 컨테이너 종료 -> bean 객체 모두 소멸
		// destroy-method = "method" 설정으로, bean 소멸시 destroy method 가 자동으로 호출된다.
		ctx.close();
	}

}
