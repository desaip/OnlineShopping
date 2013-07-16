	package model;

import java.sql.Connection;
import java.util.ArrayList;

import pojo.Product;
import pojo.User;
import dao.DbConnection;
import dao.LoginHandler;
import dao.ProductsHandler;

public class SecurityManager {

	public ArrayList<User> getAllUsersList()throws Exception {
		ArrayList<User> userList = null;
		try {
			DbConnection database= new DbConnection();
			Connection connection = database.getConnection();
			LoginHandler loginHandler= new LoginHandler();
			userList= loginHandler.getAllUsers(connection);
		
			} catch (Exception e) {
				throw e;
				}
			return userList;
	}
	
	public ArrayList<User> getUser(String username)throws Exception {
		ArrayList<User> userList = null;
		try {
			DbConnection database= new DbConnection();
			Connection connection = database.getConnection();
			LoginHandler loginHandler= new LoginHandler();
			userList= loginHandler.getUser(connection, username);
		
			} catch (Exception e) {
				throw e;
				}
			return userList;
	}
	
	public void storeUser(User u)throws Exception {
		
		try {
			DbConnection database= new DbConnection();
			Connection connection = database.getConnection();
			LoginHandler loginHandler= new LoginHandler();
			loginHandler.storeUser(connection, u);
		
			} catch (Exception e) {
				throw e;
				}
	}
	
	public ArrayList<Product> getAllProductsList()throws Exception {
		ArrayList<Product> productsList = null;
		try {
			DbConnection database= new DbConnection();
			Connection connection = database.getConnection();
			ProductsHandler productsHandler= new ProductsHandler();
			productsList = productsHandler.getAllProducts(connection);
		
			} catch (Exception e) {
				throw e;
				}
			return productsList;
	}
}