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
	 
		
		public ArrayList<User> getUser(Connection connection, String username) throws Exception 
		{
			ArrayList<User> userList = new ArrayList<User>();
			try 
			{
				 String q ="SELECT * FROM user WHERE username='"+username+"'";
				 PreparedStatement ps = connection.prepareStatement(q);
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
		
		
		public void storeUser(Connection c, User u) throws Exception
		{
			try 
			{
				String fname = u.getFname();
				String lname = u.getLname();
				String username = u.getUsername();
				String pwd = u.getPassword();
				String add1 = u.getAddress1();
				String add2 = u.getAddress2();
				String city = u.getCity();
				String state = u.getState();
				String zip = u.getZip();
				String email = u.getEmail();
				String num = u.getNum();
				
				String q = "INSERT INTO user VALUES('"+username+"','"+pwd+"','"+fname+"','"+lname+"','"+email+"','"+add1+"','"+add2+"','"+city+"','"+state+"','"+zip+"','"+num+"')";
				System.out.println(q);
				 PreparedStatement ps = c.prepareStatement(q);
						 ps.executeUpdate();
			
			}
			catch (Exception e)
			{
				System.out.println("Handler" + e);
				throw e;
			}
		}
		
	}
