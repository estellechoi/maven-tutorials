package com.word.service;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegister {
	
	private WordDao wordDao;
	
	// 생성자를 통한 의존객체 주입 
	public WordRegister(WordDao wordDao) {
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
