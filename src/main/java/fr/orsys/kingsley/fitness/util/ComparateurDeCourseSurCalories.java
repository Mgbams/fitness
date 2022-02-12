package fr.orsys.kingsley.fitness.util;

import java.util.Comparator;

import fr.orsys.kingsley.fitness.business.Course;

public class ComparateurDeCourseSurCalories implements Comparator<Course> {
	
	@Override
	public int compare(Course course1, Course course2) {
		return Float.compare(course1.getCalories(), course2.getCalories());
	}

}
