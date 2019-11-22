package kr.co.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.co.spring.beans.DataBean;
import kr.co.spring.beans.TestBean;
import kr.co.spring.component.Bean2;

@Configuration
// 지정된 package 내의 클래스들의 어노테이션을 분석하도록 설정한다.
@ComponentScan(basePackages = {"kr.co.spring.component", "kr.co.spring.component2"})
//@ComponentScan(basePackages = "kr.co.spring.component2")
public class BeanConfiguration {


	@Bean
	public TestBean testBean() {
		return new TestBean();
	}

	@Bean
	public DataBean dataBean1() {
		return new DataBean();
	}

	@Bean
	public DataBean dataBean2() {
		return new DataBean();
	}
	
	// @component 로 아래 타입의 bean 을 등록했지만, 같은 타입 bean 을 더 만들고 싶다.
	// -> xml 혹은 @Configuration 파일에서 직접 등록 
	@Bean
	public Bean2 bean2() {
		return new Bean2();
	}

}
