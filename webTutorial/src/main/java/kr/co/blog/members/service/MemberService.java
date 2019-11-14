package kr.co.blog.members.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.blog.members.Member;
import kr.co.blog.members.MemberCell;
import kr.co.blog.members.dao.MemberDao;

// 이 클래스를 스프링컨테이너에 빈 객체로 생성한다. (스프링설정파일에서 bean 태그로 생성할 필요 X)
@Service
// 아래의 어노테이션들로 대체할 수 있다. 
//@Component
//@Repository
public class MemberService implements iMemberService {
	
	// 컨테이너에서 동일타입(MemberDao) 빈 객체 호출
	// MemberDao 클래스 파일에서 @Component 어노테이션으로 빈 객체 생성하였음. 
	@Autowired
	MemberDao memberDao;

	@Override
	public void register(String email, String pwd, String username, List<MemberCell> cells, boolean isAdult, String[] sports) {
		
		memberDao.insert(email, pwd, username, cells, isAdult, sports);
	}

	@Override
	public Member select(String email, String pwd) {
		
		Member member = memberDao.select(email, pwd);
		
		return member;
	}

	@Override
	public Member[] edit(Member member) {
		
		Member members[] = memberDao.update(member);
		
		return members;
	}

	@Override
	public void remove(Member member) {
		// memberDao 의 delete() 메소드 실행 -> 리턴값(dbMap)을 매개로 printMembers() 메소드 실행 
		printMembers(memberDao.delete(member));	
	}
	
	public void printMembers(Map<String, Member> map) {
		
		Set<String> keys = map.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			Member member = map.get(key); // key 값으로 value(Member 타입) 가져오기 
			printMember(member); // 탈퇴처리된 회원 제외하고 각 회원정보 출력 
		}
	}
	
	public void printMember(Member member) {
		System.out.println("Email : " + member.getEmail());
		System.out.println("Username : " + member.getUsername());
		System.out.println("Pwd : " + member.getPwd());
		System.out.println("Cell : " + member.getCells());
		System.out.println("IsAdult : " + member.getIsAdult());
		System.out.println("Sports : " + member.getSports());
	}
	
	
}
