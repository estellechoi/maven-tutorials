package kr.co.spring.DependencyInjectionSet.main;

import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.DependencyInjectionSet.beans.DataBean;
import kr.co.spring.DependencyInjectionSet.beans.TestBean;

public class Main {

	public static void main(String[] args) {

		//	xml	 정보 로딩 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/spring/DependencyInjectionSet/config/beans.xml");
		
		// bean 호출
		// setter 를 통한 의존주입 실행 
		TestBean testBean = ctx.getBean("testBean", TestBean.class);
		
		// getter로 값 가져오기 
		// 가져온 값은 각각 String, int, DataBean 타입의 값/객체를 요소로 하는 Set타입 객체변수에 저장 
		Set<String> set = testBean.getSet();
		Set<Integer> integerSet = testBean.getIntegerSet();
		// 동일 id 의 bean 객체가 존재하여서 출력되는 bean요소의 개수를 보면 1 개가 적을 것.
		Set<DataBean> dataBeanSet = testBean.getDataBeanSet();
		
		// 값 출력 
		for (String str : set) {
			System.out.printf("set : %s\n", str);
		}
		for (int integers : integerSet) {
			System.out.printf("set : %d\n", integers);
		}
		for (DataBean dataBean : dataBeanSet) {
			System.out.printf("set : %s\n", dataBean);

		}
		ctx.close();
	}

}
