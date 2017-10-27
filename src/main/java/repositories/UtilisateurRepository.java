package repositories;

import java.util.List;

import entities.Utilisateur;

public interface UtilisateurRepository {
	// CRUD
			Utilisateur create(Utilisateur utilisateur);
			List<Utilisateur> readAll();
			Utilisateur login(String email, String mdp);
}
