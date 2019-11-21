package kr.co.spring.DependencyInjection.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.DependencyInjection.beans.DataBean;
import kr.co.spring.DependencyInjection.beans.TestBean;
import kr.co.spring.DependencyInjection.beans.TestBean2;

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

		TestBean testBeanJava5 = new TestBean(100, 11.1, "hello world!");
		testBeanJava5.printData();

		// 자바코드로 객체 생성시, 생성자 매개변수의 자료형과 순서가 다르면 오류 
		/*
		TestBean testBeanJava6 = new TestBean("hello world!", 100, 11.1);
		testBeanJava6.printData();
		*/
		
		// 생성자 매개변수에 들어갈 값이 클래스 객체일 때 
		DataBean d1 = new DataBean();
		DataBean d2 = new DataBean();
		TestBean2 testBeanJava8 = new TestBean2(d1, d2);
		testBeanJava8.print();
		
		
		
		
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

		// 매개변수 3개 일 때 
		TestBean testBeanSpring5 = ctx.getBean("testBean5", TestBean.class);
		testBeanSpring5.printData();

		// 생성자 매개변수 자료형 순서와 xml 에서 bean 정의시 constructor-arg 자료형 순서가 다를 때 
		// 작성순서와 무관하게 자료형 맞추어 자동 주입 
		TestBean testBeanSpring6 = ctx.getBean("testBean6", TestBean.class);
		testBeanSpring6.printData();

		// 자료형이 같은 생성자 매개변수가 복수일 때, index 로 순서 지정 
		// index 미지정시, 작성한 순서대로 주입 
		TestBean testBeanSpring7 = ctx.getBean("testBean7", TestBean.class);
		testBeanSpring7.printData();
		
		// 생성자 매개변수에 들어갈 값이 클래스 객체일 때 (의존주입시 bean 정의)
		TestBean2 testBeanSpring8 = ctx.getBean("testBean8", TestBean2.class);
		testBeanSpring8.print();
		
		// 생성자 매개변수에 들어갈 값이 클래스 객체일 때 (이미 정의된 bean 의존주입)
		TestBean2 testBeanSpring9 = ctx.getBean("testBean9", TestBean2.class);
		testBeanSpring9.print();
		
	}

}
