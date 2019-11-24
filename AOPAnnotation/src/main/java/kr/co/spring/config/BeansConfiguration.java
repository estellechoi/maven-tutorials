package kr.co.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan(basePackages = { "kr.co.spring.component", "kr.co.spring.advisor" })
// @EnableAspectJAutoProxy : Advisor 클래스에 설정된 어노테이션을 분석하여 AOP 를 세팅한다.
@EnableAspectJAutoProxy
public class BeansConfiguration {

	
}
