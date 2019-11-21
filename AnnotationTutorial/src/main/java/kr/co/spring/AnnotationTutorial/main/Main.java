package kr.co.spring.AnnotationTutorial.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.AnnotationTutorial.beans.TestBean;
import kr.co.spring.AnnotationTutorial.beans.TestBean4;

public class Main {

	public static void main(String[] args) {

		// xml 방식
		// xml 정보 로딩시 bean 객체도 생성한다. (생성자 호출)
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/spring/AnnotationTutorial/config/beans.xml");
		
		// bean 호출 
		TestBean testBean = ctx.getBean("testBean", TestBean.class);
		System.out.printf("testBean : %s\n", testBean);

		System.out.println("----------------------------------------------");

		// bean 호출시 객체 새성 (lazy-init = true)
		TestBean testBean2 = ctx.getBean("testBean2", TestBean.class);
		System.out.printf("testBean2 : %s\n", testBean2);

		System.out.println("----------------------------------------------");

		// testBeanXml2 bean을 다시 호출해도 객체는 생성되지 않는다 (scope = singletone)
		TestBean testBean2_2 = ctx.getBean("testBean2", TestBean.class);
		System.out.printf("testBean2_2 : %s\n", testBean2_2);
		
		// id 가 없는 bean 호출하기 
		TestBean4 testBean4 = ctx.getBean(TestBean4.class);
		System.out.printf("testBean4 : %s\n", testBean4);

		
		ctx.close();
		
	}

}
