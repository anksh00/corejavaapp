package com.dbutils;
import java.sql.*;

public class CrudOperation 
{
	
	private static Connection con;
	
	public static Connection createConnection()
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");//create the object of driver class
			                                          //factory method--use to create object
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb",
					"root","root"); //name or ipaddress of the machine DB installed
			
		}
		catch (SQLException| ClassNotFoundException cse ) { 
			
			System.out.println(cse);
		}
		return con;
	}

	/*public static void main(String[] args) {
		
		Connection cn=  createConnection();
		System.out.println(cn);*/
		
	}
	

