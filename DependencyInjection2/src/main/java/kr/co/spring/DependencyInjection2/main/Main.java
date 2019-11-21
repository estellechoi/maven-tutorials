package kr.co.spring.DependencyInjection2.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.DependencyInjection2.beans.DataBean;
import kr.co.spring.DependencyInjection2.beans.TestBean;

public class Main {

	public static void main(String[] args) {

		// xml 정보 로딩
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"kr/co/spring/DependencyInjection2/config/beans.xml");

		// bean 호출 (setter를 통해 List<String> 객체 의존주입)
		TestBean testBean = ctx.getBean("testBean", TestBean.class);

		// TestBean 변수에 들어간 값 확인
		List<String> list = testBean.getList();
		List<Integer> integerList = testBean.getIntegerList();
		List<DataBean> dataBeanList = testBean.getDataBeanList();

		// 컬렉션 객체의 요소를 하나씩 변수에 저장하여 for문 실행
		for (String str : list) {
			System.out.printf("list : %s\n", str);
		}
		for (int integers : integerList) {
			System.out.printf("list : %d\n", integers);
		}
		for (DataBean obj : dataBeanList) {
			System.out.printf("list : %s\n", obj);
		}
		
		// 컨테이너 종료 
		ctx.close();
	}

}
