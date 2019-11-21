package com.word.service;


import javax.annotation.Resource;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterWithResource {
	
	// Resource annotation은 동일한 객체 이름을 가진 객체를 찾아 자동 주입 
	// Autowired annotation은 동일한 객체 타입을 가진 객체를 찾아 자동 주입 
	
	// Resource annotation은 Autowired와 다르게 생성자에 사용할 수 없다
	// 프로퍼티나 메소드에 annotation 사용하는 경우, 디폴트 생성자 명시 필 
	@Resource
	private WordDao wordDao;
	
	public WordRegisterWithResource() {
		
	}
	
	// 생성자를 통한 의존객체 자동 주입
	// 스프링 컨테이너에서 WordDao 타입의 객체를 찾아 자동으로 파라미터 넣어줌 
	public WordRegisterWithResource(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if (verify(wordKey)) {
			wordDao.insert(wordSet);
		}
		else {
			System.out.println("이미 등록된 단어입니다. ");
		}
	}
	
	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true: false;
	}
	
	// setter 를 통한 의존객체 주입 
	@Resource
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

}
