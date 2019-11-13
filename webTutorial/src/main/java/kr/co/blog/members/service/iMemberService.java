package kr.co.blog.members.service;

import kr.co.blog.members.Member;

public interface iMemberService {

	void register(String email, String pwd, String username, String cell1, String cell2, String cell3);
	Member select(String email, String pwd); // 리턴 메소드 
	void update();
	void delete();
}
