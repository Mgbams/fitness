package fr.orsys.kingsley.fitness.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import fr.orsys.kingsley.fitness.business.Adherent;
import fr.orsys.kingsley.fitness.business.Course;
import fr.orsys.kingsley.fitness.dao.CourseDao;
import fr.orsys.kingsley.fitness.dao.impl.CourseDaoImpl;
import fr.orsys.kingsley.fitness.service.CourseService;

public class CourseServiceImpl implements CourseService {

	private CourseDao courseDao = new CourseDaoImpl();

	@Override
	public Course ajouterCourse(Course course) {
		try {
			return courseDao.create(course);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Course modifierCourse(Course course) {
		try {
			return courseDao.update(course);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Course recupererCourse(Long id) {
		try {
			return courseDao.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Course> recupererCoursesParAdherentEntreDates(Adherent adherent, Date dateDebut, Date dateFin) {
		try {
			return courseDao.findByAdherentAndDateHeureDebutBetween(adherent, dateDebut, dateFin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Course> recupererCourses() {
		try {
			return courseDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
