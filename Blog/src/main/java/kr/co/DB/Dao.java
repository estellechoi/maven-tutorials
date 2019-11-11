package kr.co.DB;

import java.sql.*;
import kr.co.DB.Dto;

public class Dao {

	// DB Connection
	private Connection conn;

	public void Connect() throws SQLException {
		String driver = "jdbc:mysql://localhost:3307/spring?useSSL=false";
		String id = "root";
		String pw = "1234";
		conn = DriverManager.getConnection(driver, id, pw);
	}

	// 회원 등록
	public void write(Dto dto) throws SQLException {
		String sql = "insert into members(username, age, address, writeday)";
		sql = sql + " values(?,?,?,now())";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getUsername());
		pstmt.setInt(2, dto.getAge());
		pstmt.setString(3, dto.getAddress());
		pstmt.executeUpdate();
	}

}
