package kr.co.spring.AutoWire.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.AutoWire.beans.TestBean;
import kr.co.spring.AutoWire.beans.TestBeanCons;

public class Main {

	public static void main(String[] args) {
		
		// xml 정보 로딩 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/spring/AutoWire/config/beans.xml");
		
		// bean 호출
		
		// 1) 수동 주입 
		// 1-1) setter 를 통한 주입 
		TestBean testBean = ctx.getBean("testBean", TestBean.class);
		System.out.printf("testBean.member1 : %s\n", testBean.getMember1());
		System.out.printf("testBean.member2 : %s\n", testBean.getMember2());
		
		System.out.println("------------------------------------------");
		
		// 1-2) 생성자를 통한 주입 
		TestBeanCons testBeanCons = ctx.getBean("testBeanCons", TestBeanCons.class);
		System.out.printf("testBeanCons.integerData : %d\n", testBeanCons.getIntegerData());
		System.out.printf("testBeanCons.stringData : %s\n", testBeanCons.getStringData());
		System.out.printf("testBeanCons.group1 : %s\n", testBeanCons.getGroup1());
		System.out.printf("testBeanCons.group2 : %s\n", testBeanCons.getGroup2());

		System.out.println("------------------------------------------");

		TestBeanCons testBeanCons3 = ctx.getBean("testBeanCons3", TestBeanCons.class);
		System.out.printf("testBeanCons3.integerData : %d\n", testBeanCons3.getIntegerData());
		System.out.printf("testBeanCons3.stringData : %s\n", testBeanCons3.getStringData());
		System.out.printf("testBeanCons3.group1 : %s\n", testBeanCons3.getGroup1());
		System.out.printf("testBeanCons3.group2 : %s\n", testBeanCons3.getGroup2());

		
		System.out.println("------------------------------------------");

		
		
		
		
		// 2) 자동 주입
		// 2-1) byName 
		TestBean testBean2 = ctx.getBean("testBean2", TestBean.class);
		System.out.printf("testBean2.member1 : %s\n", testBean2.getMember1());
		System.out.printf("testBean2.member2 : %s\n", testBean2.getMember2());

		System.out.println("------------------------------------------");

		// 2-2) byType
		TestBean testBean3 = ctx.getBean("testBean3", TestBean.class);
		System.out.printf("testBean3.member1 : %s\n", testBean3.getMember1());
		System.out.printf("testBean3.member2 : %s\n", testBean3.getMember2());
		System.out.printf("testBean3.group1 : %s\n", testBean3.getGroup1());
		System.out.printf("testBean3.group2 : %s\n", testBean3.getGroup2());

		System.out.println("------------------------------------------");

		// 2-3) constructor : 생성자와 타입이 같은 객체를 자동 주입
		TestBeanCons testBeanCons2 = ctx.getBean("testBeanCons2", TestBeanCons.class);
		System.out.printf("testBeanCons2.integerData : %d\n", testBeanCons2.getIntegerData());
		System.out.printf("testBeanCons2.stringData : %s\n", testBeanCons2.getStringData());
		System.out.printf("testBeanCons2.group1 : %s\n", testBeanCons2.getGroup1());
		System.out.printf("testBeanCons2.group2 : %s\n", testBeanCons2.getGroup2());
		
		System.out.println("------------------------------------------");

		TestBeanCons testBeanCons4 = ctx.getBean("testBeanCons4", TestBeanCons.class);
		System.out.printf("testBeanCons4.integerData : %d\n", testBeanCons4.getIntegerData());
		System.out.printf("testBeanCons4.stringData : %s\n", testBeanCons4.getStringData());
		System.out.printf("testBeanCons4.group1 : %s\n", testBeanCons4.getGroup1());
		System.out.printf("testBeanCons4.group2 : %s\n", testBeanCons4.getGroup2());

		
		System.out.println("------------------------------------------");

		// 3) 별도로 자동주입 설정하지 않은 bean 은 default-autowire 설정을 따른다.
		TestBean testBean4 = ctx.getBean("testBean4", TestBean.class);
		System.out.printf("testBean4.member1 : %s\n", testBean4.getMember1());
		System.out.printf("testBean4.member2 : %s\n", testBean4.getMember2());
		System.out.printf("testBean4.group1 : %s\n", testBean4.getGroup1());
		System.out.printf("testBean4.group2 : %s\n", testBean4.getGroup2());

		System.out.println("------------------------------------------");
		
		// 3-2) default-autowire 따르지 않도록 설정된 bean (autowire="no") 
		TestBean testBean5 = ctx.getBean("testBean5", TestBean.class);
		System.out.printf("testBean5.member1 : %s\n", testBean5.getMember1());
		System.out.printf("testBean5.member2 : %s\n", testBean5.getMember2());
		System.out.printf("testBean5.group1 : %s\n", testBean5.getGroup1());
		System.out.printf("testBean5.group2 : %s\n", testBean5.getGroup2());

		
		ctx.close();
	}

}
