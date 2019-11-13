package kr.co.blog.members.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.blog.members.Member;
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
	public void register(String email, String pwd, String username, String cell1, String cell2, String cell3) {
		System.out.println("Member Register");
		System.out.println("Email : " + email);
		System.out.println("Pwd : "+ pwd);
		System.out.println("Username : " + username);
		System.out.println("Cell : " + cell1 + "-" + cell2 + "-" + cell3);
		
		memberDao.insert(email, pwd, username, cell1, cell2, cell3);
	}

	@Override
	public Member select(String email, String pwd) {
		System.out.println("Member Search");
		System.out.println("Email : "+ email);
		System.out.println("Pwd : "+ pwd);
		
		Member member = memberDao.select(email, pwd);
		
		return member;
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
