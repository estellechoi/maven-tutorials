package kr.co.spring.InitDestroy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import kr.co.spring.InitDestroy.beans.TestBean;

@Configuration
public class BeanConfiguration {

	@Bean(initMethod = "init", destroyMethod = "destroy")
	@Lazy
	public TestBean testBean() {
		TestBean testBean = new TestBean();
		return testBean;
	}
}
