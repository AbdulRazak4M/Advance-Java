import java.sql.*;
import java.util.*;

public class PreparedStatementInsertRecordApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Database name");
		String database = sc.nextLine();
		System.out.println("Enter UserName");
		String user = sc.nextLine();
		System.out.println("Enter Password");
		String password = sc.nextLine();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database + "", "" + user + "",
				"" + password + "");
		if (conn != null) {
			System.out.println("Database connected");
			PreparedStatement stmt = conn.prepareStatement("insert into employee values('0',?,?,?)");
			System.out.println("Enter name, email,salary");
			String name = sc.nextLine();
			String email = sc.nextLine();
			int salary = sc.nextInt();
			stmt.setString(1,name);
			stmt.setString(2, email);
			stmt.setInt(3, salary);
			
			int value = stmt.executeUpdate();
			if(value > 0)
			{
				System.out.println("Record inserted");
			}
			else
			{
				System.out.println("Record not inserted");
			}

		} else {
			System.out.println("Not conected");
		}
	}
}