package fr.OufCorp.model;
 
public class Produits {
	// CREATION DE L'OBJET "Produits" AVEC SES ATTRIBUTS
	private String Id;
	private String Nom;
	private String Marque;
	private double prix;
	private int Quantite;
	private Categorie Categorie;
 
	// CONSTRUCTEUR PLEIN ET VIDE
	public Produits(String Id, String Nom, String Marque, double prix, int Quantite, Categorie Categorie) {
		this.Id = Id;
		this.Nom = Nom;
		this.Marque = Marque;
		this.prix = prix;
		this.Quantite = Quantite;
		this.Categorie = Categorie;
	}
 
	public Produits() {
 
	}
 
	// GETTERS ET SETTER PERMETTANT LA RECUPERATION/MODIFICATION DES ELEMENTS
	public String getId() {
		return Id;
	}
 
	public String getNom() {
		return Nom;
	}
 
	public String getMarque() {
		return Marque;
	}
 
	public double getprix() {
		return prix;
	}
 
	public Categorie getCategorie() {
		return Categorie;
	}
 
	public int getQuantite() {
		return Quantite;
	}
 
	public void setId() {
		this.Id = Id;
	}
 
	public void setNom() {
		this.Nom = Nom;
	}
 
	public void setMarque() {
		this.Marque = Marque;
	}
 
	public void setprix() {
		this.prix = prix;
	}
 
	public void setQuantite(int Qauntite) {
		this.Quantite = Quantite;
	}
 
	public void setCategorie() {
		this.Categorie = Categorie;
	}
 
	public String infoProduits() {
		return "Id: " + Id + " Nom: " + Nom + " Marque: " + Marque + " Quantité en stock: " + Quantite + " Categorie: "
				+ Categorie.getnomCategorie();
	}
}