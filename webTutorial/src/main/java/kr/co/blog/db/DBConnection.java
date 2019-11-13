package kr.co.blog.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static String jdbcUrl = "jdbc:mysql://localhost:3307/connect?useSSL=false";
	private static String id = "";
	private static String pwd = "";
	
	public void db(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	
	public static void connect() throws SQLException {
		Connection conn = DriverManager.getConnection(jdbcUrl, id, pwd);
	}
	

}
