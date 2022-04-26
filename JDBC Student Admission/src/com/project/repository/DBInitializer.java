package com.project.repository;

import java.sql.*;
import java.util.*;
import java.io.*;

public class DBInitializer {
	protected Connection conn =null;
	protected FileInputStream fin = null;
	Scanner sc = new Scanner(System.in);
	// create constructor to load driver while creating object
	public DBInitializer() {
		try {
			fin = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\JDBC Student Admission\\src\\jdbc_admission.prop");
			Properties p = new Properties();
			p.load(fin);
			// get login details from propertis files
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
