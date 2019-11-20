package kr.co.spring.BeanPostProcessor.beans;

public class TestBean2 {

	public TestBean2() {
		System.out.println("TestBean2 생성자");
	}
	
	public void init2() {
		System.out.println("TestBean2 init 메소드");
	}
}
