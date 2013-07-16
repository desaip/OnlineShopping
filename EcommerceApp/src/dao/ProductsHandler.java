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
				 p.setQuantity(rs.getInt("quantity"));
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
 
}
