package first;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
//		Test test = new Test();
//		test.go();
		
		// 스프링 설정파일 applicationContext.xml 에서 만든 빈 객체 사용하기 
		// 매개변수로 빈 객체를 생성한 파일명을 넣어준다 
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// getBean(빈id, 빈을 담을 자료형) 메소드로 객체 불러오기 
		Test test = ctx.getBean("test", Test.class);
		test.go();
		
		InjectionBean injectionBean = ctx.getBean("injectionBean", InjectionBean.class);
		DependencyBean dependencyBean1 = ctx.getBean("dependencyBean", DependencyBean.class);
		DependencyBean dependencyBean2 = ctx.getBean("dependencyBean", DependencyBean.class);
		
		injectionBean.inject();
		
		// 싱글톤과 프로토타입 빈을 비교 
		if (dependencyBean1.equals(dependencyBean2)) {
			// 싱글톤 (빈을 참조할 때) 
			System.out.println("same");
		}
		else {
			// 프로토타입 (빈 객체를 생성하여 사용할 때)
			System.out.println("not same");
		}
		
		ctx.close();
		
		// 스프링 설정파일 다수를 참조할 때 (배열)
		String xmls[] = {"classpath:applicationContext.xml", "classpath:applicationDB.xml"};
		GenericXmlApplicationContext ctxs = new GenericXmlApplicationContext(xmls);
		
		ctxs.close();
	}

}
