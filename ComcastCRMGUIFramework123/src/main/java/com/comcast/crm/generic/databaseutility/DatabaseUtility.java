package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class DatabaseUtility {

	
		Connection con;
		public void getDBConnection() throws Throwable {
			try{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","root");
			
			
			}
			catch(Exception e) {
				
			}
		}
	
		public void getDBCloseConnection() throws Throwable{
			con.close();
			
		}
		
		public ResultSet executeconSelectQuery(String query) throws Throwable
		{
			ResultSet result=null;
			try
			{ 
				Statement stat=con.createStatement();
			 result=stat.executeQuery(query);
			
			}
			catch(Exception e)
			{}
			return result;
		}
		public int executeNonSelectQuery(String query) throws Throwable
		//output is in the form of 0=not executed & 1=executed
		{
		int result=0;
			try
			{ 
				Statement stat=con.createStatement();
			 result=stat.executeUpdate(query);
			
			}
			catch(Exception e)
			{}
			return result;
		}
		

	

}

