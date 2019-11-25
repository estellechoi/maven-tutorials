package kr.co.spring.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.co.spring.beans.JdbcBean;

@Component
public class JdbcDao {

	// JdbcTemplate 객체 주입
	@Autowired
	private JdbcTemplate dbConnection;
	
	@Autowired
	private MapperClass mapper;

	// 저장
	public void insertData(JdbcBean jdbcBean) {
		String sql = "insert into test(number, str) values(?,?)";
		// (sql, ? 값, ? 값)
		dbConnection.update(sql, jdbcBean.getNumber(), jdbcBean.getStr());
	}
	
	// 조회 
	// 다수의 레코드를 각각 bean 객체에 담은 후 List 의 요소로 묶어준다.
	public List<JdbcBean> selectData() {
		String sql = "select number, str from test";
		List<JdbcBean> list = dbConnection.query(sql, mapper);
		
		return list;
	}
	
	// 수정 
	public void updateData(JdbcBean jdbcBean) {
		String sql = "update test set str = ? where number = ?";
		dbConnection.update(sql, jdbcBean.getStr(), jdbcBean.getNumber());
	}
	
	// 삭제 
	public void deleteData(JdbcBean jdbcBean) {
		String sql = "delete from test where number = ?";
		dbConnection.update(sql, jdbcBean.getNumber());
	}
}
