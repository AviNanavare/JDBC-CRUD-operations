package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayUser {
	
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/testdatabase";
		String USER = "root";
		String PASS = "root";
		String QUERY = "select * from student";
		
		public void Dipslay()
		{
			try {
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(URL,USER,PASS);
				PreparedStatement psmt = con.prepareStatement(QUERY);
				ResultSet rs = psmt.executeQuery();				
				
				while(rs.next())
				{
					int id = rs.getInt("rollnum");
					String name = rs.getString("name");
					String college = rs.getString("college");
					String education = rs.getString("education");
					int fees = rs.getInt("fees");
					
					System.out.println(id+" | "+name+" | "+college+" | "+education+" | "+fees);
				}
				
				rs.close();
				psmt.close();
				con.close();				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
