package repositories.implementations;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.EMF;
import entities.Role;
import entities.Utilisateur;
import repositories.UtilisateurRepository;

public class UtilisateurRepositoryImplementation implements UtilisateurRepository{
	

	public Utilisateur create(Utilisateur utilisateur) {
		EntityManager em = EMF.getEM();
		Role role = em.find(Role.class, 2L);
		utilisateur.setRole(role);
		em.getTransaction().begin();
		em.persist(utilisateur);
		em.getTransaction().commit();
		return utilisateur;
	}

	public Utilisateur login(String email, String mdp) {
		EntityManager em = EMF.getEM();
		Utilisateur user = null;
		// FROM User(User = l'entité pas le nom de la table) 
		Query query = em.createQuery("select u from Utilisateur u where u.email LIKE :email and u.mdp LIKE :mdp");
		query.setParameter("email", email);
		query.setParameter("mdp", mdp);
		
		try {
			user = (Utilisateur)query.getSingleResult();
		} catch (Exception e) {
			
		}
		System.out.println(user.toString());
		return user;
	}
	
	/*public Utilisateur login(String login, String password)
	{
		EntityManager em = EMF.getEM();
		// FROM User(User = l'entité pas le nom de la table) 
		Query query = em.createQuery("select u from Utilisateur u where u.email LIKE :login and u.password LIKE :password");
		query.setParameter("login", login);
		query.setParameter("password", password);
		Utilisateur user = (Utilisateur)query.getSingleResult();
		//em.createNamedQuery(User.class);
		return user;
	}*/

}
