package kr.co.spring.DependencyInjection2.beans;

import java.util.List;

public class TestBean {

	private List<String> list;
	private List<Integer> integerList;
	private List<DataBean> dataBeanList;
	
	public List<DataBean> getDataBeanList() {
		return dataBeanList;
	}

	public void setDataBeanList(List<DataBean> dataBeanList) {
		this.dataBeanList = dataBeanList;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public List<Integer> getIntegerList() {
		return integerList;
	}

	public void setIntegerList(List<Integer> integerList) {
		this.integerList = integerList;
	}
	
	
	
	
}
