package fr.orsys.kingsley.fitness.util;

import java.util.Comparator;

import fr.orsys.kingsley.fitness.business.Course;

public class ComparateurDeCourseSurDistance implements Comparator<Course> {
	
	@Override
	public int compare(Course course1, Course course2) {
		return Integer.compare(course1.getDistanceEnMetres(), course2.getDistanceEnMetres());
	}

}
