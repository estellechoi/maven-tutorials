package kr.co.spring.SpringDI.beans;

public class Member {

	private int age;
	private String email;
	private Group group;

	public Member() {
		
	}
	
	public Member(int age, String email, Group group) {
		this.age = age;
		this.email = email;
		this.group = group;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
