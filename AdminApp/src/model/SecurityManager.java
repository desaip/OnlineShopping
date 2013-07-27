package model;

import java.sql.Connection;
import java.util.ArrayList;

import pojo.Product;
import pojo.Admin;
import dao.DbConnection;
import dao.LoginHandler;
import dao.ProductsHandler;

public class SecurityManager {
	
	DbConnection database;
	Connection connection;
	
	public SecurityManager(){
		try {
			database= new DbConnection();
			connection = database.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Admin getAdmin(String email)throws Exception {
		Admin ad = new Admin();
		try {
			LoginHandler loginHandler= new LoginHandler();
			ad = loginHandler.getAdmin(connection, email);
		
			} catch (Exception e) {
				throw e;
				}
			return ad;
	}
	
	public ArrayList<Product> getAllProductsList()throws Exception {
		ArrayList<Product> productsList = null;
		try {
			ProductsHandler productsHandler= new ProductsHandler();
			productsList = productsHandler.getAllProducts(connection);
		
			} catch (Exception e) {
				throw e;
				}
			return productsList;
	}

	public int addProduct(Product p) throws Exception {
		try {
			ProductsHandler pHandler= new ProductsHandler();
			int result = pHandler.addProduct(connection, p);
			return result;
			} catch (Exception e) {
				throw e;
				}
		}
}