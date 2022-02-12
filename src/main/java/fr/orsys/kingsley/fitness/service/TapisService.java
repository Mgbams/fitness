package fr.orsys.kingsley.fitness.service;

import java.util.List;

import fr.orsys.kingsley.fitness.business.Tapis;

public interface TapisService {

	Tapis ajouterTapis(Tapis tapis);
	
	List<Tapis> recupererDesTapis();
	
	/**
	 * Cette méthode récupère le tapis dont l'id est donné en paramètre
	 * 
	 * @param id
	 * @return
	 */
	Tapis recupererTapis(Long id);
	
}
