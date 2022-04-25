import java.io.*;
import java.util.*;
import java.sql.*;
public class PropertiesApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream fin = new FileInputStream("giriclassData.prop");
		Properties p = new Properties();
		p.load(fin);
		String driver = p.getProperty("driver").toString();
		String url =p.getProperty("url").toString();
		String user = p.getProperty("user").toString();
		String password = p.getProperty("password").toString();
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,password);
		if(conn != null)
		{
			System.out.println("Connected");
			
		}
		else
		{
			System.out.println("Not connceted");
		}
	}

}
