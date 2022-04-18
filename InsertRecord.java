import java.sql.*;
import java.util.*;
public class InsertRecord {

	public static void main(String[] args) throws Exception {
		
		// create driver
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		//register the driver
		DriverManager.registerDriver(d);
		//get connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/giriclass","root","root");
		if(conn != null)
		{
			System.out.println("Connection Success...");
			
			// create statement
			Scanner sc = new Scanner(System.in);
			Statement stmt = conn.createStatement();
			System.out.println("Enter name");
			String name = sc.nextLine();
			System.out.println("Enter email");
			String email = sc.nextLine();
			System.out.println("Enter salary");
			int salary = sc.nextInt();
			int value = stmt.executeUpdate("insert into employee values('0','"+name+"','"+email+"',"+salary+")");
			
			//int value = stmt.executeUpdate("insert into employee values('0','omkar','omkar@gmail.com',10000)");
			
			// check update
			if(value > 0)
			{
				System.out.println("Updated success......");
			}
			else
			{
				System.out.println("Update failed....");
			}
		}
		else
		{
			System.out.println("Connection Failed....");
		}

	}

}
