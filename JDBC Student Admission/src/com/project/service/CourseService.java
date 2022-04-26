package com.project.service;

import com.project.repository.*;
import com.project.model.*;

public class CourseService {

	CourseRepository crs = new CourseRepository();
	public boolean isAddNewCourse(CourseModel model)
	{
		if(model.getFees() <= 10000)
		{
			return false;
		}
		else {
			boolean b = crs.isAddNewCouser(model);
			return b;
		}
	}
}
