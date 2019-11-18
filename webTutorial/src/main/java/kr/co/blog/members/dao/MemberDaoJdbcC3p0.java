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

//import com.mchange.v2.c3p0.DriverManagerDataSource;

import kr.co.blog.members.Member;

// 이 클래스를 스프링컨테이너에 빈 객체로 생성한다. 
@Component
//@Repository
public class MemberDaoJdbcC3p0 {

	// DB 연결
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/spring?userSSL=false";
	private String userid = "estellechoi";
	private String userpw = "12345678";

//	private DriverManagerDataSource dataSource; // c3p0
	org.springframework.jdbc.datasource.DriverManagerDataSource dataSource; // springframework
	private JdbcTemplate template;

	// 생성자
	public MemberDaoJdbcC3p0() {

		// 데이터베이스 접속 관련 정보를 dataSource 객체에 저장
		// c3p0
//		dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClass(driver);
//		dataSource.setJdbcUrl(url);
//		dataSource.setUser(userid);
//		dataSource.setPassword(userpw);

		// springframework
		dataSource = new org.springframework.jdbc.datasource.DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(userid);
		dataSource.setPassword(userpw);

		// JdbcTemplate 객체에 dataSource 를 저장 (반복 피하기)
		template = new JdbcTemplate();
		template.setDataSource(dataSource);
	}

	public int insert(Member member) {

		int result = 0;

		final String sql = "insert into members(email, username, pwd) values(?,?,?)";
		result = template.update(sql, member.getEmail(), member.getUsername(), member.getPwd());
		return result;

		/*
		 * try { Class.forName(driver); conn = DriverManager.getConnection(url, userid,
		 * userpw); pstmt = conn.prepareStatement(sql); pstmt.setString(1,
		 * member.getEmail()); pstmt.setString(2, member.getUsername());
		 * pstmt.setString(3, member.getPwd()); // Query Ok -> result = 1 result =
		 * pstmt.executeUpdate(); } catch (ClassNotFoundException e) {
		 * e.printStackTrace(); } catch (SQLException e) { e.printStackTrace(); }
		 * finally { try { if(pstmt != null) pstmt.close(); if(conn != null)
		 * conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		 */
	}

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
				Member memberRecord = new Member();
				memberRecord.setEmail(rs.getString("email"));
				memberRecord.setPwd(rs.getString("pwd"));
				memberRecord.setUsername(rs.getString("username"));
//				memberRecord.setCells(rs.getString("cells"));
				memberRecord.setIsAdult(rs.getBoolean("isAdult"));
//				memberRecord.setSports(rs.getString("sports"));
				
				return memberRecord;
			}

		});

		return list;
	}

	public Member selectSession(Member member) {

		Member memberRecord = dbMap.get(member.getEmail());

		return memberRecord;
	}

	public Member[] update(Member member) {

		Member members[] = new Member[2];
		// 이전 레코드
		members[0] = dbMap.get(member.getEmail());

		// 수정 후 레코드
		dbMap.put(member.getEmail(), member);
		members[1] = dbMap.get(member.getEmail());

		return members;
	}

	public Map<String, Member> delete(Member member) {
		// DB 에서 key 값으로 레코드 삭제
		dbMap.remove(member.getEmail());
		// 레코드가 삭제된 DB 객체 리턴
		return dbMap;
	}

}
