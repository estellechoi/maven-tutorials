package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearchWithAutowired {

	@Autowired
	private WordDao wordDao;

	// 생성자가 아닌 메소드, 파라미터에 Autowired 적용할 때는 기본 생성자를 명시해야 함  
	// Autowired 명시하지 않은 생성자의 매개변수 값을 찾을 수 없기 때문  
	public WordSearchWithAutowired() {
		
	}
	// Autowired X
	public WordSearchWithAutowired(WordDao wordDao) {
		this.wordDao = wordDao;
	}

	public WordSet search(String wordKey) {
		if (verify(wordKey)) {
			return wordDao.select(wordKey);
		} else {
			System.out.print("단어 정보가 없습니다. ");
		}

		return null;
	}

	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet != null ? true : false;
	}

	// setter 를 통한 의존객체 주입
	@Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

}
