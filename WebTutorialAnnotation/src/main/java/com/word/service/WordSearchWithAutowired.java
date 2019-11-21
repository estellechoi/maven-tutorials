package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearchWithAutowired {

	@Autowired
	private WordDao wordDao;

	
	// Autowired : 컨테이너에서 동일 타입 객체 자동 의존주입 / 생성자, 메소드, 프로퍼티에 사용 가능 
	// Resource : 컨테이너에서 동일 이름(id) 객체 자동 의존주입 / 메소드, 프로퍼티에 사용 가능
	
	// 생성자가 아닌 메소드나 프로퍼티에 annotation 적용시 디폴트 생성자 명시 필   
	// annotation 없는 생성자는 파라미터값을 자동으로 찾을 수 없기 때문
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
