package fr.orsys.kingsley.fitness.dao;

import java.sql.SQLException;
import java.util.List;

import fr.orsys.kingsley.fitness.business.Adherent;

public interface AdherentDao {
    
    Adherent create(Adherent adherent) throws SQLException;
    
    List<Adherent> findAll() throws SQLException;
    
    Adherent findOne(Long id) throws SQLException;

	Adherent findByEmailAndMotDePasse(String email, String motDePasse) throws SQLException;

    Adherent update(Adherent adherent) throws SQLException;
    
    boolean delete(Adherent adherent) throws SQLException;

}