package entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommande;
	
	private Date dateCommande;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Utilisateur utilisateur;
	@ManyToMany
	private Set<Produit> produits = new HashSet(0);
	
	public Commande() {
	
	}


	public Commande(Date dateCommande) {
		
		this.dateCommande = dateCommande;
	}
	
	
	
	
	

}
