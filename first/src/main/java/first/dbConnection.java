package first;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {

	private String jdbcUrl;
	private String id;
	private String pw;
	
	// setters and getters 
	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	

}
