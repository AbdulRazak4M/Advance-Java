import java.sql.*;
import java.util.*;

public class CreateTableInDatabase {

	public static void main(String[] args) throws Exception {
		//create driver Application
			com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
			
			//Register Driver
			DriverManager.registerDriver(d);
			//create connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/giriclass","root","root");
			
			// check connection
			if(conn != null)
			{
				System.out.println("Connected successfully...");
				//create statement
				Statement stmt = conn.createStatement();
				// create table through user
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the statement to create table");
				String st = sc.nextLine();
				
				int value = stmt.executeUpdate(st);
				if(value>0)
				{
					System.out.println("created succesffuly");
				}
				else
				{
					System.out.println("Table not created");
				}
				
			}
			else
			{
				System.out.println("Conection failed.....");
			}
		
	}

}
