package kr.co.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.spring.beans.TestBean;
import kr.co.spring.beans.TestBean2;
import kr.co.spring.config.BeanConfiguration;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		TestBean testBean = ctx.getBean("testBean", TestBean.class);
				
		System.out.println("-----------------------------------------------------");
		
		TestBean2 testBean2 = ctx.getBean("testBean2", TestBean2.class);
		
		// @Autowired @Qualifier("name") 로 자동주입 
		System.out.printf("testBean2.data : %s\n", testBean2.getData());
		// @Resource 로 변수명과 이름이 같은 bean 자동주입 
		System.out.printf("testBean2.sequence1 : %s\n", testBean2.getSequence1());
		// @Resource(name="name") 으로 변수명과 이름이 다른 bean 을 자동주입 
		System.out.printf("testBean2.sequence2 : %s\n", testBean2.getSequence2());
		
		// bean 객체 소멸 
		ctx.close();
	}

}
