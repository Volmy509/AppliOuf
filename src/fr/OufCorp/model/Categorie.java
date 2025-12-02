package fr.OufCorp.model;
 
public class Categorie {
	private int ID;
	private String nomCategorie;
 
	// CONSTRUCTEUR PLEIN/VIDE
	public Categorie(int ID, String nomCategorie) {
		this.ID = ID;
		this.nomCategorie = nomCategorie;
	}
	
	public Categorie() {
		
	}
 
	// GETTERS ET SETTERS POUR LA RECUPERATION/MODIFICATION DES ELEMENTS
	public int getID() {
		return ID;
	}
	
	public String getnomCategorie() {
		return nomCategorie;
	}
 
	public void setID(int ID) {
		this.ID = ID;
	}
 
	public void setnomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
 
	// METHODE QUI AFFICHE TOUTES LES INFOS CONCERNANT LA CATEGORIE
	public String infoCategorie() {
		return " Categorie:  " + nomCategorie;
	}
 
}