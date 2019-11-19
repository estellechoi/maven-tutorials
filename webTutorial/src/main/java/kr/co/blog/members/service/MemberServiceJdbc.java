package kr.co.blog.members.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.blog.members.Member;
import kr.co.blog.members.MemberCell;
import kr.co.blog.members.MemberDto;
import kr.co.blog.members.dao.MemberDaoJdbc;

// 이 클래스를 스프링컨테이너에 빈 객체로 생성한다. (스프링설정파일에서 bean 태그로 생성할 필요 X)
@Service
public class MemberServiceJdbc {
	
	// 컨테이너에서 동일타입(MemberDao) 빈 객체 호출
	@Autowired
	MemberDaoJdbc memberDao;

	public int register(MemberDto member) {
		int result = memberDao.insert(member);
		return result;
	}

	public MemberDto select(MemberDto member) {
		MemberDto memberRs = memberDao.select(member);		
		return memberRs;
	}
	

	public int remove(MemberDto member) {
		int result = memberDao.delete(member);	
		return result;
	}

	
}
