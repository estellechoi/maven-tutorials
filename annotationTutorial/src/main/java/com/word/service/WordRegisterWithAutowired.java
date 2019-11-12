package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterWithAutowired {
	
	private WordDao wordDao;
	
	// 생성자를 통한 의존객체 자동 주입
	// 스프링 컨테이너에서 WordDao 타입의 객체를 찾아 자동으로 파라미터 넣어줌 
	@Autowired
	public WordRegisterWithAutowired(WordDao wordDao) {
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
