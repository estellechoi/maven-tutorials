package kr.co.spring.AutoWire.beans;

public class TestBeanCons {

	private int integerData;
	private String stringData;
	private Group group1;
	private Group group2;
	
	// constructor
	public TestBeanCons(Group group1, Group group2) {
		this.group1 = group1;
		this.group2 = group2;
	}
	public TestBeanCons(int integerData, String stringData, Group group1, Group group2) {
		this.integerData = integerData;
		this.stringData = stringData;
		this.group1 = group1;
		this.group2 = group2;
	}
	
	
	
	
	// getters and setters

	public int getIntegerData() {
		return integerData;
	}
	public void setIntegerData(int integerData) {
		this.integerData = integerData;
	}
	public String getStringData() {
		return stringData;
	}
	public void setStringData(String stringData) {
		this.stringData = stringData;
	}
	public Group getGroup1() {
		return group1;
	}
	public void setGroup1(Group group1) {
		this.group1 = group1;
	}
	public Group getGroup2() {
		return group2;
	}
	public void setGroup2(Group group2) {
		this.group2 = group2;
	}

}
