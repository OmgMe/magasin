package entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	@Column(nullable=false, unique=true)
	private String email;
	private String mdp;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Role role;
	//mappedBy sur la classe la plus faible = plusieurs commandes dans utilisateur NON plusieurs utilisateurs dans commande
	//utilisateur = champ dans l'autre table = Commande
	@OneToMany(mappedBy="utilisateur")
	//Set de plusieurs commandes de la relation "@OneToMany(mappedBy="utilisateur")"
	private Set<Commande> Commandes;
	
	public Utilisateur() {
		
	}

	public Utilisateur(String nom, String prenom, String email, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", mdp=" + mdp
				+ ", role=" + role + ", Commandes=" + Commandes + "]";
	}

	
	
	

}
