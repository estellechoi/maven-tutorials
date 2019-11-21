package kr.co.spring.AnnotationTutorial.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.spring.AnnotationTutorial.beans.TestBean;
import kr.co.spring.AnnotationTutorial.beans.TestBean2;
import kr.co.spring.AnnotationTutorial.beans.TestBean3;
import kr.co.spring.AnnotationTutorial.beans.TestBean4;
import kr.co.spring.AnnotationTutorial.config.BeanConfiguration;

public class MainAnnotation {

	public static void main(String[] args) {
		
		// annotation 방식 
		// 컨테이너 로딩시 bean 객체도 생성한다. (@Bean 메소드 호출)
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class); 

		System.out.println("----------------------------------------------");

		// bean 호출 
		TestBean test1 = ctx.getBean("test1", TestBean.class);	
		System.out.println("test1 객체 호출");

		System.out.println("----------------------------------------------");

		TestBean test2 = ctx.getBean("test1", TestBean.class);
		System.out.println("test1 객체 호출");

		System.out.println("----------------------------------------------");

		TestBean test1000 = ctx.getBean("test1000", TestBean.class);
		System.out.println("test500 객체 호출 / 이름을 test1000 으로 변경 ");

		System.out.println("----------------------------------------------");

		// @Lazy 어노테이션 사용으로, bean 호출시 객체 생성 
		TestBean2 test600 = ctx.getBean("test600", TestBean2.class);
		System.out.println("test600 객체 호출");

		System.out.println("----------------------------------------------");

		// @Scope("prototype") 어노테이션 사용으로, bean 호출시마다 객체 생성 
		TestBean3 test700 = ctx.getBean("test700", TestBean3.class);
		System.out.println("test700 객체 호출");

		TestBean3 test700_2 = ctx.getBean("test700", TestBean3.class);
		System.out.println("test700_2 객체 호출");

		System.out.println("----------------------------------------------");

		// @Primary 지정된 메소드 호출 
		TestBean4 testBean4 = ctx.getBean(TestBean4.class);
		System.out.println("testBean4 객체 호출");

		System.out.println("----------------------------------------------");

		
		
		
		// 컨테이너 종료 
		ctx.close();
	}

}
