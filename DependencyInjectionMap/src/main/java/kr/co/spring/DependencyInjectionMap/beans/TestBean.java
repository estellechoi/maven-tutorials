package kr.co.spring.DependencyInjectionMap.beans;

import java.util.Map;
import java.util.Properties;

public class TestBean {

	// Java 에서는 모든 클래스가 Object 클래스를 직/간접적으로 상속받고 있다.
	private Map<String, Object> map;
	
	// Properties : String 값들만 요소로 하는 클래스 
	private Properties pro;

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Properties getPro() {
		return pro;
	}

	public void setPro(Properties pro) {
		this.pro = pro;
	}
	
	
}
