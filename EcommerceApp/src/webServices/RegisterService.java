package webServices;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.SecurityManager;
import pojo.User;

@Path("/register")

public class RegisterService {

@Context HttpServletResponse servletResponse;
	
@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

 public void register(@FormParam("fname") String fname,@FormParam("lname") String lname,@FormParam("username") String username,
		 			@FormParam("password") String password, @FormParam("emailid") String email,
		 			@FormParam("add1") String add1,@FormParam("add2") String add2,
		 			@FormParam("city") String city,@FormParam("statedd") String state,
		 			@FormParam("zip") String zip,@FormParam("con_num") String num) throws IOException 
{

	 try {
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			u.setFname(fname);
			u.setLname(lname);
			u.setEmail(email);
			u.setAddress1(add1);
			u.setAddress2(add2);
			u.setCity(city);
			u.setZip(zip);
			u.setState(state);
			u.setNum(num);
			SecurityManager securityManager= new SecurityManager();
			
			securityManager.storeUser(u);
			
			servletResponse.sendRedirect("/EcommerceApp/LoginForm.html");
			
			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}
 
public String getAllUsersList(String username,String password)
 {
	 String userListData = null;
	 try
	 {
		 ArrayList<User> userList = null;
		 SecurityManager securityManager= new SecurityManager();
		 userList = securityManager.getAllUsersList();
		 
		 for (User userVO : userList) {
	
			 if(userVO.getUsername().equals(username))
			 {
			 if(userVO.getPassword().equals(password))
			 	{
				 //System.out.println(username);
				 return "Logged in User:"+username+"\n Products coming shortly";
				 
			 	}
			 }
		 }
 
	 }
	 catch (Exception e) {
		  System.out.println("error");
	 }
	 
	 return "You are not a Valid User";
 }

}