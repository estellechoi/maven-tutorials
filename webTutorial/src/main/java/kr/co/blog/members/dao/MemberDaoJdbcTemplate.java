package kr.co.blog.members.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import kr.co.blog.members.Member;

@Component
public class MemberDaoJdbcTemplate {

	// 데이터베이스 driver, url, id, pw 정보 
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/spring?userSSL=false";
	private String userid = "estellechoi";
	private String userpw = "12345678";

	// 스프링 DataSource 객체 & jdbcTemplate
	org.springframework.jdbc.datasource.DriverManagerDataSource dataSource; // springframework
	private JdbcTemplate template;

	// 1) 생성자
	public MemberDaoJdbcTemplate() {
		
		// dataSource 객체 생성 
		dataSource = new org.springframework.jdbc.datasource.DriverManagerDataSource();
		
		// 데이터베이스 접속 정보를 dataSource 객체에 저장
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(userid);
		dataSource.setPassword(userpw);

		// JdbcTemplate 객체에 dataSource 를 저장 (반복 피하기)
		template = new JdbcTemplate();
		template.setDataSource(dataSource);
	}

	// 2) insert (회원가입)
	public int insert(Member member) {

		int result = 0;

		final String sql = "insert into members(email, username, pwd) values(?,?,?)";
		result = template.update(sql, member.getEmail(), member.getUsername(), member.getPwd());
		
		return result; // Query Ok -> result = 1 
	}

	// 3) select (로그인)
	public Member select(final Member member) {
		
		List<Member> list = null;
		
		final String sql = "select*from member where email=? and pwd=?";
		
		// template.update(); 추가, 수정, 삭제
		list = template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPwd());
			}

		}, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Member memberRs = new Member();
				memberRs.setEmail(rs.getString("email"));
				memberRs.setPwd(rs.getString("pwd"));
				memberRs.setUsername(rs.getString("username"));
//				memberRecord.setCells(rs.getString("cells"));
				memberRs.setIsAdult(rs.getBoolean("isAdult"));
//				memberRecord.setSports(rs.getString("sports"));
				
				return memberRs;
			}

		});

		return list;
	}

	
	
	
	
	public Member selectSession(Member member) {
		return null;
	}

	public Member[] update(Member member) {
		return null;
	}

	public Map<String, Member> delete(Member member) {
		return null;
	}

}
