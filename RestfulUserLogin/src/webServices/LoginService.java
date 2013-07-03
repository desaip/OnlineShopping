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
import pojo.UserVO;

//@Path("/WebService")
@Path("/login")

//@FormParamaccess username from html form. 


public class LoginService {

	/*@Context
	UriInfo uriInfo;
	@Context
	Request request;*/

 @POST
 //@Produces(MediaType.TEXT_HTML)
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

 public String login(@FormParam("username") String username,
 @FormParam("password") String password) // throws IOException  //@Context HttpServletResponse servletResponse
{
 String res=getAllUsersList(username, password);

 System.out.println(res);
 return res;
/*URI uri = uriInfo.getAbsolutePathBuilder().path(res).build();
//Response.temporaryRedirect(uri).build();
 return Response.created(uri).build();*/

//ResponseBuilder response = Response.ok().header("loginResult", res);
//return Response.build(); 

// servletResponse.sendRedirect("/Welcome.html");
}
 
public String getAllUsersList(String username,String password)
 {
	 String userListData = null;
	 try
	 {
		 ArrayList<UserVO> userList = null;
		 SecurityManager securityManager= new SecurityManager();
		 userList = securityManager.getAllUsersList();
		 
		 for (UserVO userVO : userList) {
	
			 if(userVO.getUsername().equals(username))
			 {
			 if(userVO.getPassword().equals(password))
			 	{
				 System.out.println(username);
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