package kr.co.spring.AnnotationTutorialBean.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.AnnotationTutorialBean.beans.TestBean;
import kr.co.spring.AnnotationTutorialBean.beans.TestBean2;
import kr.co.spring.AnnotationTutorialBean.config.BeanConfiguration;

public class Main {

	public static void main(String[] args) {

		// 1) xml
		ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("kr/co/spring/AnnotationTutorialBean/config/beans.xml");
		
		TestBean testBean = ctx1.getBean("testBean", TestBean.class);
		System.out.printf("testBean.data : %d\n", testBean.getData());
		System.out.printf("testBean.dataBean : %s\n", testBean.getDataBean());
		System.out.printf("testBean.member : %s\n", testBean.getMember());
		System.out.printf("testBean.staffMember : %s\n", testBean.getStaffMember());
		
		System.out.println("----------------------------------------------------------");

		TestBean2 testBean2 = ctx1.getBean("testBean2", TestBean2.class);
		System.out.printf("testBean2.age : %d\n", testBean2.getAge());
		System.out.printf("testBean2.username : %s\n", testBean2.getUsername());
		System.out.printf("testBean2.dataBean : %s\n", testBean2.getDataBean());
		System.out.printf("testBean2.member : %s\n", testBean2.getMember());
		
		
		ctx1.close();
		
	
		
		System.out.println("==========================================================");
		// 2) @configuration class
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(BeanConfiguration.class);

		TestBean testBeanAnt = ctx2.getBean("testBeanAnt", TestBean.class);
		System.out.printf("testBeanAnt.data : %d\n", testBeanAnt.getData());
		System.out.printf("testBeanAnt.dataBean : %s\n", testBeanAnt.getDataBean());
		System.out.printf("testBeanAnt.member : %s\n", testBeanAnt.getMember());
		System.out.printf("testBeanAnt.staffMember : %s\n", testBeanAnt.getStaffMember());

		System.out.println("----------------------------------------------------------");
		
		
		
		ctx2.close();
	}

}
