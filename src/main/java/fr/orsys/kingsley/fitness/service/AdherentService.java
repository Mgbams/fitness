package fr.orsys.kingsley.fitness.service;

import java.util.List;

import fr.orsys.kingsley.fitness.business.Adherent;

public interface AdherentService {

	Adherent ajouterAdherent(Adherent adherent);

	Adherent modifierAdherent(Adherent adherent);

	boolean supprimerAdherent(Adherent adherent);
	
	List<Adherent> recupererAdherents();
	
	Adherent recupererAdherent(Long id);

	Adherent recupererAdherentParEmailEtMotDePasse(String email, String motDePasse);
	
}
