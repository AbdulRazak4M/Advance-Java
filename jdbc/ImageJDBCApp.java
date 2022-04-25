import java.sql.*;
import java.util.*;
import java.io.*;

public class ImageJDBCApp {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Choice to perform operation");
		System.out.println("1: Insert Image into database table");
		System.out.println("2: Retrive Image from database table");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		sc.nextLine();
		String database, user, password;
		System.out.println("Enter Database name");
		database = sc.nextLine();
		System.out.println("Enter username name");
		user = sc.nextLine();
		System.out.println("Enter Password name");
		password = sc.nextLine();
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "" + database + "", "" + user + "",
				"" + password + "");
		if (conn != null) {
			switch (choice) {
			case 1: {
				File f = new File("F://HTML/images/narwhal.jpg");
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(f);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PreparedStatement stmt = conn.prepareStatement("insert into imagejdbc values('0', ?)");
				// file method length will return long
				int len = (int) f.length();
				stmt.setBinaryStream(1, fis, len);
				int value = stmt.executeUpdate();
				if (value > 0) {
					System.out.println("Record Saved");
				} else {
					System.out.println("Not saved");
				}
				fis.close();
			}
				break;
			case 2: {
				int i = 0;
				File f = new File("C:/Users/Admin/eclipse-workspace/JDBC/src/images/"+1+".jpeg");
				FileOutputStream fout = new FileOutputStream(f);
				PreparedStatement stmt = conn.prepareStatement("select *from imagejdbc where image is not null");
				byte[] b=null;
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					InputStream in = rs.getBinaryStream(2);
					int data;
					while((data =in.read() )!= -1)
					{
						fout.write(data);
					}
					/*Blob img = rs.getBlob("image");
					b = img.getBytes(1,(int)img.length());
					fout.write(b);*/
					i++;
				}
				System.out.println("Image retrieving success");
				fout.close();
				stmt.close();
			}
			}
		} else {
			System.out.println("Database not connected");
		}
	}

}
