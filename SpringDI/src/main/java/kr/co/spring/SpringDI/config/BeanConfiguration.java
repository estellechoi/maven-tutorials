package kr.co.spring.SpringDI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import kr.co.spring.SpringDI.beans.Group;
import kr.co.spring.SpringDI.beans.Member;

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
	
}
