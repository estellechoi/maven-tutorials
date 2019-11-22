package kr.co.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.co.spring.component.DataBean;
import kr.co.spring.component.FlowBean;
import kr.co.spring.component.NameBean;
import kr.co.spring.component.ServiceBean3;

@Configuration
@ComponentScan(basePackages = "kr.co.spring.component")
public class BeanConfiguration {

	@Bean
	public NameBean name2() {
		return new NameBean();
	}
	
	
	// ServiceBean3 의 bean 을 여러개 등록하자.
	@Bean
	public ServiceBean3 serviceBean3() {
		// ServiceBean3 클래스에서 생성자의 매개변수를 통해 필수로 주입할 프로퍼티를 설정하였다. 
		return new ServiceBean3(24, "youyoung", new DataBean(), new FlowBean());
	}
}
