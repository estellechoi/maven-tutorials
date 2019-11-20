package kr.co.spring.XmlTutorial.beans;

public class BeansLifeCycle3 {

	public BeansLifeCycle3() {
		System.out.println("BeansLifeCycle3 생성자");
	}
	
	public void defaultInit() {
		System.out.println("BeansLifeCycle3 의 default-init 메소드");
	}
	
	public void defaultDestroy() {
		System.out.println("BeanLifeCycle3 의 default-destroy 메소드");
	}
	
	public void beanInit() {
		System.out.println("BeansLifeCycle3 의 init 메소드");
	}
	
	public void beanDestroy() {
		System.out.println("BeanLifeCycle3 의 destroy 메소드");
	}
}
