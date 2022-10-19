package org.program;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;



public class MeatProductMenu implements ProductMenu {

	Login login=new Login();
	Scanner scanner=new Scanner(System.in);
	public void showMenu() {
		Connection connection=login.getConnection();
		try{
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet;
			resultSet = statement.executeQuery(
					"select * from MeatProductList");
			String productname="";
			int quantity=0;
			System.out.println("Menu of MeatProducts");
			System.out.println("---------------------------");
			System.out.println("ProductName          Quantity");
			while(resultSet.next()) {
				productname = resultSet.getString("productname");
				quantity = resultSet.getInt("quantity");
				System.out.println(productname+"                     "+quantity);
			}
			System.out.println("Do you wish to buy something(Yes/No)");
			String confirmation=scanner.next();
			if(confirmation.equalsIgnoreCase("Yes"))
			{
				showAddButton();
			}
			else System.exit(0);
			resultSet.close();
			statement.close();
			connection.close();
		}
		catch(Exception exception){
			System.out.println(exception);
		}
	}

	public void showAddButton() {
		System.out.println("Please Enter the product name that you want to buy?");
		String pName=scanner.next();
		System.out.println("Please Enter the quantity that you want to buy");
		int pQuantity=scanner.nextInt();
		Connection connection=login.getConnection();
		try{
			Statement statement;
			statement = connection.createStatement();
			ResultSet resultSet;
			resultSet = statement.executeQuery(
					"select * from MeatProductList where productname= '"+pName+"'");
			String productname="";
			int quantity=0;
			while(resultSet.next()) {
				productname = resultSet.getString("productname");
				quantity = resultSet.getInt("quantity");
                if(quantity>=pQuantity)
				{
					System.out.println("Successfully Added to the cart");

				}
				else
				{
					System.out.println("We do not have the quantity you are looking for");
				}
			}
			resultSet.close();
			statement.close();
			connection.close();
		}
		catch(Exception exception){
			System.out.println(exception);
		}

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
