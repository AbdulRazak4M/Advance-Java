package org.techhub.repository;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;


public class DBInitilizer {
	protected Connection conn = null;
	protected FileInputStream fin =null;
	protected PreparedStatement stmt =null;
	Scanner sc = new Scanner(System.in);
	public DBInitilizer() {
		try {
			fin = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\JDB-Test-Vehicle\\src\\Login.prop");
			Properties p = new Properties();
			p.load(fin);
			// get login details from properties files
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			// load driver
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
	
