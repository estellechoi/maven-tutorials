package kr.co.spring.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceBean3 {

	private int age;
	private String user;
	private DataBean dataBean;
	private FlowBean flowBean;
	
	// 생성자를 통한 자동주입
	// 생성자 매개변수와 같은 클래스타입의 bean 객체들이 별도의 어노테이션 없이 자동 주입된다.
	
	public ServiceBean3(int age, String user, DataBean dataBean, FlowBean flowBean) {
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
