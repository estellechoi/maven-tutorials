package kr.co.spring.AnnotationTutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import kr.co.spring.AnnotationTutorial.beans.TestBean;
import kr.co.spring.AnnotationTutorial.beans.TestBean2;
import kr.co.spring.AnnotationTutorial.beans.TestBean3;
import kr.co.spring.AnnotationTutorial.beans.TestBean4;

// @Configuration : 이 자바파일은 bean 을 정의하는 파일이다. (xml 파일을 대체한다)
@Configuration
public class BeanConfiguration {

	// @Bean : bean 정의한다.
	@Bean
	public TestBean test1() {		
		// bean 객체 생성하고 주소값을 반환 
		TestBean testBean1 = new TestBean();
		return testBean1;
	}

	@Bean(name = "test1000")
	public TestBean test500() {		
		// bean 객체 생성하고 주소값을 반환 
		TestBean testBean1 = new TestBean();
		return testBean1;
	}
	
	@Bean
	@Lazy
	public TestBean2 test600() {
		TestBean2 testBean2 = new TestBean2();
		return testBean2;
	}

	@Bean
	@Scope("prototype") // scope = prototype 설정 
	public TestBean3 test700() {
		TestBean3 testBean3 = new TestBean3();
		return testBean3;
	}

	// TestBean4 타입 객체를 반환하는 메소드가 복수일 때, id 값 (메소드명)을 사용하지 않고 하나의 bean 주소값을 받아오려면 ?
	// @Primary 지정된 객체를 호출한다 .
	@Bean
	@Primary
	public TestBean4 testBean4_1() {		
		// bean 객체 생성하고 주소값을 반환 
		TestBean4 testBean = new TestBean4();
		return testBean;
	}

	@Bean
	public TestBean4 TestBean4_2() {		
		// bean 객체 생성하고 주소값을 반환 
		TestBean4 testBean = new TestBean4();
		return testBean;
	}

	
	
}
