package kr.co.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.spring.component.ServiceBean;
import kr.co.spring.component.ServiceBean2;
import kr.co.spring.component.ServiceBean3;
import kr.co.spring.config.BeanConfiguration;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		// bean 호출
		ServiceBean service = ctx.getBean(ServiceBean.class);

		// 주입여부 확인
		System.out.printf("service.dataBean : %s\n", service.getDataBean());
		System.out.printf("service.flowBean : %s\n", service.getFlowBean());
		System.out.printf("service.nameBean : %s\n", service.getNameBean());
		System.out.printf("service.nameBean2 : %s\n", service.getNameBean2());

		System.out.println("----------------------------------------------------------");
		
		// bean 호출 
		ServiceBean2 service2 = ctx.getBean(ServiceBean2.class);
		
		// 주입여부 확인 
		
		// @Value("value") 로 해당 클래스의 생성자 코딩시 직접 주입 
		System.out.printf("service2.age : %d\n", service2.getAge());
		System.out.printf("service2.user : %s\n", service2.getUser());
		
		// 생성자 매개변수의 클래스타입과 동일한 bean 자동주입 
		System.out.printf("service2.dataBean : %s\n", service2.getDataBean());
		System.out.printf("service2.flowBean : %s\n", service2.getFlowBean());

		
		System.out.println("----------------------------------------------------------");
	
		
		// serviceBean3
		// bean 호출 
		ServiceBean3 serviceBean3 = ctx.getBean("serviceBean3", ServiceBean3.class);
		
		// 주입여부 확인 
		
		// @Configuration 파일에서 @Bean 등록시, 생성자를 통해 필수 프로퍼티를 주입하였다.
		System.out.printf("serviceBean3.age : %d\n", serviceBean3.getAge());
		System.out.printf("serviceBean3.user : %s\n", serviceBean3.getUser());
		System.out.printf("serviceBean3.dataBean : %s\n", serviceBean3.getDataBean());
		System.out.printf("serviceBean3.flowBean : %s\n", serviceBean3.getFlowBean());
		
		ctx.close();
	}

}
