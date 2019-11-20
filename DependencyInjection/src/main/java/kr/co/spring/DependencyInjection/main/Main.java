package kr.co.spring.DependencyInjection.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.DependencyInjection.beans.TestBean;

public class Main {

	public static void main(String[] args) {
		
		// 1) 자바코드로 객체 생성 및 메소드 호출 
		
		TestBean testBeanJava = new TestBean();
		testBeanJava.printData();
		
		TestBean testBeanJava2 = new TestBean(100);
		testBeanJava2.printData();
		
		TestBean testBeanJava3 = new TestBean(11.1);
		testBeanJava3.printData();

		TestBean testBeanJava4 = new TestBean("hello world!");
		testBeanJava4.printData();

		
		// 2) 스프링 설정파일 사용하여 객체 생성 및 메소드 호출 
		
		// xml 정보 로딩 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/spring/DependencyInjection/config/beans.xml");
		
		// bean 호출 (lazy-init = true 이므로 이때 bean 객체 생성 및 생성자 실행)
		TestBean testBeanSpring = ctx.getBean("testBean", TestBean.class);
		testBeanSpring.printData();

		// 생성자를 통한 의존주입 설정한 bean 호출 (bean 객체 생성 및 매개변수 1 개인 생성자 실행)
		// 매개변수 1 개인 생성자가 다수라면, String > double > int 우선한다.
		TestBean testBeanSpring2 = ctx.getBean("testBean2", TestBean.class);
		testBeanSpring2.printData();

		// 위와 같은 결과 
		TestBean testBeanSpring3 = ctx.getBean("testBean3", TestBean.class);
		testBeanSpring3.printData();

		TestBean testBeanSpring4 = ctx.getBean("testBean4", TestBean.class);
		testBeanSpring4.printData();

	}

}
