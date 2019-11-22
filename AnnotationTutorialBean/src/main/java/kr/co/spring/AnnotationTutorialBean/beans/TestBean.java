package kr.co.spring.AnnotationTutorialBean.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class TestBean {

	private int data;
	private DataBean dataBean;
	
	// 객체 자동 주입 - 변수에 설정하는 경우 
	// 자동으로 setter() 메소드가 추가되어, setter() 를 통해 주입 받는다.
	// setter() 메소드는 코딩할 필요 없다. (값 확인을 위해 getter() 만 코딩하였음)
	// @Qualifier : 같은 타입 bean이 여러개일 때, 이름이 일치하는 bean을 찾아 자동 주입한다.
	@Autowired
	@Qualifier("member1")
	private Member member;
	
	// (required = false) : 해당하는 bean 이 없으면 주입하지 않아도 된다.
	@Autowired(required = false)
	@Qualifier("member3") // 존재하지 않는 bean 이름 
	private Member staffMember;
	

	// 기본생성자(매개변수 없는)가 없다.
	// -> 매개변수 int 값 1 개를 주입하지 않으면 이 객체를 생성할 수 없다. (@Required 대체 권장)
	/*
	public TestBean(int data) {
		this.data = data;
	}
	*/
	
	
	public int getData() {
		return data;
	}

	// @Required : 해당 메소드를 반드시 값/객체를 주입해야 하는 프로퍼티로 설정 (spring 5.1 부터 deprecated)
	// 프로퍼티 ???? 
	// xml 파일 설정에만 영향 있다. spring 5.0 이하 버전 
	// -> setData 프로퍼티에는 반드시 int 값 1 개를 주입해야 한다.
	@Required
	public void setData(int data) {
		this.data = data;
	}

	
	public DataBean getDataBean() {
		return dataBean;
	}

	// 객체 자동 주입  - setter() 메소드에 설정하는 경우 
	// 정의된 bean 중 타입이 DataBean 인 객체를 찾아 자동 주입 
	@Autowired
	public void setDataBean(DataBean dataBean) {
		this.dataBean = dataBean;
	}

	public Member getMember() {
		return member;
	}

	public Member getStaffMember() {
		return staffMember;
	}
	
	
	
}
