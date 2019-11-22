package kr.co.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TestBean {

	public TestBean() {
		System.out.println("TestBean 의 생성자");
	}
	
	//생성자 호출 후 자동 호출되는 메소드로 설정한다.
	@PostConstruct
	public void init() {
		System.out.println("TestBean의 init 메소드");
	}
	
	// 객체 소멸 전 자동 호출되는 메소드로 설정한다.
	@PreDestroy
	public void destroy() {
		System.out.println("TestBean의 destroy 메소드");
	}
}
