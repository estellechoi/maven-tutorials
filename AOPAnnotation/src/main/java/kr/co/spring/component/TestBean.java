package kr.co.spring.component;

import org.springframework.stereotype.Component;

@Component
public class TestBean {

	public void method1() throws Exception {
		System.out.println("TestBean 의 method1() 호출");
		int a = 100/0;
	}
}
