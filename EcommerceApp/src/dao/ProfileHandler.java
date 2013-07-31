package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pojo.User;

public class ProfileHandler {

	public User getProfile(Connection connection, String email) throws Exception {
		User user = new User();
		try 
		{
			 String q ="SELECT * FROM user WHERE email='"+email+"'";
			 PreparedStatement ps = connection.prepareStatement(q);
			 ResultSet rs = ps.executeQuery();
			 if (rs.next()) 
			 {
				 user.setEmail(rs.getString("email"));
				 user.setPassword(rs.getString("password"));
				 user.setFname(rs.getString("fname"));
				 user.setLname(rs.getString("lname"));
				 user.setAddress1(rs.getString("address1"));
				 user.setAddress2(rs.getString("address2"));
				 user.setCity(rs.getString("city"));
				 user.setState(rs.getString("state"));
				 user.setZip(rs.getString("zip"));
				 user.setContact_num(rs.getString("contact_num"));
				 user.setCountry(rs.getString("country"));
				 
			 }
			 //System.out.println(userList);
			 return user;
		}
		
		catch (Exception e)
		{
			System.out.println("Handler" + e);
			throw e;
		}	}

}
