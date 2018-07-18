package com.nucleus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nucleus.connection.ConnectionInterface;
import com.nucleus.connection.FactoryClass;

public class UserCrud {
	public Connection con = null;
	PreparedStatement pst = null;
	String role;

	public String FindDB(String u, String p) {
		// System.out.println("aaa bhi rha hai ya ni");
		// getCon();
		FactoryClass fc = new FactoryClass();
		ConnectionInterface cc = fc.factoryMethod("oracle");
		con = cc.getConnection();
		//System.out.println("find db ");
		try {

			/*
			 * String s="select * from customertable2410 where username=?";
			 * 
			 * 
			 * System.out.println(s);
			 */

			pst = con
					.prepareStatement("select * from customertable2410 where username=?");
			pst.setString(1, u);
			ResultSet rs = pst.executeQuery();

			//System.out.println("LLLLLL");
			if (rs.next()) {
				//System.out.println("Welcome inside while");
				String username = rs.getString(1);
				//System.out.println(username);
				String password = rs.getString(2);
				//System.out.println(password);
				role = rs.getString(3);
				//System.out.println(role);
				//System.out.println("Role=" + role);
				if (username.equalsIgnoreCase(u)
						&& (password.equalsIgnoreCase(p))) {
					return role;
				}
			}
		}

		catch (Exception e) {
			//System.out.println("Inside FindDB ");
			e.printStackTrace();
		}
		return role;
	}
}
