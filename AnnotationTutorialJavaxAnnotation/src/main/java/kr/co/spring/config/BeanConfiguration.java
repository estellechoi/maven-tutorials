package kr.co.spring.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import kr.co.spring.beans.Data;
import kr.co.spring.beans.Sequence;
import kr.co.spring.beans.TestBean;
import kr.co.spring.beans.TestBean2;

@Configuration
public class BeanConfiguration {

//	@Bean(initMethod = "init", destroyMethod = "destroy")
	@Bean
	@Lazy
	public TestBean testBean() {
		return new TestBean();
	}
	
//	@Bean(autowire=Autowire.BY_NAME)
	@Bean
	public TestBean2 testBean2() {
		return new TestBean2();
	}
	
	@Bean
	public Data data() {
		return new Data();
	}
	
	@Bean
	public Sequence sequence1() {
		return new Sequence();
	}
}
