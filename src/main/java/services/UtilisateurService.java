package services;


import java.util.List;

import entities.Utilisateur;

public interface UtilisateurService {
	// CRUD
		Utilisateur create(Utilisateur utilisateur);
		List<Utilisateur> readAll();
		Utilisateur login(String email, String mdp);
}
