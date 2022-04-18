import java.sql.*;

public class DatabaseApplication {

	public static void main(String[] args) throws Exception {
		// create Diver object
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		// register the driver object
		DriverManager.registerDriver(d);
		// create connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marchtest","root","root");
		
		// check connection successful or not
		if(con!=null)
		{
			System.out.println("Connected Succesfully...");
			Statement st = con.createStatement();
			/*int val = st.executeUpdate("insert into tblemployee values ('0', 'ghanshyam', 'ghanshu@gmail.com','8877996688', 2,20000)");
			if(val > 0)
			{
				System.out.println("Update successfully.....");
			}
			else
			{
				System.out.println("Not update....");
			}*/
			int val2 = st.executeUpdate("alter table tblemployee add nation varchar(20) default 'india' ");
		}
		else
		{
			System.out.println("not Connected...");
		}
		
	}

}
