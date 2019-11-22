package kr.co.spring.component;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ServiceBean {

	@Autowired
	private DataBean dataBean;

	@Autowired
	@Qualifier("flow")
	private FlowBean flowBean;

	// (name = "name") 속성 없다면 변수와 이름이 같은 bean 자동주입
	// NameBean.java 에서 @Component("name") 으로 설정
	@Resource(name = "name")
	private NameBean nameBean;

	// @Configuration 파일에서 @Bean 으로 설정
	@Resource(name = "name2")
	private NameBean nameBean2;

	public DataBean getDataBean() {
		return dataBean;
	}

	public FlowBean getFlowBean() {
		return flowBean;
	}

	public NameBean getName() {
		return nameBean;
	}

	public NameBean getNameBean() {
		return nameBean;
	}

	public NameBean getNameBean2() {
		return nameBean2;
	}

}
