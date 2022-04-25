import java.sql.*;
import java.util.*;

public class ProcedureCallableApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		// take database name and login information
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Database name");
		String database = sc.nextLine();
		System.out.println("Enter UserName");
		String user = sc.nextLine();
		System.out.println("Enter Password");
		String password = sc.nextLine();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database+"", ""+user+"", ""+password+"");
		if(conn != null)
		{
			System.out.println("Database Connected");
			// variables to set values in procedure
			System.out.println("Enter name, Email and Salary");
			String name = sc .nextLine();
			String email = sc.nextLine();
			int salary = sc.nextInt();
			
			// Callable statement to call procedure
			CallableStatement stmt = conn.prepareCall("{call addEmployee('0',?,?,?)}");
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setInt(3, salary);
			
			boolean b = stmt.execute();
			if(!b)
			{
				System.out.println("Record Inserted");
			}
			else
			{
				System.out.println("Not inserted");
			}
			
			stmt =conn.prepareCall("{call showEmployee}");
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
		}
		else
		{
			System.out.println("Database Not connected");
		}
	}

}
