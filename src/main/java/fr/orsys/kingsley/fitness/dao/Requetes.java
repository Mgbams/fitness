package fr.orsys.kingsley.fitness.dao;

public class Requetes {
    
    public static final String AJOUT_TAPIS = "INSERT INTO tapis (numeroSerie, designation) VALUES (?, ?)";
    public static final String AJOUT_ADHERENT = "INSERT INTO adherent (nom, prenom, email, motDePasse) VALUES (?, ?, ?, ?)";
    public static final String AJOUT_COURSE = "INSERT INTO course (calories, dateHeureDebut, dureeEnMinutes, distanceEnMetres, idAdherent, idTapis) VALUES (?, ?, ?, ?, ?, ?)";
    
    public static final String RECUPERATION_TAPIS = "SELECT idTapis, numeroSerie, designation from tapis";
    public static final String RECUPERATION_TAPIS_PAR_ID = "SELECT idTapis, numeroSerie, designation from tapis WHERE idTapis = ?";

    public static final String RECUPERATION_ADHERENT = "SELECT idAdherent, nom, prenom, email, motDePasse from adherent";
    public static final String RECUPERATION_ADHERENT_PAR_ID = "SELECT idAdherent, nom, prenom, email, motDePasse from adherent WHERE idAdherent = ?";
    public static final String RECUPERATION_ADHERENT_PAR_EMAIL_ET_MOT_DE_PASSE = "SELECT idAdherent, nom, prenom, email, motDePasse from adherent WHERE email=? AND motDePasse=?";
    
    public static final String RECUPERATION_COURSE = "SELECT idCourse, calories, dateHeureDebut, dureeEnMinutes, distanceEnMetres, idAdherent, idTapis from course";   
    public static final String RECUPERATION_COURSE_PAR_ID = "SELECT idCourse, calories, dateHeureDebut, dureeEnMinutes, distanceEnMetres, idAdherent, idTapis from course WHERE idCourse = ?";
    public static final String RECUPERATION_COURSE_PAR_ADHERENT_ET_DATE = "SELECT idCourse, calories, dateHeureDebut, dureeEnMinutes, distanceEnMetres, idAdherent, idTapis from course WHERE idAdherent=? AND dateHeureDebut BETWEEN ? AND ? ORDER BY dateHeureDebut";

    public static final String UPDATE_TAPIS = "UPDATE tapis SET numeroSerie=?, designation=? WHERE idTapis=?";
    public static final String UPDATE_ADHERENT = "UPDATE adherent SET nom=?, prenom=?, email=?, motDePasse=? WHERE idAdherent=?";
    public static final String UPDATE_COURSE = "UPDATE course SET calories=?, dateHeureDebut=?, dureeEnMinutes=?, distanceEnMetres=?, idAdherent=?, idTapis=? WHERE idCourse=?";
    
    public static final String DELETE_TAPIS = "DELETE from tapis WHERE idTapis=?";
    public static final String DELETE_ADHERENT = "DELETE from adherent WHERE idAdherent=?";
    public static final String DELETE_COURSE = "DELETE from course WHERE idCourse=?";
    
}