package com.project.client;

import com.project.model.CourseModel;
import com.project.service.*;
import java.util.*;

public class ClientApplication {

	public static void main(String[] args) {
		CourseService cs = new CourseService();
		AdmissionService as = new AdmissionService();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1:New Course");
			System.out.println("2:New Admission");
			System.out.println("3:View Admission");
			System.out.println("4:view Courses");
			System.out.println("5:View Course Wise Admission");
			System.out.println("6:Search Admission by name");
			System.out.println("7:Display the number of admission course wise");
			System.out.println("8:Display the course whose admission count is greater than 3");
			System.out.println("9: show the course name whose fees is second higest in all courses");
			System.out.println("10: show the all courses and admissions");
			System.out.println("------------------------------------------");
			System.out.println("Select Operation");
			int choice = sc.nextInt();
			sc.nextLine();
			//switch case
			switch(choice)
			{
			case 1:
			{
				System.out.println("Enter CourseName");
				String name = sc.nextLine();
				System.out.println("Enter Course Duration");
				int duration = sc.nextInt();
				System.out.println("Enter Course Fees");
				int fees = sc.nextInt();
				CourseModel cm = new CourseModel();
				cm.setCourseName(name);
				cm.setDuration(duration);
				cm.setFees(fees);
				boolean b = cs.isAddNewCourse(cm);
				if(b)
				{
					System.out.println("Course Added Successfully");
					System.out.println("*********************************\n");
				}
				else
				{
					System.out.println("Course Not Added");
					System.out.println("*********************************\n");
				}
			}
				break;
			case 2:
			{
				
			}
				break;
			case 3:
			{
				
			}
				break;
			case 4:
			{
				
			}
				break;
			case 5:
			{
				
			}
				break;
			case 6:
			{
				
			}
				break;
			case 7:
			{
				
			}
				break;
			case 8:
			{
				
			}
				break;
			case 9:
			{
				
			}
				break;
			case 10:
			{
				
			}
				break;
			default:
			{
				System.out.println("Wrong choice...");
			}
					
			
			}
		}while(true);

	}

}
