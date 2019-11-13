package kr.co.blog.members.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.co.blog.members.Member;

// 이 클래스를 스프링컨테이너에 빈 객체로 생성한다. 
@Component
//@Repository
public class MemberDao implements iMemberDao {

	// DB 연결 대체 
	// <email 문자열, Member 객체> 
	private HashMap<String, Member> dbMap;
	
	// 생성자 
	public MemberDao() {
		// Map 객체 생성 
		dbMap = new HashMap<String, Member>();
	}

	@Override
	public void insert(String email, String pwd, String username, String cell1, String cell2, String cell3) {
		// DTO 객체의 각 변수에 값 주기 
		Member member = new Member();
		member.setEmail(email);
		member.setPwd(pwd);
		member.setUsername(username);
		member.setCell(cell1 + "-" + cell2 + "-" + cell3);

		// dbMap 에 데이터 추가 (key, value)
		dbMap.put(email, member);
		
		// dnMap 의 키만 모아서 keys 객체에 담기 
		Set<String> keys = dbMap.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			Member memberRecord = dbMap.get(key);
			
		}
	}

	@Override
	public Member select(String email, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}
