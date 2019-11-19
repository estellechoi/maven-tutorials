package kr.co.spring.XmlTutorial.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.XmlTutorial.beans.HelloWorld;

public class Main {

	public static void main(String[] args) {

		// beans.xml 스프링 설정 파일을 로딩한다 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/spring/XmlTutorial/config/beans.xml");
		
		// beans.xml 에 정의한 bean 객체의 주소값을 가져온다 
		// getBean() 의 반환값은 Object 타입이므로 형변환 필요 
		HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorldEng"); // 형변환 방법 1
		callMethod(helloWorld);
		
		HelloWorld helloWorld2 = ctx.getBean("helloWorldEng", HelloWorld.class); // 형변환 방법 2
		callMethod(helloWorld2);
		
		ctx.close();
	}
	
	public static void callMethod(HelloWorld helloWorld) {
		helloWorld.sayHello();
	}

}
