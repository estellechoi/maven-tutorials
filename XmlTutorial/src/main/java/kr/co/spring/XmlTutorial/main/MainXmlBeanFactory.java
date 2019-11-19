package kr.co.spring.XmlTutorial.main;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import kr.co.spring.XmlTutorial.beans.TestBean;

public class MainXmlBeanFactory {

	public static void main(String[] args) {

//		testBeanFactory();
		testBeanFactoryOutside();
	}
	
	// 1) 스프링 설정파일 (xml) 이 패키지 내부에 있을 때 (src/main/java/)
	public static void testBeanFactory() {
		
		// 스프링 설정파일 로딩 
		// XmlBeanFactory 는 xml 설정 정보는 즉시 로딩하지만, Bean 객체를 미리 생성하지 않는다.
		// 객체를 생성하지 않으므로, 생성자가 실행되지 않는다.
		ClassPathResource resource = new ClassPathResource("kr/co/spring/XmlTutorial/config/beans.xml");
		XmlBeanFactory beanFactory = new XmlBeanFactory(resource); // 스프링 버전 4 부터 지원 X	
		
		// getBean() 메소드로 bean 의 주소값을 호출할 때 bean 객체를 생성한다.
		TestBean testBean = beanFactory.getBean("testBean1", TestBean.class);
		System.out.printf("testBean : %s\n", testBean); // 객체 정보 출력
		
		// 위에서 처음 bean 호출 시 생성한 bean 객체는 컨테이너에서 보관하고 있으므로, 여기서는 bean 객체롤 다시 생성하지 않는다. 
		TestBean testBean2 = beanFactory.getBean("testBean1", TestBean.class);
		System.out.printf("testBean : %s\n", testBean);
	}
	
	// 2) 스프링 설정파일이 패키지 외부에 있을 때 
	public static void testBeanFactoryOutside() {
		// 스프링 설정파일 로딩 
		FileSystemResource resource = new FileSystemResource("beans.xml");
		XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
		
		// bean 주소값 호출 (이때 bean 객체 생성)
		TestBean testBean = beanFactory.getBean("testBean2", TestBean.class);
		System.out.printf("testBean : %s\n", testBean); // 객체 정보 출력
		
	}

}
