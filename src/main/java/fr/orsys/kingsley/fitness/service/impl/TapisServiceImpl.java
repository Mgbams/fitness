package fr.orsys.kingsley.fitness.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.orsys.kingsley.fitness.business.Tapis;
import fr.orsys.kingsley.fitness.dao.TapisDao;
import fr.orsys.kingsley.fitness.dao.impl.TapisDaoImpl;
import fr.orsys.kingsley.fitness.service.TapisService;

public class TapisServiceImpl implements TapisService {

	private TapisDao tapisDao = new TapisDaoImpl();

	@Override
	public Tapis ajouterTapis(Tapis tapis) {
		try {
			return tapisDao.create(tapis);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Tapis recupererTapis(Long id) {
		try {
			return tapisDao.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Tapis> recupererDesTapis() {
		try {
			return tapisDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
