package kr.co.spring.DependencyInjectionSet.beans;

import java.util.Set;

public class TestBean {

	// Set<E> 의 특징 
	// 1) 중복 데이터를 허용하지 않는다. 
	private Set<String> set;
	private Set<Integer> integerSet;
	private Set<DataBean> dataBeanSet;
	
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public Set<Integer> getIntegerSet() {
		return integerSet;
	}
	public void setIntegerSet(Set<Integer> integerSet) {
		this.integerSet = integerSet;
	}
	public Set<DataBean> getDataBeanSet() {
		return dataBeanSet;
	}
	public void setDataBeanSet(Set<DataBean> dataBeanSet) {
		this.dataBeanSet = dataBeanSet;
	}
	
	
}
