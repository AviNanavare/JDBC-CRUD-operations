package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteUser {
	
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/testdatabase";
		String USER = "root";
		String PASS = "root";
		String QUERY = "delete from student where rollnum =?";
		
		public void Delete(int roll)
		{
			try {
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(URL,USER,PASS);
				PreparedStatement psmt = con.prepareStatement(QUERY);
				psmt.setInt(1, roll);
				int i = psmt.executeUpdate();
				
				if( i > 0 )
				{
					System.out.println("Record Successfully Deleted");
				}
				
				psmt.close();
				con.close();				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
