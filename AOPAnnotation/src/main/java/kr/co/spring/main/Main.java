package kr.co.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.component.TestBean;
import kr.co.spring.config.BeansConfiguration;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/spring/config/beans.xml");
		TestBean testBeanXml = ctx.getBean(TestBean.class);
		try {
			testBeanXml.method1();
		} catch (Exception e) {

		}
		ctx.close();

		System.out.println("===============================================================");

		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(BeansConfiguration.class);
		TestBean testBean = ctx2.getBean(TestBean.class);

		try {
			testBean.method1();
		} catch (Exception e) {
//			e.printStackTrace();
		}

		ctx2.close();
	}

}
