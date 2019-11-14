package kr.co.blog.members.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import kr.co.blog.members.Member;
import kr.co.blog.members.MemberCell;

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
	public void insert(String email, String pwd, String username, List<MemberCell> cells, boolean isAdult, String[] sports) {
		// DTO 객체의 각 변수에 값 주기
		// -> 컨트롤러에서 커맨드 객체를 사용하여 대체 (매개변수로 DTO 객체 사용)
		Member member = new Member();
//		member.setEmail(email);
//		member.setPwd(pwd);
//		member.setUsername(username);

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
	public Member[] update(Member member) {
		
		Member members[] = new Member[2];
		// 이전 레코드 
		members[0] = dbMap.get(member.getEmail());
		
		// 수정 후 레코드 
		dbMap.put(member.getEmail(), member);
		members[1] = dbMap.get(member.getEmail());
		
		return members;
	}

	@Override
	public Map<String, Member> delete(Member member) {
		// DB 에서 key 값으로 레코드 삭제 
		dbMap.remove(member.getEmail());
		// 레코드가 삭제된 DB 객체 리턴 
		return dbMap;
	}

}
