package first;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
//		Test test = new Test();
//		test.go();
		
		// applicationContext.xml 에서 만든 빈 객체 사용하기 
		// 매개변수로 빈 객체를 생성한 파일명을 넣어준다 
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// getBean(빈id, 빈을 담을 자료형) 메소드로 객체 불러오기 
		Test test = ctx.getBean("test", Test.class);
		test.go();
		
		ctx.close();
	}

}
