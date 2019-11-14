package kr.co.blog.members.dao;

import java.util.List;
import java.util.Map;

import kr.co.blog.members.Member;
import kr.co.blog.members.MemberCell;

public interface iMemberDao {
	
	void insert(String email, String pwd, String username, List<MemberCell> cells, boolean isAdult, String[] sports);
	Member select(String email, String pwd);
	Member[] update(Member member);
	Map<String, Member> delete(Member member);

}
