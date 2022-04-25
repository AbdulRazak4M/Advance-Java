import java.sql.*;
import java.util.*;
public class PreparedStatementSelectRecordApp {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
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
			System.out.println("Enter table Name:");
			String table = sc.nextLine();
			PreparedStatement stmt = conn.prepareStatement("select *from "+table+"");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
			}
		}

	}

}
