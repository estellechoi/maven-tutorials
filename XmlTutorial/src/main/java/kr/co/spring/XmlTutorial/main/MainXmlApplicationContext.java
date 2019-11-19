package kr.co.spring.XmlTutorial.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import kr.co.spring.XmlTutorial.beans.TestBean;

public class MainXmlApplicationContext {

	public static void main(String[] args) {
		testApplicationContext();
//		testApplicationContextOutside();
	}
	
	// 1) 스프링 설정파일이 패키지 내부에 있을 때 (src/main/java/)
	public static void testApplicationContext() {
		
		// 스프링 설정파일 로딩
		// ApplicationContext 는 xml 설정 정보를 즉시 로딩하고, 동시에 Bean 객체를 미리 생성하여 컨테이너에 보관한다. (디폴트)
		// 객체를 생성하므로, 객체가 생성된 클래스들의 생성자가 실행된다.
		// * 참고 : XmlBeanFactory 는 xml 설정 정보는 즉시 로딩하지만, Bean 객체를 미리 생성하지 않는다.
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/spring/XmlTutorial/config/beans.xml");
		
		// 컨테이너가 미리 생성하여 보관하고 있는 bean 의 주소값 호출 
		TestBean testBean = ctx.getBean("testBean1", TestBean.class);
		System.out.printf("testBean : %s\n", testBean);
		
		TestBean testBean2 = ctx.getBean("testBean1", TestBean.class);
		System.out.printf("testBean : %s\n", testBean);
		
		// 닫아주는 이유 ?
		ctx.close();
	}

	// 2) 스프링 설정파일이 패키지 외부에 있을 때 
	public static void testApplicationContextOutside() {
		// 스프링 설정파일 로딩
		// xml 설정 정보를 즉시 로딩하고, 동시에 bean 객체를 생성하여 컨테이너에 보관 (디폴트)
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		
		TestBean testBean = ctx.getBean("testBean2", TestBean.class);
		System.out.printf("testBean : %s\n", testBean);
		
		ctx.close();
	}
}
