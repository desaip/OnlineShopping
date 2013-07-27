package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pojo.Product;

public class ProductsHandler {
	public ArrayList<Product> getAllProducts(Connection connection) throws Exception 
	{
		ArrayList<Product> productsList = new ArrayList<Product>();
		try 
		{
			 PreparedStatement ps = connection.prepareStatement("SELECT * FROM products");
			 ResultSet rs = ps.executeQuery();
			 while (rs.next()) 
			 {
				 Product p = new Product();
				 p.setProductCategory(rs.getString("productCategory"));
				 p.setProductDesc(rs.getString("productDesc"));
				 p.setProductId(rs.getInt("productId"));
				 p.setProductName(rs.getString("productName"));
				 p.setWeight_lb(rs.getFloat("weight_lb"));
				 p.setPrice(rs.getFloat("price"));
				 productsList.add(p);
			 }
			 //System.out.println(productsList);
			 return productsList;
		}
		
		catch (Exception e)
		{
			System.out.println("Handler" + e);
			throw e;
		}
	}

	public int addProduct(Connection c, Product p) throws Exception
		{
			int pid=0;
			try 
			{
				String name = p.getProductName();
				String cat = p.getProductCategory();
				String desc = p.getProductDesc();
				float weight = p.getWeight_lb();
				float price = p.getPrice();
								
				String q1 = "SELECT COUNT(*) AS total FROM products";
				PreparedStatement ps1 = c.prepareStatement(q1);
				ResultSet RS = ps1.executeQuery(q1);
				int results=0;
		        while (RS.next()) {
		            results= results+RS.getInt("total");
		            } 
		         pid=(results+1);
		                
		            	String q = "INSERT INTO products VALUES('"+pid+"','"+name+"','"+cat+"','"+desc+"',"+weight+","+price+")";
						//System.out.println(q);
						 PreparedStatement ps = c.prepareStatement(q);
						 ps.executeUpdate();
						 
		            
			}
			catch (Exception e)
			{
				System.out.println("Handler" + e);
				throw e;
			}
			return pid;
		}
 
}
