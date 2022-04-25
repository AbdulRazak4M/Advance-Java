import java.sql.*;
import java.util.*;

public class SelectRecord {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		Scanner sc = new Scanner(System.in);
		// register driver
		DriverManager.registerDriver(d);
		//get connection
		System.out.println("Enter Database name");
		String database = sc.nextLine();
		System.out.println("Enter UserName");
		String user = sc.nextLine();
		System.out.println("Enter Password");
		String password = sc.nextLine();
		
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database+"",""+user+"",""+password+"");
		if(conn != null)
		{
			System.out.println("Connected");
			
			// create statement
			Statement stmt = conn.createStatement();
			System.out.println("Enter table name");
			String table = sc.nextLine();
			ResultSet rs = null;
			try {
			 rs = stmt.executeQuery("select *from "+table+"");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			
		}
		else
		{
			System.out.println("Not connected");
		}
	}

}
