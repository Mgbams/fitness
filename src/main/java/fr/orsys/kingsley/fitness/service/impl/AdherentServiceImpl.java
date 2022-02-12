package fr.orsys.kingsley.fitness.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.orsys.kingsley.fitness.business.Adherent;
import fr.orsys.kingsley.fitness.dao.AdherentDao;
import fr.orsys.kingsley.fitness.dao.impl.AdherentDaoImpl;
import fr.orsys.kingsley.fitness.service.AdherentService;

public class AdherentServiceImpl implements AdherentService {

	private AdherentDao adherentDao = new AdherentDaoImpl();

	@Override
	public Adherent ajouterAdherent(Adherent adherent) {
		try {
			return adherentDao.create(adherent);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Adherent modifierAdherent(Adherent adherent) {
		try {
			return adherentDao.update(adherent);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean supprimerAdherent(Adherent adherent) {
		try {
			return adherentDao.delete(adherent);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Adherent recupererAdherent(Long id) {
		try {
			return adherentDao.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Adherent> recupererAdherents() {
		try {
			return adherentDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Adherent recupererAdherentParEmailEtMotDePasse(String email, String motDePasse) {
		try {
			return adherentDao.findByEmailAndMotDePasse(email, motDePasse);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
