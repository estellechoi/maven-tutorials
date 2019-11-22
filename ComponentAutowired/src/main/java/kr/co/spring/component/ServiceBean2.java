package kr.co.spring.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceBean2 {

	private int age;
	private String user;
	private DataBean dataBean;
	private FlowBean flowBean;
	
	// 생성자를 통한 자동주입
	// 생성자 매개변수와 같은 클래스타입의 bean 객체들이 별도의 어노테이션 없이 자동 주입된다.
	
	// 생성자를 통한 자동주입 설정으로 메소드에 사용되던 @ Required(필수 주입 프로퍼티를 설정하는 어노테이션) 대체
	// @Required 는 spring ver 5 부터 deprecated
	public ServiceBean2(@Value("27") int age, @Value("youjin") String user, DataBean dataBean, FlowBean flowBean) {
		this.age = age;
		this.user = user;
		this.dataBean = dataBean;
		this.flowBean = flowBean;
	}
	
	
	public int getAge() {
		return age;
	}
	public String getUser() {
		return user;
	}
	public DataBean getDataBean() {
		return dataBean;
	}
	public FlowBean getFlowBean() {
		return flowBean;
	}
	
	
}
