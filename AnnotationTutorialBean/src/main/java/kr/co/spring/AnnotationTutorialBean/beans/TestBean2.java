package kr.co.spring.AnnotationTutorialBean.beans;

import org.springframework.beans.factory.annotation.Value;

public class TestBean2 {

	private int age;
	private String username;
	private DataBean dataBean;
	private Member member;

	// 생성자가 여러개이면, bean 객체 생성시 어떤 생성자가 실행되나 ?
	// 디폴트 생성자가 실행되네 ....
	/*
	public TestBean2() {
		
	}
	*/
	
	//  xml 파일에서 <context:annotation-config /> 설정시, 객체 타입 매개변수는 자동 주입
	// 생성자 매개변수로 지정된 타입의 객체들은 별도의 설정없이 자동 주입된다. (정의된 bean 중 같은 타입의 객체)
	// 생성자 매개변수로 지정된 타입의 값들의 자동주입을 위해서는 @Value("값") 어노테이션을 사용한다. 
	// * @Configuration 파일 설정시에는 사용 불가 (@Component 필요)
	public TestBean2(@Value("27") int age, @Value("youjin") String username, DataBean dataBean) {
		this.age = age;
		this.username = username;
		this.dataBean = dataBean;
//		this.member = member;
	}

	
	// getters 
	public int getAge() {
		return age;
	}

	public String getUsername() {
		return username;
	}

	public DataBean getDataBean() {
		return dataBean;
	}

	public Member getMember() {
		return member;
	}
	
	

}
