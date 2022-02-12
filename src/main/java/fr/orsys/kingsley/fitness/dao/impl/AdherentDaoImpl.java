package fr.orsys.kingsley.fitness.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.orsys.kingsley.fitness.business.Adherent;
import fr.orsys.kingsley.fitness.dao.AdherentDao;
import fr.orsys.kingsley.fitness.dao.ConnexionBdd;
import fr.orsys.kingsley.fitness.dao.Requetes;

public class AdherentDaoImpl implements AdherentDao {
    
    private Connection connection;
    
    public AdherentDaoImpl() {
        try {
            connection = ConnexionBdd.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Adherent create(Adherent adherent) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.AJOUT_ADHERENT, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, adherent.getNom());
        ps.setString(2, adherent.getPrenom());
        ps.setString(3, adherent.getEmail());
        ps.setString(4, adherent.getMotDePasse());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        
        if (rs.next()) {
            adherent.setId(rs.getLong(1));
        }
        
        return adherent;
    }
    
    @Override
    public List<Adherent> findAll() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.RECUPERATION_ADHERENT);
        ResultSet rs = ps.executeQuery();
        
        List<Adherent> adherents = new ArrayList<>();
        
        while (rs.next()) {
            Long id = rs.getLong("idAdherent");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String email = rs.getString("email");
            String motDePasse = rs.getString("motDePasse");
            adherents.add(new Adherent(id, nom, prenom, email, motDePasse));
        }
        return adherents;
    }
    
    @Override
    public Adherent findOne(Long id) throws SQLException {
        String query = Requetes.RECUPERATION_ADHERENT_PAR_ID;
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        
        Adherent adherent = null;
        
        if (rs.next()) {
            adherent = new Adherent();
            adherent.setId(rs.getLong("idAdherent"));
            adherent.setNom(rs.getString("nom"));
            adherent.setPrenom(rs.getString("prenom"));
            adherent.setEmail(rs.getString("email"));
            adherent.setMotDePasse(rs.getString("motDePasse"));
        }
        return adherent;
    }

	@Override
    public Adherent findByEmailAndMotDePasse(String email, String motDePasse) throws SQLException {
        String query = Requetes.RECUPERATION_ADHERENT_PAR_EMAIL_ET_MOT_DE_PASSE;
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, motDePasse);
        ResultSet rs = ps.executeQuery();
        
        Adherent adherent = null;
        
        if (rs.next()) {
            adherent = new Adherent();
            adherent.setId(rs.getLong("idAdherent"));
            adherent.setNom(rs.getString("nom"));
            adherent.setPrenom(rs.getString("prenom"));
            adherent.setEmail(rs.getString("email"));
            adherent.setMotDePasse(rs.getString("motDePasse"));
        }
        return adherent;
    }

    @Override
    public Adherent update(Adherent adherent) throws SQLException {
    	
        PreparedStatement ps = connection.prepareStatement(Requetes.UPDATE_ADHERENT);
        
        ps.setString(1, adherent.getNom());
        ps.setString(2, adherent.getPrenom());
        ps.setString(3, adherent.getEmail());
        ps.setString(4, adherent.getMotDePasse());
        ps.setLong(5, adherent.getId());
        
        ps.executeUpdate();
        return adherent;
    }
    
    @Override
    public boolean delete(Adherent adherent) throws SQLException {
        
        boolean estPresent = false;
        
        if (findOne(adherent.getId()) != null){
        
            PreparedStatement ps = connection.prepareStatement(Requetes.DELETE_ADHERENT);
            ps.setLong(1, adherent.getId());
            ps.executeUpdate();
            estPresent = true;
        }
    
        return estPresent;
    }
    
}