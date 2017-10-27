package repositories;

import entities.Utilisateur;

public interface UtilisateurRepository {
	// CRUD
			Utilisateur create(Utilisateur utilisateur);
			Utilisateur login(String email, String mdp);
}
