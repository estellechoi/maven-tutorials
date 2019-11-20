package kr.co.spring.XmlTutorial.beans;

public class BeansLifeCycle2 {

	public BeansLifeCycle2() {
		System.out.println("BeansLifeCycle2 생성자");
	}
	
	public void defaultInit() {
		System.out.println("BeansLifeCycle2 의 default-init 메소드");
	}
	
	public void defaultDestroy() {
		System.out.println("BeanLifeCycle2 의 default-destroy 메소드");
	}
}
