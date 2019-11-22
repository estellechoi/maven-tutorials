package kr.co.spring.beans;

public class TestBean {
	
	
	
	public int aspectMethod() {
		System.out.println("관심 메소드를 호출했습니다.");
//		int test = 100/0; // after throwing 메소드 작동 확인을 위해 고의적으로 예외 발생시키는 코드 삽입 
		int test = 100;
		return test;
	}
	
	
	
	
}
