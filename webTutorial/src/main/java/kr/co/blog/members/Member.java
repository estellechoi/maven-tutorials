package kr.co.blog.members;

import java.util.List;

public class Member {
	
	private String email;
	private String pwd;
	private String username;
	
	// MemberCell 객체로 구성된 List 타입 변수 
	private List<MemberCell> cells;
	
	private boolean isAdult;
	private String[] sports;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<MemberCell> getCells() {
		return cells;
	}
	public void setCells(List<MemberCell> cells) {
		this.cells = cells;
	}
	public boolean getIsAdult() {
		return isAdult;
	}
	public void setIsAdult(boolean isAdult) {
		this.isAdult = isAdult;
	}
	public String[] getSports() {
		return sports;
	}
	public void setSports(String[] sports) {
		this.sports = sports;
	}
	
	
	
	
}
