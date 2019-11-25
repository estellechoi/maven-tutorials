package kr.co.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.spring.beans.TestDto;

public interface MapperInterface {

	// 구현될 추상메소드 정의하기 
	
	/*
	 * 데이터베이스 테이블 컬럼명과 DTO 변수명이 일치하므로 자동으로 맞추어 저장딘다.
	 * 만약 일치하지 않게 저장하려면, 아래와 같이 직접 매칭 설정하면 된다.
	 * 
	@Results({
		@Result(column = "number", property="number"),
		@Result(column = "str", property="str")
	})
	*/
	@Select("select number, str from test")
	List<TestDto> selectData(); //
	
	@Insert("insert into test(number, str) values(#{number}, #{str})")
	void insertData(TestDto dto); // dto 객체의 변수명을 #{} 문법으로 쿼리문에 바인딩 한다.
	
	@Update("update test set str = #{str} where number = #{number}")
	void updateData(TestDto dto);
	
	// 쿼리문에 바인딩할 값이 1 개 라면, 객체가 아닌 값을 받아와서 바인딩 한다.
	@Delete("delete from test where number = #{param}")
	void deleteData(int number);

}
