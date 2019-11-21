package com.word.service;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterWithInject {

	@Autowired
	@Qualifier("usedDao")	
	private WordDao wordDao;
	
	// Autowired : 컨테이너에서 동일 타입 객체 자동 의존주입 / 생성자, 메소드, 프로퍼티에 사용 가능 
	// Resource : 컨테이너에서 동일 이름(id) 객체 자동 의존주입 / 메소드, 프로퍼티에 사용 가능
	
	@Inject
	@Named(value="wordDao")
	// 컨테이너에서 WordDao 타입의 객체를 찾아 생성자 파라미터값으로 주입 
	public WordRegisterWithInject(WordDao wordDao) {
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
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

}
