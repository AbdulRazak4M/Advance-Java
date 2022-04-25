import java.sql.*;
import java.util.*;

public class DeleteRecord {

	public static void main(String[] args) throws Exception {
		// Create Driver object
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		// register Driver
		DriverManager.registerDriver(d);
		// connection 
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/giriclass","root","root");
		
		if(conn != null)
		{
			System.out.println("Connected");
			
			// create statement
			Statement stmt = conn.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Emial id");
			String email = sc.nextLine();
			int value = stmt.executeUpdate("Delete from employee where email = '"+email+"'");
			
			if(value > 0)
			{
				System.out.println("Deleted Successfully");
			}
			else
			{
				System.out.println("Not deleted...");
			}
		}
		else
		{
			System.out.println("Not connected");
		}
		
		

	}

}
