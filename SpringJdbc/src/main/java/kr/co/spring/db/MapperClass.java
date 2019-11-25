package kr.co.spring.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.spring.beans.JdbcBean;

// Mapper 클래스 : rs 레코드의 어느 컬럼 값을 bean의 어디에 넣을지 결정하는 클래스.
@Component
public class MapperClass implements RowMapper<JdbcBean>{
// RowMapper<E> 인터페이스를 구현하여 사용한다.
// RowMapper 의 제네릭은 데이터를 담을 DTO 객체로 한다. 여기서는 JdbcBean
	
	// 1) rs 레코드 값이 1 개 일 때 
	@Override
	public JdbcBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		// jdbcBean 객체에 setter() 를 사용하여 rs 값을 넣는다.
		JdbcBean jdbcBean = new JdbcBean();
		jdbcBean.setNumber(rs.getInt("number"));
		jdbcBean.setStr(rs.getString("str"));
		
		return jdbcBean;
		
		// 2) rs 레코드 값이 2 개 이상이면, 반환하는 jdbcBean 객체들을 List 의 요소로 넣어서 한번에 넘겨준다 .
	}

}
