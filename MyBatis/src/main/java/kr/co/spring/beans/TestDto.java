package kr.co.spring.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TestDto {

	// MyBatis 사용할 테이블의 컬럼 이름과 DTO 클래스의 변수명이 반드시 동일해야 한다. (@Select 어노테이션 사용시 별도의 매칭을 명시하지 않으려면)
	// 이전에는 Mapper 클래스로 어느 값이 어느 변수에 저장될지 직접 결정하였음.
	
	private int number;
	private String str;
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	
}
