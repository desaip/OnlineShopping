package webServices;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataParam;
import com.sun.jersey.multipart.FormDataMultiPart;

import javax.ws.rs.FormParam;

import model.SecurityManager;
import pojo.Product;

@Path("/addProduct")

public class AddProductService {
	@Context HttpServletResponse servletResponse;
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	 public void addProduct(FormDataMultiPart multiPart) throws IOException 
	{
		try {
		List<FormDataBodyPart> Namefield = multiPart.getFields("name");     
		String name = ((FormDataBodyPart) Namefield).getValue();
		List<FormDataBodyPart> Catfield = multiPart.getFields("cat");     
		String cat = ((FormDataBodyPart) Catfield).getValue();
		List<FormDataBodyPart> Descfield = multiPart.getFields("desc");     
		String desc = ((FormDataBodyPart) Descfield).getValue();
		List<FormDataBodyPart> Weightfield = multiPart.getFields("weight");     
		String weight = ((FormDataBodyPart) Weightfield).getValue();
		List<FormDataBodyPart> Pricefield = multiPart.getFields("price");     
		String price = ((FormDataBodyPart) Pricefield).getValue();
		
		List<FormDataBodyPart> Picfield = multiPart.getFields("pic"); 
		InputStream stream = ((FormDataBodyPart) Picfield).getValueAs(InputStream.class);
		 String fileName = ((FormDataBodyPart) Picfield).getName();
		 
				Product p = new Product();
				p.setProductName(name);
				p.setProductCategory(cat);
				p.setProductDesc(desc);
				p.setWeight_lb(Float.parseFloat(weight));
				p.setPrice(Float.parseFloat(price));
				SecurityManager securityManager= new SecurityManager();
				
				String uploadedFileLocation = "images/"+fileName+".jpg";
				writeToFile(stream, uploadedFileLocation);

			    String output = "File uploaded to : " + uploadedFileLocation;
			    System.out.println(output); 
			    try {

			        stream.close();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
				
				
				if(securityManager.addProduct(p)==false){
					servletResponse.sendRedirect("/AdminApp/AddProduct.html?result=false");
				}
				else{
				servletResponse.sendRedirect("/AdminApp/Welcome.html");
				}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {
	 
			try {
				OutputStream out = new FileOutputStream(new File(
						uploadedFileLocation));
				int read = 0;
				byte[] bytes = new byte[1024];
	 
				out = new FileOutputStream(new File(uploadedFileLocation));
				while ((read = uploadedInputStream.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
				out.flush();
				out.close();
			} catch (IOException e) {
	 
				e.printStackTrace();
			}
	 
		}
}
