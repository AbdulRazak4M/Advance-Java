package com.project.repository;
import java.sql.*;

import com.project.model.CourseModel;

public class CourseRepository extends DBInitializer{
	public boolean isAddNewCouser(CourseModel model) 
	{
		try {
			PreparedStatement stmt =conn.prepareStatement("insert into course values ('0',?,?,?)");
			stmt.setString(1, model.getCourseName());
			stmt.setInt(2,model.getDuration());
			stmt.setInt(3, model.getFees());
			int value = stmt.executeUpdate();
			if(value > 0)
			{
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
