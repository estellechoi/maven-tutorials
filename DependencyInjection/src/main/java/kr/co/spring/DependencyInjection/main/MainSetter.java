package kr.co.spring.DependencyInjection.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.DependencyInjection.beans.TestBeanSetter;

public class MainSetter {

	public static void main(String[] args) {
	
		// 1) 자바코드로
		TestBeanSetter testJava = new TestBeanSetter();
		testJava.setData1(1);
		System.out.println(testJava.getData1());
		
		
		// 2) 스프링 
		// xml 정보 로딩 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/spring/DependencyInjection/config/beansSetter.xml");
		// bean 호출 
		TestBeanSetter testBean = ctx.getBean("test1", TestBeanSetter.class);
		System.out.printf("test1.data1 : %d\n", testBean.getData1());
		System.out.printf("test1.data2 : %f\n", testBean.getData2());
		System.out.printf("test1.data3 : %s\n", testBean.isData3());
		System.out.printf("test1.data4 : %s\n", testBean.getData4());
		System.out.printf("test1.data5 : %s\n", testBean.getData5());
		System.out.printf("test1.data6 : %s\n", testBean.getData6());

		ctx.close();
	}

}
