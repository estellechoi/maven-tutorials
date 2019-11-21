package kr.co.spring.SpringDI.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import kr.co.spring.SpringDI.beans.DataBean;
import kr.co.spring.SpringDI.beans.DataBean2;
import kr.co.spring.SpringDI.beans.Group;
import kr.co.spring.SpringDI.beans.Member;
import kr.co.spring.SpringDI.beans.TestBean;
import kr.co.spring.SpringDI.beans.TestBean2;

@Configuration
public class BeanConfiguration {

	@Bean
	@Lazy
	public Member member() {
//		Member member = new Member(27, "estele.choi@gmail.com", new Group());
//		return member;
		return new Member(27, "estele.choi@gmail.com", new Group());
	}
	
	@Bean
	@Lazy
	public Member member2() {
		Member member = new Member();
		member.setAge(23);
		member.setEmail("estele.choi@gmail.com");
		member.setGroup(new Group());
		
		return member;
		
	}
	
	// 자동주입 (Spring 5.1 부터 deprecated)
	@Bean
	public DataBean data1() {
		return new DataBean();
	}
	
	@Bean
	public DataBean data2() {
		return new DataBean();
	}
	
	@Bean
	public DataBean2 data11() {
		return new DataBean2();
	}


	// 이름이 같은 bean 객체를 찾아 자동 주입 
	@Bean(autowire= Autowire.BY_NAME)
	@Lazy
	public TestBean testBean() {
		return new TestBean();
	}

	// 타입이 같은 bean 객체를 찾아 자동 주입 
	// 동일 타입 bean 이 복수면, 오류 발생 
	@Bean(autowire= Autowire.BY_TYPE)
	@Lazy
	public TestBean2 testBean2() {
		return new TestBean2();
	}

	
}
