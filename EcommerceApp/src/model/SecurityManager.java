	package model;

import java.sql.Connection;
import java.util.ArrayList;

import pojo.ProductVO;
import pojo.UserVO;
import dao.DbConnection;
import dao.LoginHandler;
import dao.ProductsHandler;

public class SecurityManager {

	public ArrayList<UserVO> getAllUsersList()throws Exception {
		ArrayList<UserVO> userList = null;
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
	
	public ArrayList<ProductVO> getAllProductsList()throws Exception {
		ArrayList<ProductVO> productsList = null;
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