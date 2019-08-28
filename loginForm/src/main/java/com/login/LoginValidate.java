package com.login;

import java.sql.*;

public class LoginValidate {
	public static boolean validate(String name, String pass) {
		boolean status = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","2015");
		
			PreparedStatement ps = con.prepareStatement("select username,password from admin where username=? and password=?");
			ps.setString(1, name);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
