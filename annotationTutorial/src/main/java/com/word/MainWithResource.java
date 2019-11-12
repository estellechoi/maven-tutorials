package com.word;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.word.service.WordRegister;
import com.word.service.WordRegisterWithResource;
import com.word.service.WordSearch;
import com.word.service.WordSearchWithAutowired;

public class MainWithResource {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new	GenericXmlApplicationContext("classpath:appContextWithResource.xml");
		
		// 단어 등록 
		WordRegisterWithResource wordRegister = ctx.getBean("wordRegister", WordRegisterWithResource.class);
		
		String key = "개발자";
		String value = "최유진";
		WordSet wordSet = new WordSet(key, value);
		wordRegister.register(wordSet);
		
		System.out.println("---------------");
		
		// 단어 검색
		WordSearchWithAutowired wordSearch = ctx.getBean("wordSearch", WordSearchWithAutowired.class);
		wordSet = wordSearch.search(key); // 검색 결과는 WordSet 객체 자료형 
		System.out.println("키 : " + wordSet.getWordKey());
		System.out.println("값 : " + wordSet.getWordValue());
		
		ctx.close();
		
	}

}
