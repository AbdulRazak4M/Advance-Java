package com.project.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.model.*;

public class AdmissionRepository extends DBInitializer {
	public boolean isNewAdmission(AdmissionModel model) {
		String name = model.getName();
		String email = model.getEmail();
		try {
			PreparedStatement stmt = conn.prepareStatement("inset into admission values ('0', ?,?,)");
			stmt.setString(1, name);
			stmt.setString(2, email);
			int value = stmt.executeUpdate();
			if (value > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}
