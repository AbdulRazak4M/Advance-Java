package org.techhub.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

import org.techhub.model.Vehicle;

public class VehicleRepository extends DBInitilizer {
	// to insert vehicle into table
	public boolean isNewVehicle(Vehicle v) {
		try {
			stmt = conn.prepareStatement("insert into vehicle values('0',?,?,?)");
			stmt.setString(1, v.getVname());
			stmt.setString(2, v.getClassification());
			stmt.setInt(3, v.getPrice());
			int value = stmt.executeUpdate();
			if (value > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Vehicle Entry Failed......");
			return false;
		}
	}
	
	//update table
	public boolean isUpdate(String field,String val,String cond,String condVal) {
		try {
			String updateQuery= "update vehicle set "+field+" = '"+val+"' where "+cond+"='"+condVal+"'";
			stmt = conn.prepareStatement(updateQuery);
			int value = stmt.executeUpdate();
			if(value > 0) {
				return true;
			}
			else {
				System.out.println("Updation failed");
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isDelete(int deleteId) {
		try {
			stmt = conn.prepareStatement("delete from vehicle where vid = ?");
			stmt.setInt(1, deleteId);
			int value = stmt.executeUpdate();
			if(value>0) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void byClassification(String classification) {
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("select *from vehicle where classification = '"+classification+"'");
			if (rs != null) {
				while (rs.next()) {
					System.out.println(rs.getInt("vid") + "\t" + rs.getString("vname") + "\t"
							+ rs.getString("classification") + "\t" + rs.getInt("price"));
				}
			} else {
				System.out.println("No Data Found");
			}
		}catch(Exception e) {
			System.out.println("No Data Found");
			e.printStackTrace();
		}
	}
}
