package kr.co.spring.SpringDI.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.spring.SpringDI.beans.Member;

public class MainXml {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/spring/SpringDI/config/beans.xml");
		
		// bean 호출 
		// 생성자 실행
		// 1) 생성자를 통한 주입 
		Member member = ctx.getBean("member", Member.class);

		// 값 불러오기 
		System.out.printf("member.age : %d\n", member.getAge());
		System.out.printf("member.email : %s\n", member.getEmail());
		System.out.printf("member.group : %s\n", member.getGroup());
		
		System.out.println("-------------------------------------------------------");
		
		// 2) setter() 메소드를 통한 주입 
		Member member2 = ctx.getBean("member2", Member.class);

		// 값 불러오기 
		System.out.printf("member2.age : %d\n", member2.getAge());
		System.out.printf("member2.email : %s\n", member2.getEmail());
		System.out.printf("member2.group : %s\n", member2.getGroup());
		
		
		
		ctx.close();
	}

}
