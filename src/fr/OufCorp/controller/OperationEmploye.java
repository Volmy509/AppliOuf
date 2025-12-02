package fr.OufCorp.controller;
 
import fr.OufCorp.model.*;
 
 
import fr.OufCorp.view.*;
 
import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;
 
public class OperationEmploye {
	public static List<Person> listPerson = new ArrayList<Person>();
 
	public static void gererEmployeAdmin() {
		System.out.println("Taille de listPerson: " + listPerson.size());
		for (Person p : listPerson) {
			System.out.println("Personne présente: " + p.infoPerson());
		}
		boolean continuer = true;
		int choix = MyLibrary.saisirEntier("Que voulez vous faire: " + "\n \n0- Retourner au menu "
				+ "\n \n1- Créer un employé" + "\n \n2- Modifier un employé" + "\n \n3- Supprimer un employé"
				+ "\n \n4- Afficher tout les employés" + "\n\n5- Se déconnecter");
		switch (choix) {
		case 0:
			Menu.MenuAdmin();
			break;
		case 1:
			// METHODE POUR CREER UN EMPLOYEE
			createEmploye();
			break;
		case 2:
			// METHODE POUR MODIFIER UN EMPLOYEE
			editEmploye();
			break;
		case 3:
			// METHODE POUR SUPPRIMER UN EMPLOYEE
			deleteEmploye();
			break;
		case 4:
			// METHODE POUR AFFICHER TOUT LES EMPLOYEES
			listPerson();
			break;
		case 5:
		default:
			continuer = false;
			Menu.afterLogout();
			break;
		}
	}
 
	// METHODE QUI PERMET DE SE CONNECTER
	public static Person connexion() {
		Person person = null;
		JOptionPane.showMessageDialog(null, "Bienvenue a vous sur l'AppliOuf \nPour vous connecter cliquer sur OK");
		String login = MyLibrary.saisir("Saisissez votre identifiant ");
		String password = MyLibrary.saisir("Saisissez votre mot de passe: ");
 
		for (Person p : listPerson) {
			if (p.getIdentifiant().equals(login) && p.getPassword().equals(password)) {
				Program.personneConnecte = p;
				person = p;
 
				for (Carte c : OperationCarte.listCarte) {
					if (c.gettitulaire().equals(p)) {
						Program.titulaireConnecte = c;
						break;
					}
				}
 
			}
		}
		return person;
	}
 
	// METHODE POUR CREER UN EMPLOYEE
	public static Person createEmploye() {
	    String Nom = MyLibrary.saisir("Entrez le nom du nouvel employé ");
	    String Prenom = MyLibrary.saisir("Entrez le Prénom du nouvel employé ");
	    String Identifiant = MyLibrary.saisir("Entrez l'identifiant du nouvel employé ");
	    String Password = generatePassword();
	    String TypeOfCard = MyLibrary.saisir("Carte Standard \n\n Ou \n\n Carte Gold");
	    System.out.println("Le mot de passe du compte créé est : " + Password);
	    Role role = OperationRole.getRoleByRoleName("Employe".toUpperCase());

	   
	    Person p = new Person(Nom, Prenom, Identifiant, Password, role);
	    listPerson.add(p);
	    
	    // Créer la carte pour cette personne
	    String numCarte = OperationCarte.generateNumCarte();
	    Carte c = new Carte(numCarte, TypeOfCard, 50.0, p);
	    OperationCarte.listCarte.add(c);
	    
	    MyLibrary.afficher("Carte créée pour " + p.getNom() + " " + p.getPrenom() + 
	                      " avec le numéro : " + numCarte);
	    
	    return p;
	}
 
