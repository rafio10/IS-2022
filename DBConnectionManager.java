package database;

import java.sql.*;

public class DBConnectionManager
{
	public static String url = "jdbc:mysql://localhost:3306/";
	public static String dbName = "multimedia";
	public static String driver = "com.mysql.cj.jdbc.Driver";
	public static String userName = "root"; 
	public static String password = "spicchio";

	public static Connection getConnection() throws  Exception {
	  
	  Class.forName(driver);
	  Connection conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
	  
	  return conn;
	}
	
	public static ResultSet selectQuery(String query) throws Exception {
		Connection conn = getConnection();
        Statement statement = conn.createStatement();
        ResultSet ret = statement.executeQuery(query);
        //conn.close();
        return ret;
	}

	public static int updateQuery(String query) throws Exception {
		Connection conn = getConnection();
		Statement statement = conn.createStatement();
		int ret = statement.executeUpdate(query);
		conn.close();
		return ret;
	}
	
}
