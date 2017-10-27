package services.implementations;


import java.util.List;

import entities.Utilisateur;

import repositories.UtilisateurRepository;
import repositories.implementations.UtilisateurRepositoryImplementation;
import services.UtilisateurService;


public class UtilisateurServiceImplementation implements UtilisateurService{
	
	private UtilisateurRepository rep = new UtilisateurRepositoryImplementation();

	public Utilisateur create(Utilisateur utilisateur) {
		
				return rep.create(utilisateur);
	}
	
	public List<Utilisateur> readAll()
	{
		return rep.readAll();
	}

	public Utilisateur login(String email, String mdp) {
		
		return rep.login(email, mdp);
	}

	/*public Utilisateur login(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}
	


/*
private UtilisateurRepository rep = new UtilisateurRepository() {

public Utilisateur create(Utilisateur user) {
	// TODO Auto-generated method stub
	return null;
}
};();

public Utilisateur create(Utilisateur user) {
	
	return rep.create(user);
}

}
*/