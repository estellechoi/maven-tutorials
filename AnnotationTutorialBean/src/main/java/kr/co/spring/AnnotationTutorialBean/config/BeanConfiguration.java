package kr.co.spring.AnnotationTutorialBean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.co.spring.AnnotationTutorialBean.beans.DataBean;
import kr.co.spring.AnnotationTutorialBean.beans.Member;
import kr.co.spring.AnnotationTutorialBean.beans.TestBean;
import kr.co.spring.AnnotationTutorialBean.beans.TestBean2;

@Configuration
public class BeanConfiguration {

	@Bean
	public TestBean testBeanAnt() {
		return new TestBean();
	}
		
	@Bean
	public DataBean dataBean() {
		return new DataBean();
	}
	
	@Bean
	public Member member1() {
		return new Member();
	}

	@Bean
	public Member member2() {
		return new Member();
	}

}