	// METHODE POUR MODIFIER UN EMPLOYEE
	public static void editEmploye() {
		String editEmploye = MyLibrary.saisir("Entre l'identifiant de la personne a modifier");
		Person user = searchPerson(editEmploye);
 
		if (user != null) {
			String nom = MyLibrary.saisir("Entrez le nouveau nom de la personne");
			String prenom = MyLibrary.saisir("Entrez le nouveau prenom de la personne");
			String Identifiant = MyLibrary.saisir("Entrez le nouvel identifiant de la personne");
 
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setIdentifiant(Identifiant);
 
			MyLibrary.afficher("La personne a bien été modifier: " + "Nom: " + user.getNom() + " Prénom: "
					+ user.getPrenom() + " Identifiant: " + user.getIdentifiant());
		} else {
			MyLibrary.afficher("Aucune personne ne correspond a votre recherche");
		}
	}
 
	// METHODE POUR SUPPRIMER UN EMPLOYEE
	public static void deleteEmploye() {
 
		Person user = searchPerson(MyLibrary.saisir("Entrez l'identifant de la personne que vous souhaitez supprimer"));
		if (user != null) {
			listPerson.remove(user);
			MyLibrary.afficher("La personne à bien été supprimer");
		} else {
			MyLibrary.afficher("La personne que vous souhaiter supprimer n'a pas été trouvé");
 
		}
	}
 
	// /////////////////////////////////////////////////////METHODE UTILS --
 
	// METHODE QUI GENERE UN "Password" ALEATOIRE
	private static String generatePassword() {
		String password = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		for (int i = 0; i < 8; i++) {
			password += alphabet.charAt((int) (Math.random() * alphabet.length()));
		}
		return password;
	}
 
	// METHODE POUR RECHERCHER UN EMPLOYEE
	public static Person searchPerson(String Identifiant) {
		Person pe = null;
		for (Person p : listPerson) {
			if (p.getIdentifiant().equals(Identifiant)) {
				pe = p;
			}
		}
		return pe;
	}
 
	// METHODE POUR TRANSFERER DE L'ARGENT A UN COLLEGUE
	public static void transfertMoney() {
		Person personne = Program.personneConnecte;
 
		if (personne == null) {
			MyLibrary.afficher("Aucun utilisateur connecté !");
			return;
		}
		Carte virant = Program.titulaireConnecte;
 
		String numCarte = MyLibrary.saisir("Entrez le numero de la carte sur laquelle vous souhaitez envoyez de l'argent");
		Carte destinataire = OperationCarte.searchCarte(numCarte);
 
 
		if (virant != null && destinataire != null) {
			double montant = MyLibrary.saisirDouble("Entrez la somme que vous voulez virer");
			if (montant > 0 && virant.getSolde() >= montant) {
				destinataire.setSolde(destinataire.getSolde() + montant);
				virant.setSolde(virant.getSolde() - montant);
				MyLibrary.afficher(
						"Virement effectué ! " + "\n\n Nouveau solde de votre compte : " + virant.getSolde() + " €");
				System.out.println("Nouveau solde du compte bénéficiaire : " + destinataire.getSolde() + " €");
			} else {
				MyLibrary.afficher("Montant invalide ou solde insuffisant.");
			}
		} else {
			MyLibrary.afficher("Erreur lors de la récupération des comptes.");
		}
	}
 
	// METHODE POUR LISTER LES EMPLOYES
	public static void listPerson() {
		String vide = " ";
 
		for (Person p : listPerson) {
			if (p.getrole().getnomRole().equals("EMPLOYE")) {
				vide += p.infoPerson() + "\n";
			}
		}
		if (vide.length() == 0) {
			MyLibrary.afficher("Aucune personne n'a été trouvé");
		} else {
			MyLibrary.afficher(vide);
		}
 
	}
 
	// METHODE QUI PERMET DE RECUPERER TOUT LES EMPLOYE
	public static Person getClientByIdentifiant(String Identifiant) {
		Person person = null;
		for (Person p : listPerson) {
			if (p.getIdentifiant().equals(Identifiant) && p.getrole().getnomRole().equals("EMPLOYE")) {
				person = p;
			}
		}
		return person;
	} 
}