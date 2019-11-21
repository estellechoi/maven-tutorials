package kr.co.spring.InitDestroy.beans;

public class TestBean {

	public TestBean() {
		System.out.println("TestBean 생성자");
	}
	
	public void init() {
		System.out.println("TestBean의 init 메소드");
	}
	
	public void destroy() {
		System.out.println("TestBean의 destroy 메소드");
		
	}
}
