package org.program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ProduceProductMenu implements ProductMenu {

	Login login=new Login();
	Scanner scanner=new Scanner(System.in);
	public void showMenu(int userType) {
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
			if(userType==0)
			{
				System.out.println("Do you wish to buy something(Yes/No)");
				String confirmation=scanner.next();
				if(confirmation.equalsIgnoreCase("Yes"))
				{
					showAddButton(userType);
				}
				else System.exit(0);
			}
			else if(userType==1)
			{
				System.out.println("Do you wish add products to the inventory(Yes/No)");
				String confirmMsg=scanner.next();
				if(confirmMsg.equalsIgnoreCase("Yes"))
				{
					showAddButton(userType);
				}
				else
				{
					System.exit(0);
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

	public void showAddButton(int userType) {

		if(userType==0)
		{
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
						"select * from ProduceProductList where productname= '"+pName+"'");
				String productname="";
				int quantity=0;
				while(resultSet.next()) {
					productname = resultSet.getString("productname");
					quantity = resultSet.getInt("quantity");
					if(quantity>=pQuantity)
					{
						System.out.println("Successfully Added to the cart");
						int newQuantity=quantity-pQuantity;
						PreparedStatement st = connection.prepareStatement("UPDATE ProduceProductList SET quantity = ? WHERE productname = ?");
						st.setInt(1, newQuantity);
						st.setString(2, productname);
						st.executeUpdate();
						System.exit(0);
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
		else if(userType==1)
		{
			System.out.println("Please enter the name of the product you want to add to the inventory");
			String pName=scanner.next();
			System.out.println("Please enter the quantity of the product");
			int pQuantity=scanner.nextInt();
			Connection connection=login.getConnection();
			try {
				Statement statement;
				statement = connection.createStatement();
				ResultSet resultSet;
				resultSet = statement.executeQuery(
						"select * from ProduceProductList where productname= '" + pName + "'");
				if (!resultSet.isBeforeFirst()) {
					System.out.println("We found no data! Are you adding a new product to the inventory(Yes/No)");
					String confirmMsg = scanner.next();
					if (confirmMsg.equalsIgnoreCase("Yes")) {
						PreparedStatement stmt = connection.prepareStatement("INSERT INTO ProduceProductList VALUES (?, ?)");
						stmt.setString(1, pName);
						stmt.setInt(2, pQuantity);
						stmt.executeUpdate();
						System.out.println("Successfully added to the inventory");
						System.exit(0);
					} else if (confirmMsg.equalsIgnoreCase("No")) {
						showAddButton(userType);
					}
				} else {
					ResultSet resultSet1=statement.executeQuery("select * from ProduceProductList where productname= '" + pName + "'");
					int oldQuantity=0;
					while(resultSet1.next())
					{
						oldQuantity=resultSet1.getInt("quantity");
					}
					int newQuantity=oldQuantity+pQuantity;
					PreparedStatement st = connection.prepareStatement("UPDATE ProduceProductList SET quantity=? WHERE productname = ?");
					st.setInt(1,newQuantity);
					st.setString(2, pName);
					st.executeUpdate();
					System.out.println("Successfully added to the inventory");
					System.exit(0);
				}
			}
			catch(Exception exception){
				System.out.println(exception);
			}
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
