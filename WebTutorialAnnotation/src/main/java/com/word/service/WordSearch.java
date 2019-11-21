package com.word.service;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearch {

	private WordDao wordDao;

	// 생성자를 통한 의존객체 주입
	public WordSearch(WordDao wordDao) {
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
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

}
