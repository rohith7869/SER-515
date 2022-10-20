package org.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login extends Facade {

    Scanner scanner=new Scanner(System.in);
    Buyer buyer=new Buyer();
    Seller seller=new Seller();
    public boolean login()
    {
        System.out.println("Welcome to the trading application");
        System.out.println("Please choose your user type");
        System.out.println("Type 0 for Buyer Type");
        System.out.println("Type 1 for Seller Type");
        int userType=scanner.nextInt();
        setUserType(userType);
        if(userType==0)
        {
            loginBuyer(userType);
        }
        else if(userType==1)
        {
            loginSeller(userType);
        }
        return  true;
    }

    public void loginBuyer(int userType)
    {
        System.out.println("Please Enter your UserName");
        String userName=scanner.next();
        System.out.println("Please Enter your Password");
        String password=scanner.next();
        Connection connection=getConnection();
        try{
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select * from buyer where username= '"+userName+"' ");
            String name="";
            String pwd="";
            if(resultSet.next()) {
                name = resultSet.getString("username");
                pwd = resultSet.getString("password").trim();
            }
            if(name.equals(userName))
            {
                if(password.equals(pwd))
                {
                    System.out.println("Login successful! Welcome "+userName);
                    buyer.showMenu(userType);
                }
                else
                {
                    System.out.println("Please Check your username/password you have entered");
                    loginBuyer(userType);
                }
            }
            else
            {
                System.out.println("User Not Found");
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch(Exception exception){
            System.out.println(exception);
        }
    }
    public void loginSeller(int userType)
    {
        System.out.println("Please Enter your UserName");
        String userName=scanner.next();
        System.out.println("Please Enter your Password");
        String password=scanner.next();
        Connection connection=getConnection();
        try{
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select * from seller where username= '"+userName+"' ");
            String name="";
            String pwd="";
            if(resultSet.next()) {
                name = resultSet.getString("username");
                pwd = resultSet.getString("password").trim();
            }
            if(name.equals(userName))
            {
                if(password.equals(pwd))
                {
                    System.out.println("Login successful! Welcome "+userName);
                    seller.showMenu(userType);
                }
                else
                {
                    System.out.println("Please Check your username/password you have entered");
                    loginSeller(userType);
                }
            }
            else
            {
                System.out.println("User Not found");
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch(Exception exception){
            System.out.println(exception);
        }
    }
    public Connection getConnection()
    {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/designpattern",
                    "root", "Rohith7869@");

        }
        catch (Exception exception) {
            System.out.println(exception);
        }
        return connection;
    }

}
