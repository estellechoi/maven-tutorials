package kr.co.spring.XmlTutorial.beans;

public class BeansLifeCycle {

	public BeansLifeCycle() {
		System.out.println("BeansLifeCycle 생성자");
	}
	
	public void beanInit() {
		System.out.println("BeansLifeCycle 의 init 메소드");
	}
	
	public void beanDestroy() {
		System.out.println("BeanLifeCycle 의 destroy 메소드");
	}
}
