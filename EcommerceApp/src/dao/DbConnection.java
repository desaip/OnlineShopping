package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public Connection getConnection() throws Exception
	 {
	 try
	 	{
		 String connectionURL = "jdbc:mysql://localhost:3306/test";
		 Connection connection = null;
		 Class.forName("com.mysql.jdbc.Driver").newInstance();
		 connection = DriverManager.getConnection(connectionURL, "root", "admin");
		 System.out.println("mysql connection successful");
		 return connection;
		 //<span id="IL_AD2" class="IL_AD">return</span> connection;
	 	}
	 catch (SQLException e)
	 	{
	 
	 System.out.println("sql db conn fail"+e);
	 throw e;
	 	}
	 catch (Exception e)
	 	{
		 System.out.println("db conn fail"+e);
		 throw e;
	 	}
	 }
}
