package org.program;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProduceProductMenu implements ProductMenu {

	Login login=new Login();
	public void showMenu() {
		Connection connection=login.getConnection();
		try{
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet;
			resultSet = statement.executeQuery(
					"select * from ProduceProductList");
			String productname="";
			int quantity=0;
			System.out.println("Menu of Produce Products");
			System.out.println("---------------------------");
			System.out.println("ProductName          Quantity");
			while(resultSet.next()) {
				productname = resultSet.getString("productname");
				quantity = resultSet.getInt("quantity");
				System.out.println(productname+"                     "+quantity);
			}
			resultSet.close();
			statement.close();
			connection.close();
		}
		catch(Exception exception){
			System.out.println(exception);
		}
	}

	public void showAddButton() {

	}

	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public void showComboxes() {

	}

}
