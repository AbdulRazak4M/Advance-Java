package org.vehicle.client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.techhub.model.Vehicle;
import org.techhub.service.VehicleService;

public class VehicleClientApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		VehicleService vs = new VehicleService();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1: Insert Vehicle in a tabel");
			System.out.println("2:Update Vehicle Information");
			System.out.println("3:Delete Vehicle Record by vehicle Id");
			System.out.println(
					"4: Show all vehicles for Specified classification and price is greater than 100000(one lakh)");
			System.out.println(
					"--------------------------------------------------------------------------------------------------");
			System.out.println("Select Operation");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1: {
				System.out.println("Enter Vehicle Name");
				String vname = sc.nextLine();
				System.out.println("Enter Vehicle Classification Category");
				String classification = sc.nextLine();
				System.out.println("Eneter Vehicle Price");
				int price = sc.nextInt();
				Vehicle v = new Vehicle();
				v.setVname(vname);
				v.setClassification(classification);
				v.setPrice(price);
				if (price > 50000) {
					boolean b = vs.isNewVehicle(v);
					if (b) {
						System.out.println("Entry Success......");
						System.out.println(".................");
					} else {
						System.out.println("Entry Failed......");
						System.out.println(".................");
					}
				} else {
					System.out.println("Price shouldn not be less than 50000");
					System.out.println(".................");
				}

			}
				break;
			case 2: {
				System.out.println("Enter the Column Name you want to change");
				String field = sc.nextLine();
				System.out.println(".................");
				System.out.println("Enter the Column Value You Want to Set");
				String val = sc.nextLine();
				System.out.println(".................");
				System.out.println("Enter the Condition  Column");
				String cond = sc.nextLine();
				System.out.println(".................");
				System.out.println("Enter the Condition value for column");
				String condVal = sc.nextLine();
				System.out.println(".................");
				boolean b = vs.isUpdate(field, val, cond, condVal);
				if (b) {
					System.out.println("Updated successfully");
				} else {
					System.out.println("Updation Failed");
				}

			}
				break;

			case 3: {
				System.out.println("Enter Vehicle Id");
				int deleteId = sc.nextInt();
				boolean b = vs.isDelete(deleteId);
				if (b) {
					System.out.println("Deleted successfully");
				} else {
					System.out.println("Deletion Failed");
				}
			}
				break;

			case 4: {
				System.out.println("Enter the vehicle classification catgory");
				String classification = sc.nextLine();
				vs.byClassification(classification);
				

			}
				break;
			default: {
				System.out.println("Wrong Choice Please check Valid Operation");
				System.out.println(".................");
			}
			}
		} while (true);
	}

}
