package kr.co.blog.members.service;

import java.util.List;

import kr.co.blog.members.Member;
import kr.co.blog.members.MemberCell;

public interface iMemberService {

	void register(String email, String pwd, String username, List<MemberCell> cells, boolean isAdult, String[] sports);
	Member select(String email, String pwd); // 리턴 메소드 
	Member[] edit(Member member);
	void remove(Member member);
}
