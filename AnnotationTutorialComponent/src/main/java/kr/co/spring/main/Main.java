package kr.co.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.beans.DataBean;
import kr.co.spring.beans.TestBean;
import kr.co.spring.component.Bean1;
import kr.co.spring.component.Bean2;
import kr.co.spring.component2.Bean3;
import kr.co.spring.config.BeanConfiguration;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/spring/config/beans.xml");

		// TestBean 타입의 bean을 호출
		TestBean testBean = ctx.getBean(TestBean.class);
		System.out.printf("testBean : %s\n", testBean);

		// DataBean 타입의 bean 이 2 개 이상이므로, bean 의 이름을 통해 호출
		DataBean dataBean1 = ctx.getBean("dataBean1", DataBean.class);
		System.out.printf("dataBean1 : %s\n", dataBean1);

		DataBean dataBean2 = ctx.getBean("dataBean2", DataBean.class);
		System.out.printf("dataBean2 : %s\n", dataBean2);

		System.out.println("-----------------------------------------------------------------------");
		
		// @Component 로 등록한 bean 호출 (타입을 통해 호출 가능)
		Bean1 bean1 = ctx.getBean(Bean1.class);
		System.out.printf("bean1 : %s\n", bean1);

		System.out.println("-----------------------------------------------------------------------");
		
		// @Component("name") 로 등록한 bean 호출 (이름을 통해 호출 가능)
		Bean2 beanName = ctx.getBean("beanName", Bean2.class);
		System.out.printf("beanName : %s\n", beanName);

		System.out.println("-----------------------------------------------------------------------");
		
		// @Component("name") 로 bean 등록한 클래스 타입의 bean 을 더 만들고 싶다.
		// xml 혹은 @Configuration 파일에서 직접 등록 -> @Component 로 등록한 bean 과 양립 가능 
		Bean2 bean2 = ctx.getBean("bean2", Bean2.class);
		System.out.printf("bean2 : %s\n", bean2);

		System.out.println("-----------------------------------------------------------------------");
		
		// @Component 로 등록한 bean 호출 (타입을 통해 호출 가능)
		Bean3 bean3 = ctx.getBean(Bean3.class);
		System.out.printf("bean3 : %s\n", bean3);

		
		
		
		
		ctx.close();

		System.out.println("=======================================================================");

		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(BeanConfiguration.class);

		// TestBean 타입의 bean 호출
		TestBean testBeanAnt = ctx2.getBean(TestBean.class);
		System.out.printf("testBeanAnt : %s\n", testBeanAnt);

		// DataBean 타입의 bean 이 2 개 이상이므로, bean 의 이름을 통해 호출
		DataBean dataBeanAnt1 = ctx2.getBean("dataBean1", DataBean.class);
		System.out.printf("dataBeanAnt1 : %s\n", dataBeanAnt1);

		DataBean dataBeanAnt2 = ctx2.getBean("dataBean2", DataBean.class);
		System.out.printf("dataBeanAnt2 : %s\n", dataBeanAnt2);

		System.out.println("-----------------------------------------------------------------------");
		
		// @Component 로 등록한 bean 호출 (타입을 통해 호출 가능)
		Bean1 beanAnt1 = ctx2.getBean(Bean1.class);
		System.out.printf("beanAnt1 : %s\n", beanAnt1);

		System.out.println("-----------------------------------------------------------------------");
		
		// @Component("name") 로 등록한 bean 호출 (이름을 통해 호출 가능)
		Bean2 beanNameAnt = ctx2.getBean("beanName", Bean2.class);
		System.out.printf("beanNameAnt : %s\n", beanNameAnt);

		System.out.println("-----------------------------------------------------------------------");
		
		// @Component("name") 로 bean 등록한 클래스 타입의 bean 을 더 만들고 싶다.
		// xml 혹은 @Configuration 파일에서 직접 등록 -> @Component 로 등록한 bean 과 양립 가능 
		Bean2 beanAnt2 = ctx2.getBean("bean2", Bean2.class);
		System.out.printf("beanAnt2 : %s\n", beanAnt2);

		System.out.println("-----------------------------------------------------------------------");
		
		// @Component 로 등록한 bean 호출 (타입을 통해 호출 가능)
		Bean3 beanAnt3 = ctx2.getBean(Bean3.class);
		System.out.printf("beanAnt3 : %s\n", beanAnt3);

		ctx2.close();
	}

}
