package kr.co.spring.beans;

public class TestBean {

	// 관심 메소드로 등록하기 (pointcut 으로 등록)
	public void testMethod() {
		System.out.println("testBean.testMethod() 호출");
	}

	// 관심 메소드로 등록 안했음.
	public void testMethod2() {
		System.out.println("testBean.testMethod2() 호출");
	}
	
	// 매개변수가 있는 메소드를 관심사로 등록해보자. (pointcut)
	public void testMethod(int a) {
		System.out.println("testBean.testMethod(int) 호출");
	}
	
	public void testMethod(String str) {
		System.out.println("testBean.testMethod(java.lang.String) 호출");
	}
	
	public void testMethod(int a, int b) {
		System.out.println("testBean.testMethod(int, int) 호출");
	}

	public void testMethod(int a, String str) {
		System.out.println("testBean.testMethod(int, java.lang.String) 호출");
	}

}
