package kr.co.spring.XmlTutorial.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.XmlTutorial.beans.CreateBean;

public class MainCreateBean {

	public static void main(String[] args) {
		
		// bean configuration file 정보 로딩 및 객체 생성 (<bean> 의 속성 중 lazy-init = "false" 인 것만, 생략시 디폴트)
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/spring/XmlTutorial/config/beans.xml");
		
		// id 가 createBean인 bean의 주소값 호출 
		CreateBean createBean = ctx.getBean("createBean", CreateBean.class);
		System.out.printf("createBean : %s\n", createBean);
		
		// lazy-init = "true" 이므로, getBean() 메소드로 bean의 주소값 호출시 객체 생성 (싱글톤)
		CreateBean createBean2 = ctx.getBean("createBeanLazyInit", CreateBean.class);
		System.out.printf("createBeanLazyInit : %s\n", createBean2);
		
		// 싱글톤 : 다시 bean 주소값을 호출해도 객체가 생성되지 않는다.
		CreateBean createBean3 = ctx.getBean("createBeanLazyInit", CreateBean.class);
		System.out.printf("createBeanLazyInit : %s\n", createBean3);
		
		// 프로토타입 : bean 주소값 호출할 때마다 객체 생성
		// xml 정보 로딩시 객체 생성 X
		CreateBean createBean4 = ctx.getBean("createBeanPrototype", CreateBean.class);
		System.out.printf("createBeanPrototype : %s\n", createBean4);
		
		// scope="prototype" 이므로, bean 호출할 때마다 객체 또 생성 
		CreateBean createBean5 = ctx.getBean("createBeanPrototype", CreateBean.class);
		System.out.printf("createBeanPrototype : %s\n", createBean5);

		
		
		ctx.close();
	}

}
