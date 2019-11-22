package kr.co.spring.advisor;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdvisorClass {

	public void before() {
		System.out.println("before");
	}

	public void after() {
		System.out.println("after");
	}


	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("around1");

		// 원래 메소드 호출
		// 원래 메소드를 호출함으로써 around 메소드 내의 코드들이 언제 실행될지 정해준다.
		// * Java 에서는 모든 객체가 Object 를 상속받고 있으므로, 모든 타입의 객체/값을 Object 타입의 변수에 저장할 수 있다 !
		Object obj = pjp.proceed();
		
		System.out.println("around2");
		
		return obj;
	}
	
	// 관심 메소드 호출시 Exeption 발생하면, afterReturning 메소드는 호출되지 않는다.
	// 예외 없이 정상 작동 했을 때만 호출되는 메소드 
	public void afterReturning() {
		System.out.println("after returning : 관심 메소드가 예외 발생 없이 정상 작동하였습니다.");
	}
	
	// 관심 메소드 작동중 예외 발생 시 , 예외 관련 객체가 매개변수로 자동주입된다.
	public void afterThrowing(Throwable e) {
		System.out.println("after Throwing : 관심 메소드 작동 중 예외가 발생하였습니다.");
		System.out.println(e);
	}
}
