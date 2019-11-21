package kr.co.spring.DependencyInjection.beans;

public class TestBean2 {

	// 객체 변수
	private DataBean dataBean1;
	private DataBean dataBean2;

	public TestBean2(DataBean dataBean1, DataBean dataBean2) {
		System.out.println("생성자");
		this.dataBean1 = dataBean1;
		this.dataBean2 = dataBean2;
	}
	
	public void print() {
		System.out.printf("dataBean1 : %s\n", dataBean1);
		System.out.printf("dataBean2 : %s\n", dataBean2);		
	}
}
