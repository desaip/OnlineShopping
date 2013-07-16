	package dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	 
	import pojo.User;
	 
	public class LoginHandler
	{
	 
		public ArrayList<User> getAllUsers(Connection connection) throws Exception 
		{
			ArrayList<User> userList = new ArrayList<User>();
			try 
			{
				 PreparedStatement ps = connection.prepareStatement("SELECT * FROM user");
				 ResultSet rs = ps.executeQuery();
				 while (rs.next()) 
				 {
					 User uservo = new User();
					 uservo.setUsername(rs.getString("username"));
					 uservo.setPassword(rs.getString("password"));
					 userList.add(uservo);
				 }
				 //System.out.println(userList);
				 return userList;
			}
			
			catch (Exception e)
			{
				System.out.println("Handler" + e);
				throw e;
			}
		}
	 
	}
