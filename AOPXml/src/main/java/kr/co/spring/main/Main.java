package kr.co.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.beans.TestBean;

public class Main {

	public static void main(String[] args) {

		// 컨테이너 생성 (lazy-init = true 인 bean 제외하고 bean 객체도 미리 생성)
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/spring/config/beans.xml");

		// bean 호출 
		TestBean testBean = ctx.getBean("testBean", TestBean.class);
		
		// bean 의 메소드 호출 (관심 메소드 호출)
		// 설정된 Advice 메소드들도 호출 
		int a = testBean.aspectMethod();
		
		// 메소드 반환값 콘솔 출력 
		System.out.printf("a : %d\n", a);
		
		
		
		ctx.close();
	}

}
