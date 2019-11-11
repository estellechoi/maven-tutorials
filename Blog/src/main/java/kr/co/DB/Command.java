package kr.co.DB;

import kr.co.DB.Dto;
import kr.co.DB.Dao;
import java.sql.SQLException;

public class Command {

	public void write(Dto dto) throws SQLException {
		Dao dao = new Dao();
		dao.write(dto);
	}

}
