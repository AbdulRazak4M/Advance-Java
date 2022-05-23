package org.techhub.service;

import java.sql.ResultSet;

import org.techhub.model.Vehicle;
import org.techhub.repository.VehicleRepository;

public class VehicleService {
	VehicleRepository vRepo = new VehicleRepository();
	public boolean isNewVehicle(Vehicle v) {
		try {
			return vRepo.isNewVehicle(v);
		}catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean isUpdate(String field,String val,String cond,String condVal) {
		
		try {
			return vRepo.isUpdate(field,val,cond,condVal);
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public boolean isDelete(int deleteId) {
		try {
			return vRepo.isDelete(deleteId);
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void byClassification(String classification) {
		try {
			vRepo.byClassification(classification);
		}catch(Exception e) {
			System.out.println("No Data Found");
		}
	}
}
