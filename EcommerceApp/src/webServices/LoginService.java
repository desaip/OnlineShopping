package webServices;
 
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
 
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import model.SecurityManager;
import pojo.User;

//@Path("/WebService")
@Path("/login")

public class LoginService {

@Context HttpServletResponse servletResponse;
	
@POST
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

 public void login(@FormParam("username") String username,
 @FormParam("password") String password) throws IOException 
{
 String res=validateUser(username, password);

 if(res.contains("Logged in")){
	 servletResponse.sendRedirect("/EcommerceApp/Welcome.html");
 }
 else{
	 servletResponse.sendRedirect("/EcommerceApp/LoginForm.html");
 }

}
 
public String validateUser(String username,String password)
 {
	 String userListData = null;
	 try
	 {
		 ArrayList<User> userList = null;
		 SecurityManager securityManager= new SecurityManager();
		 userList = securityManager.getUser(username);
		 
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