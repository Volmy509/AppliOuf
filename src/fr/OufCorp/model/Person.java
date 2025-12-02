package fr.OufCorp.model;
 
import fr.OufCorp.controller.*;
import fr.OufCorp.view.*;
 
//CREATION DE L'OBJET "Person" AVEC SES ATTRIBUTS
public class Person {
	private String Nom;
	private String Prenom;
	private String Identifiant;
	private String Password;
	private Role role;
 
	// CONSSTRUCTEUR PLEIN ET VIDE
	public Person(String Nom, String Prenom, String Identifiant, String Password, Role role) {
		this.Nom = Nom;
		this.Prenom = Prenom;
		this.Identifiant = Identifiant;
		this.Password = Password;
		this.role = role;
 
	}
 
	public Person() {
 
	}
 
	// GETTERS ET SETTERS PERMETTANT DE RECUPERER LES ELEMENTS
	public String getNom() {
		return Nom;
	}
 
	public String getPrenom() {
		return Prenom;
	}
 
	public String getIdentifiant() {
		return Identifiant;
	}
 
	public String getPassword() {
		return Password;
	}
  
	public Role getrole() {
		return role;
	}
 
	public void setNom(String Nom) {
		this.Nom = Nom;
	}
 
	public void setPrenom(String Prenom) {
		this.Prenom = Prenom;
	}
 
	public void setIdentifiant(String Identifiant) {
		this.Identifiant = Identifiant;
	}
 
	public void setPassword(String Password) {
		this.Password = Password;
	}
 

	public void setrole(Role role) {
		this.role = role;
	}
 
	public String infoPerson() {
		return "Nom: " + Nom + ", Prénom: " + Prenom + ", Identifiant: " + Identifiant + ", Mot De Passe: " + Password
				+ ", Rôle: " + role.getnomRole();
	}
}