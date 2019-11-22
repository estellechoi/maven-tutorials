package kr.co.spring.beans;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TestBean2 {

	@Autowired
	@Qualifier("data")
	private Data data;

	// 변수명과 동일한 이름의 bean 자동주입 (Autowired + Qualifier 기능)
	@Resource
	private Sequence sequence1;
	
	// 변수명과 다른 이름의 bean 자동주입 설정을 위해 (name = "name") 속성 사용 
	@Resource(name = "sequence1")
	private Sequence sequence2;
	
	
	
	public Sequence getSequence2() {
		return sequence2;
	}
	public Data getData() {
		return data;
	}
	public Sequence getSequence1() {
		return sequence1;
	}
	
	
}
