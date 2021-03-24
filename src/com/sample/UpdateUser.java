package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateUser {
	
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/testdatabase";
		String USER = "root";
		String PASS = "root";
		String QUERY = "update student set name=?, college=? , education=? , fees=? where roll=?";
		
		public void Update(String name , String collegeName , String education , int fees , int roll)
		{
			try {
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(URL,USER,PASS);
				PreparedStatement psmt = con.prepareStatement(QUERY);
				psmt.setString(1, name);
				psmt.setString(2, collegeName);
				psmt.setString(3, education);
				psmt.setInt(4, fees);
				psmt.setInt(5, roll);
				
				int i = psmt.executeUpdate(QUERY);
				
				
				if( i > 0 )
				{
					System.out.println("Record Successfully Updated");
				}
				
				psmt.close();
				con.close();				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
