package kr.co.spring.advisor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
// @Aspect : 이 클래스는 Advice 메소드들을 정의한 Advisor 클래스이다.
@Aspect
public class AdvisorClass {
	
	@Before("execution(* method1())")
	public void beforeMethod() {
		System.out.println("Before method 호출 ");
	}
	
	@After("execution(* method1())")
	public void afterMethod() {
		System.out.println("After method 호출");
	}
	
	@Around("execution(* method1())")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Around method 호출 : 관심 메소드 실행 전");
		Object result = pjp.proceed();
		System.out.println("Around method 호출 : 관심 메소드 실행 후");
		return result;
	}
	
	// 관심 메소드가 예외 발생 없이 정상 작동한 후 호출되는 메소드
	@AfterReturning("execution(* method1())")
	public void AfterReturningMethod() {
		System.out.println("After returning method 호출");
	}
	
	// 관심 메소드 동작중 예외 발생시 호출되는 메소드
	@AfterThrowing("execution(* method1())")
	public void AfterThrowing() {
		System.out.println("After throwing method 호출");
	}
}
