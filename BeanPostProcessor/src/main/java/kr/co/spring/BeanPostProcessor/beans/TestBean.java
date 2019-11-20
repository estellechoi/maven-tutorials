package kr.co.spring.BeanPostProcessor.beans;

public class TestBean {

	public TestBean() {
		System.out.println("TestBean 생성자");
	}
	
	public void init() {
		System.out.println("TestBean init 메소드");
	}
}
