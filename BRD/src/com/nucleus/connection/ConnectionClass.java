package com.nucleus.connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionClass implements ConnectionInterface {
	static Connection con;
	public Connection getConnection()
	{
		Properties prop=new Properties();
		InputStream is=null;
		Connection con=null;
		try{
			is=new FileInputStream("D:\\Sh\\BRD\\config.properties");
			prop.load(is);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("pass"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}


}

