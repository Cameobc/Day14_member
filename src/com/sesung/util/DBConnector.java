package com.sesung.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	
	public static Connection connection() throws Exception {
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@211.238.142.23:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
		
	}
	
	public static void disconnection(Connection con, PreparedStatement st) throws Exception {
		st.close();
		con.close();
	}
	
	public static void disconnction(Connection con, PreparedStatement st, ResultSet rs) throws Exception{
		rs.close();
		st.close();
		con.close();
	}

}
