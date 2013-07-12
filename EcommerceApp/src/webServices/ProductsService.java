package webServices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.JResponse;

import model.SecurityManager;
import pojo.ProductVO;

@Path("/products")
public class ProductsService {

	@GET
	@Produces(MediaType.TEXT_XML)
	public List<ProductVO> getProductsOnBrowser() {
		List<ProductVO> products = new ArrayList<ProductVO>();
		 SecurityManager securityManager= new SecurityManager();
		 try {
			products = securityManager.getAllProductsList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //return products;
		return products;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<ProductVO> getProducts() {
		List<ProductVO> products = new ArrayList<ProductVO>();
		 SecurityManager securityManager= new SecurityManager();
		 try {
			products = securityManager.getAllProductsList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //return products;
		return products;
	}
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JResponse<List<ProductVO>> getProducts() {
		List<ProductVO> products = new ArrayList<ProductVO>();
		 SecurityManager securityManager= new SecurityManager();
		 try {
			products = securityManager.getAllProductsList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //return products;
		return JResponse.ok(products).build();
	}*/
}
