package fr.orsys.kingsley.fitness.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.orsys.kingsley.fitness.business.Adherent;
import fr.orsys.kingsley.fitness.business.Course;
import fr.orsys.kingsley.fitness.business.Tapis;
import fr.orsys.kingsley.fitness.dao.AdherentDao;
import fr.orsys.kingsley.fitness.dao.ConnexionBdd;
import fr.orsys.kingsley.fitness.dao.CourseDao;
import fr.orsys.kingsley.fitness.dao.Requetes;
import fr.orsys.kingsley.fitness.dao.TapisDao;

public class CourseDaoImpl implements CourseDao {
    
    private Connection connection;
    private TapisDao tapisDao;
    private AdherentDao adherentDao;
    
    public CourseDaoImpl() {
        try {
            connection = ConnexionBdd.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        tapisDao = new TapisDaoImpl();
        adherentDao = new AdherentDaoImpl();
    }
    
    @Override
    public Course create(Course course) throws SQLException {
    
        PreparedStatement ps = connection.prepareStatement(Requetes.AJOUT_COURSE, Statement.RETURN_GENERATED_KEYS);
        ps.setFloat(1, course.getCalories());
        ps.setTimestamp(2, java.sql.Timestamp.valueOf(course.getDateHeureDebut()));
        ps.setInt(3, course.getDureeEnMinutes());
        ps.setInt(4, course.getDistanceEnMetres());
        ps.setLong(5, course.getAdherent().getId());
        ps.setLong(6, course.getTapis().getId());
        
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        
        if (rs.next()) {
            course.setId(rs.getLong(1));
        }
        return course;
    }
    
    @Override
    public List<Course> findAll() throws SQLException {
        
        PreparedStatement ps = connection.prepareStatement(Requetes.RECUPERATION_COURSE);
        ResultSet rs = ps.executeQuery();
    
        List<Course> courses = new ArrayList<>();
    
        while (rs.next()) {
            Long idCourse = rs.getLong("idCourse");
            float calories = rs.getFloat("calories");
            LocalDateTime dateHeureDebut = rs.getTimestamp("dateHeureDebut").toLocalDateTime();
            int dureeEnMinutes = rs.getInt("dureeEnMinutes");
            int distanceEnMetres = rs.getInt("distanceEnMetres");
            Adherent adherent = adherentDao.findOne(rs.getLong("idAdherent"));
            Tapis tapis = tapisDao.findOne(rs.getLong("idTapis"));
            
            courses.add(new Course(idCourse, calories, dateHeureDebut , dureeEnMinutes, distanceEnMetres,
                    adherent, tapis));
        }
        
        return courses;
    }
    
    @Override
    public Course findOne(Long id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.RECUPERATION_COURSE_PAR_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
    
        Course course = null;
        if (rs.next()) {
        	course = new Course();
            course.setId(rs.getLong("idCourse"));
            course.setCalories(rs.getFloat("calories"));
            course.setDateHeureDebut(rs.getTimestamp("dateHeureDebut").toLocalDateTime());
            course.setDureeEnMinutes(rs.getInt("dureeEnMinutes"));
            course.setDistanceEnMetres(rs.getInt("distanceEnMetres"));
            course.setAdherent(adherentDao.findOne(rs.getLong("idAdherent")));
            course.setTapis(tapisDao.findOne(rs.getLong("idTapis")));            
        }
        
        return course;
    }

	@Override
	public List<Course> findByAdherentAndDateHeureDebutBetween(Adherent adherent, Date dateDebut, Date dateFin) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.RECUPERATION_COURSE_PAR_ADHERENT_ET_DATE);
        ps.setLong(1, adherent.getId());
        ps.setTimestamp(2, new java.sql.Timestamp(dateDebut.getTime()));
        ps.setTimestamp(3, new java.sql.Timestamp(dateFin.getTime()));
        ResultSet rs = ps.executeQuery();
    
        List<Course> courses = new ArrayList<>();
    
        while (rs.next()) {
            Long idCourse = rs.getLong("idCourse");
            float calories = rs.getFloat("calories");
            LocalDateTime dateHeureDebut = new java.sql.Timestamp(rs.getTimestamp("dateHeureDebut").getTime()).toLocalDateTime();
            int dureeEnMinutes = rs.getInt("dureeEnMinutes");
            int distanceEnMetres = rs.getInt("distanceEnMetres");
            Tapis tapis = tapisDao.findOne(rs.getLong("idTapis"));
            
            courses.add(new Course(idCourse, calories, dateHeureDebut , dureeEnMinutes, distanceEnMetres,
                    adherent, tapis));
        }
        
        return courses;
	}

	@Override
	public Course update(Course course) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.UPDATE_COURSE);
        
        ps.setFloat(1, course.getCalories());
        ps.setTimestamp(2, java.sql.Timestamp.valueOf(course.getDateHeureDebut()));
        ps.setInt(3, course.getDureeEnMinutes());
        ps.setInt(4, course.getDistanceEnMetres());
        ps.setLong(5, course.getAdherent().getId());
        ps.setLong(6, course.getTapis().getId());
        ps.setLong(7, course.getId());
        
        ps.executeUpdate();
        return course;
	}
        
}