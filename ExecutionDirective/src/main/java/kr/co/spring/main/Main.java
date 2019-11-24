package kr.co.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.beans.DataBean;
import kr.co.spring.beans.TestBean;
import kr.co.spring.beans2.TestBean2;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/spring/config/beans.xml");
		
		// bean 호출 
		TestBean testBean = ctx.getBean("testBean", TestBean.class);
		
		// 메소드명 뿐만 아니라 pointcut 정보가 모두 일치하는 메소드만 관심사로 등록됨.

		// testMethod(*) -> 타입에 상관없이 매개변수 1 개인 메소드만 모두 weaving
		// (*, *) -> 타입 상관없이 매개변수 2 개인 메소드만 모두 weaving
		// (..) -> 매개변수 타입, 개수, 유무 상관없이 모두 weaving
		// (java.lang.String) -> String 타입 매개변수 1 개인 메소드만 weaving
		// (int, int) -> int 타입 매개변수 2 개인 메소드만 weaving
		// (int, *) -> 첫번째 매개변수는 int, 두번째 매개변수는 아무 타입 메소드 weaving
		
		testBean.testMethod();
		
		System.out.println("---------------------------------------------------------");

		testBean.testMethod("hello");
		
		System.out.println("---------------------------------------------------------");

		testBean.testMethod(1);
		
		System.out.println("---------------------------------------------------------");

		testBean.testMethod(1,2);
		
		System.out.println("---------------------------------------------------------");

		testBean.testMethod(1,"hi");
		
		System.out.println("---------------------------------------------------------");
		
		// testMethod2() 호출 
		testBean.testMethod2();
		
		System.out.println("=========================================================");

		
		// bean 호출 
		DataBean dataBean = ctx.getBean("dataBean", DataBean.class);

		dataBean.testMethod();

		System.out.println("=========================================================");

		// bean 호출
		TestBean2 testBean2 = ctx.getBean("testBean2", TestBean2.class);
		testBean2.testMethod();
	
		System.out.println("---------------------------------------------------------");
		
		int a = testBean2.getInteger();
		System.out.printf("testBean2.getInteger : %d\n", a);
		
		ctx.close();
	}

}
