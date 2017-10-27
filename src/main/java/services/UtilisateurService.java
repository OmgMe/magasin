package services;


import entities.Utilisateur;

public interface UtilisateurService {
	// CRUD
		Utilisateur create(Utilisateur utilisateur);
		Utilisateur login(String email, String mdp);
}
