package fr.OufCorp.model;
 
import fr.OufCorp.controller.*;
import fr.OufCorp.view.*;
 
//CREATION DE L'OBJET "carte" AVEC SES ATTRIBUTS
 
public class Carte {
	private String numCarte;
	private String TypeOfCard;
	private double Solde;
	private Person titulaire;
 
// CONSTRUCTEUR PLEIN ET VIDE
 
	public Carte(String numCarte, String TypeOfCard, double Solde, Person titulaire) {
		this.numCarte = numCarte;
		this.TypeOfCard = TypeOfCard;
		this.Solde = Solde;
		this.titulaire = titulaire;
 
	}
 
	public Carte() {
 
	}
 
	// GETTERS ET SETTER PERMETTANT LA RECUPERATION DES ELEMENTS
	public String getnumCarte() {
		return numCarte;
	}
 
	public String getTypeOfCard() {
		return TypeOfCard;
	}
 
	public double getSolde() {
		return Solde;
	}
 
	public Person gettitulaire() {
		return titulaire;
	}
 
	public void setTypeOfCard(String TypeOfCard) {
		this.TypeOfCard = TypeOfCard;
	}
 
	public void setSolde(double Solde) {
		this.Solde = Solde;
	}
 
	public void setnumCarte(String numCarte) {
		this.numCarte = numCarte;
	}
 
	public void settitulaire(Person titulaire) {
		this.titulaire = titulaire;
	}
 
	public String infoCarte() {
		return "Votre Carte est une Carte " + getTypeOfCard() + " \nAvec un solde de: " + Solde + " €"
				+ " \nNumero de la carte :" + numCarte + " \nAppartient à : " + titulaire.infoPerson();
	}
}