package kr.co.blog.members.dao;
// MemberDto.java 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import kr.co.blog.members.MemberDto;

@Component
public class MemberDaoJdbc {

	// 데이터베이스 driver, url, id, pw 정보 
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/spring?userSSL=false";
	private String userid = "estellechoi";
	private String userpw = "12345678";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 1) 생성자
	public MemberDaoJdbc() {
	}

	// 2) insert (회원가입)
	public int insert(MemberDto member) {

		int result = 0;
		
		try {
			// DB 연결 
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			// Query 
			String sql = "insert into members(email, username, pwd) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getUsername());
			pstmt.setString(3, member.getPwd());
			// executeUpdate(); 실행된 레코드 수를 반환 
			// Query Ok -> result = 1
			result = pstmt.executeUpdate();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;  
	}

	// 3) select (로그인)
	public MemberDto select(final MemberDto member) {
		
		MemberDto memberRs = null;
		
		try {
			// DB 연결 
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			// Query
			String sql = "select*from members where email=? and pwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPwd());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// DB 값 모두 받아와야 하나 ? 생각해보자 
				memberRs.setEmail(rs.getString("email"));
				memberRs.setUsername(rs.getString("username"));
				memberRs.setPwd(rs.getString("pwd"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return memberRs;
	}

	public int delete(MemberDto member) {
		int result = 0;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, userpw);
			String sql = "delete from members where email=? and pwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPwd());
			// executeUpdate(); 실행된 레코드 수를 반환 
			result = pstmt.executeUpdate();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
