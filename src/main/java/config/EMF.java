package config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import entities.Role;
import entities.Utilisateur;


@WebListener
public class EMF implements ServletContextListener{
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	
	public void contextInitialized(ServletContextEvent sce) {
		
		emf = Persistence.createEntityManagerFactory("MY_PU");
		setDB();
		//em=emf.createEntityManager();
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		emf.close();
	}
	
	public static EntityManager getEM()
	{
		if (em ==null)
		{
			em = emf.createEntityManager();
		}	
		return em;
	}
	
	public void populate()
	{
		
	}
	
	public void setDB()
	{
		try {
			Role roleAdmin = new Role("Administrateur");
			
			Utilisateur utilisateur = new Utilisateur("rocha", "alam", "alam@gmail.com", "abc");
			//utilisateur.getRoles().add(r);
			utilisateur.setRole(roleAdmin);
			
			EntityManager db = getEM();
			db.getTransaction().begin();
			// INSERTION
			db.persist(roleAdmin);
			
			System.out.println("avant utilisateur.getId() : "+utilisateur.getId());
			db.persist(utilisateur);
			System.out.println("apres utilisateur.getId() : "+utilisateur.getId());
			
			// RECUPERATION
			db.find(Utilisateur.class, 1l);
			db.getTransaction().commit();
			Role roleMembre = new Role("Membre");
			db.getTransaction().begin();
			db.persist(roleMembre);
			db.getTransaction().commit();
			
			
		} catch (Exception e) {
			
		}
		
	}
	
	/*
	 * 
	 * try {
				
				Role role2 = new Role();
				role.setTypeRole("Membre");
				
				
				EntityManager db2 = getEM();
				db.getTransaction().begin();
			
				db.persist(role);
				
				db.getTransaction().commit();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			*/
	
	

}
