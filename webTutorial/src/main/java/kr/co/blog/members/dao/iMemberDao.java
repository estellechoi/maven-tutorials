package kr.co.blog.members.dao;

import kr.co.blog.members.Member;

public interface iMemberDao {
	
	void insert(String email, String pwd, String username, String cell1, String cell2, String cell3);
	Member select(String email, String pwd);
	void update();
	void delete();

}
