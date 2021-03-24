package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddUser {

		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/testdatabase";
		String USER = "root";
		String PASS = "root";
		String QUERY = "insert into student values(?,?,?,?,?)";
		
		public void Add(int roll , String name , String collegeName , String education , int fees)
		{
			try {
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(URL,USER,PASS);
				PreparedStatement psmt = con.prepareStatement(QUERY);
				psmt.setInt(1, roll);
				psmt.setString(2, name);
				psmt.setString(3, collegeName);
				psmt.setString(4, education);
				psmt.setInt(5, fees);
						
				int i = psmt.executeUpdate();
				
				if( i > 0 )
				{
					System.out.println("Record Successfully inserted");
				}
				
				psmt.close();
				con.close();				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

}
