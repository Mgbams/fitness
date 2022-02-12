package fr.orsys.kingsley.fitness.util;

import java.util.Comparator;

import fr.orsys.kingsley.fitness.business.Course;

public class ComparateurDeCourseSurDate implements Comparator<Course> {
	
	@Override
	public int compare(Course course1, Course course2) {
		return course1.getDateHeureDebut().compareTo(course2.getDateHeureDebut());
	}

}
