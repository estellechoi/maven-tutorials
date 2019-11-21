package kr.co.spring.InitDestroy.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.spring.InitDestroy.beans.TestBean;
import kr.co.spring.InitDestroy.config.BeanConfiguration;

public class Main {

	public static void main(String[] args) {

		// 설정정보 로딩 
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		// bean 호출 
		// init 메소드 호출 
		TestBean testBean = ctx.getBean("testBean", TestBean.class);
		System.out.printf("testBean : %s\n", testBean);
		
		// 컨테이너 종료 
		// destroy 메소드 호출 
		ctx.close();
	}

}
