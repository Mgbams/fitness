package fr.orsys.kingsley.fitness.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import fr.orsys.kingsley.fitness.business.Adherent;
import fr.orsys.kingsley.fitness.business.Course;

public interface CourseDao {
    
    Course create(Course course) throws SQLException;
    
    List<Course> findAll() throws SQLException;
    
    Course findOne(Long id) throws SQLException;

    List<Course> findByAdherentAndDateHeureDebutBetween(Adherent adherent, Date dateDebut, Date dateFin) throws SQLException;

    Course update(Course course)  throws SQLException;
    
}
