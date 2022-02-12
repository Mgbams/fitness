package fr.orsys.kingsley.fitness.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.orsys.kingsley.fitness.business.Tapis;
import fr.orsys.kingsley.fitness.dao.ConnexionBdd;
import fr.orsys.kingsley.fitness.dao.Requetes;
import fr.orsys.kingsley.fitness.dao.TapisDao;

public class TapisDaoImpl implements TapisDao {
    
    private Connection connection;
    
    public TapisDaoImpl() {
        try {
            connection = ConnexionBdd.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public Tapis create(Tapis tapis) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.AJOUT_TAPIS, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, tapis.getNumeroSerie());
        ps.setString(2, tapis.getDesignation());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        
        if (rs.next()) {
            tapis.setId(rs.getLong(1));
        }
        
        return tapis;

    }
    
    @Override
    public List<Tapis> findAll() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.RECUPERATION_TAPIS);
        ResultSet rs = ps.executeQuery();
    
        List<Tapis> tapis = new ArrayList<>();
    
        while (rs.next()) {
            Long id = rs.getLong("idTapis");
            String numeroSerie = rs.getString("numeroSerie");
            String designation = rs.getString("designation");
        
            tapis.add(new Tapis(id, numeroSerie, designation));
        }
        return tapis;
    }
    
    @Override
    public Tapis findOne(Long id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.RECUPERATION_TAPIS_PAR_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
    
        Tapis tapis = null;
    
        if (rs.next()) {
        	tapis = new Tapis();
            tapis.setId(rs.getLong("idTapis"));
            tapis.setNumeroSerie(rs.getString("numeroSerie"));
            tapis.setDesignation(rs.getString("designation"));        
        }
        return tapis;

    }
        
}