package fr.orsys.kingsley.fitness.service;

import java.util.Date;
import java.util.List;

import fr.orsys.kingsley.fitness.business.Adherent;
import fr.orsys.kingsley.fitness.business.Course;

public interface CourseService {

	Course ajouterCourse(Course course);

	Course modifierCourse(Course course);
	
	List<Course> recupererCourses();
	
	Course recupererCourse(Long id);

	List<Course> recupererCoursesParAdherentEntreDates(Adherent adherent, Date dateDebut, Date dateFin);
	
}
