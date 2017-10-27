package entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
	private String nomProduit;
	private String descriptionProduit;
	private String imageUrlProduit;
	private int prixProduit;
	//mappedBy sur la classe la plus faible = plusieurs produits dans commande NON plusieurs commandes dans produits
	@ManyToMany(mappedBy="produits")
	private Set<Commande> commandes;
	
	public Produit() 
	{
		
	}

	public Produit(String nomProduit, String descriptionProduit, String imageUrlProduit, int prixProduit) {
		super();
		this.nomProduit = nomProduit;
		this.descriptionProduit = descriptionProduit;
		this.imageUrlProduit = imageUrlProduit;
		this.prixProduit = prixProduit;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getDescriptionProduit() {
		return descriptionProduit;
	}

	public void setDescriptionProduit(String descriptionProduit) {
		this.descriptionProduit = descriptionProduit;
	}

	public String getImageUrlProduit() {
		return imageUrlProduit;
	}

	public void setImageUrlProduit(String imageUrlProduit) {
		this.imageUrlProduit = imageUrlProduit;
	}

	public int getPrixProduit() {
		return prixProduit;
	}

	public void setPrixProduit(int prixProduit) {
		this.prixProduit = prixProduit;
	}
	
	

}
