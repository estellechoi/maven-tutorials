package kr.co.spring.DependencyInjectionMap.main;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.DependencyInjectionMap.beans.DataBean;
import kr.co.spring.DependencyInjectionMap.beans.TestBean;

public class Main {

	public static void main(String[] args) {

		// xml 설정정보 로딩 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/spring/DependencyInjectionMap/config/beans.xml");

		// bean 호출 
		// setter 를 통한 의존 주입 실행 
		TestBean testBean = ctx.getBean("testBean", TestBean.class);
		
		// getter 로 값 불러오기 
		// 불러온 값은 Map 타입 객체 
		Map<String, Object> map = testBean.getMap();
		
		// Map 타입 객체에서 key 값으로 각 요소의 값을 불러오기 
		String key1 = (String) map.get("key1");
		int key2 = (Integer) map.get("key2");
		DataBean key3 = (DataBean) map.get("key3");
		DataBean key4 = (DataBean) map.get("key4");
		List<String> key5 = (List<String>) map.get("key5");
		
		// 변수에 저장된 각 요소를 출력하기 
		System.out.printf("key1 : %s\n", key1);
		System.out.printf("key2 : %d\n", key2);
		System.out.printf("key3 : %s\n", key3);
		System.out.printf("key4 : %s\n", key4);
		for (String str : key5) {
			System.out.printf("key5 : %s\n", str);
		}
		
		System.out.println("----------------------------");
	
		// getter로 값 불러오기 
		// 불러온 값은 Properties 타입 객체
		Properties pro = testBean.getPro();
		
		// Properties 타입 객체에서 key 값으로 각 요소의 값 불러오기 
		String prop1 = pro.getProperty("prop1");
		String prop2 = pro.getProperty("prop2");
		String prop3 = pro.getProperty("prop3");
		// 출력 
		System.out.printf("%s\n", prop1);
		System.out.printf("%s\n", prop2);
		System.out.printf("%s\n", prop3);

		ctx.close();
	}

}
