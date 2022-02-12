package fr.orsys.kingsley.fitness.dao;

import java.sql.SQLException;
import java.util.List;

import fr.orsys.kingsley.fitness.business.Tapis;

public interface TapisDao {
    
    Tapis create(Tapis tapis) throws SQLException;
    
    List<Tapis> findAll() throws SQLException;
    
    Tapis findOne(Long id) throws SQLException;
        
}