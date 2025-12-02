package fr.OufCorp.view;


import fr.OufCorp.controller.*;
import fr.OufCorp.model.*; 

public class Menu {
	public static void MenuAdmin() {
		System.out.println("MENU ADMIN 👮🏾");
 
		MyLibrary.afficher("Vous êtes connecté en tant qu'Administrateur 👮🏾");
 
		boolean continuer = true;
		while (continuer) {
			int choix = MyLibrary.saisirEntier(
					"1- Gérer les employé(e)s \n\n2- Gérer les cartes \n\n3- Gérer les produits \n\n4- Gérer les menus \n\n5- Se déconnecter.");
			switch (choix) {
			case 1:
				OperationEmploye.gererEmployeAdmin();
				break;
			case 2:
				OperationCarte.gererCarteAdmin();
				break;
			case 3:
				OperationProduits.gererProduits();
				break;
			case 4:
				// OperationMenu.gererMenus();
				break;
			case 5:
			default:
				continuer = false;
				afterLogout();
				break;
			}
		}
	}
 
	public static void MenuEmploye() {
		System.out.println("MENU EMPLOYE 👨🏾");
 
		MyLibrary.afficher("Vous êtes connecté(e) en tant qu'employé(e) 👨🏾");
 
		boolean continuer = true;
		while (continuer) {
			int choix = MyLibrary.saisirEntier(
					"1- transferer de l'argent a un collègue \n\n2- Consulter le solde de ma carte \n\n3- Faire des achats \n\n4- Voir mon panier \n\n5- Se déconecter");
			switch (choix) {
			case 1:
				OperationEmploye.transfertMoney();
				break;
			case 2:
				OperationCarte.consulterSolde();
				break;
			case 3:
				OperationProduits.achats();
				break;
			case 4:
				// OperationPanier.voirPanier();
				break;
			case 5:
				afterLogout();
				break;
			default:
				continuer = false;
				afterLogout();
				break;
			}
		}
	}
 
//	public static void MenuMedecin() {
	//	System.out.println("MENU MEDECIN 🧑🏾‍⚕️");
 
	//	MyLibrary.afficher("Vous êtes connecté(e) en tant que médecin 🧑🏾‍⚕️");
 
	//	boolean continuer = true;
	//	while (continuer) {
	//		int choix = MyLibrary
	//				.saisirEntier("Que voulez vous faire: \n\n1- Voir mes consultation \n\n2- Se déconnecter"
	//						+ " \n\n PAGE EN COURS DE DEVELOPPEMENT...");
 
	//		switch (choix) {
	//		case 1:
	//			// OperationMedecin.voirRDV();
	//			break;
	//		case 2:
	//		default:
	//			continuer = false;
	//			afterLogout();
	//			break;
	//		}
	//	}
	//	}
 
	public static void Demarrage() {
		Person person = OperationEmploye.connexion();
		int compteur = 1;
		while (person == null && compteur < 3) {
			MyLibrary.afficher("Identifiant ou mot de passe incorrect");
			person = OperationEmploye.connexion();
			compteur++;
		}
 
		if (compteur == 3) {
			MyLibrary.afficher("Vous avez atteint 3 tentatives. Réessayez plus-tard");
			return;
		} else {
			if (person != null) {
				switch (person.getrole().getnomRole()) {
				case "ADMINISTRATEUR":
					MenuAdmin();
					break;
				case "EMPLOYE":
					MenuEmploye();
					break;
				case "MEDECIN":
					//MenuMedecin();
					break;
				default:
					MyLibrary.afficher("Votre rôle n'a pas été reconnu !");
					break;
 
				}
			}
		}
	}
 
	public static void afterLogout() {
		boolean continuer = true;
		while (continuer) {
			int choix = MyLibrary.saisirEntier("1- Se Connecter " + "2- Quitter");
			switch (choix) {
			case 1:
				continuer = false;
				Demarrage();
				break;
			case 2:
			default:
				MyLibrary.afficher("Merci de votre visite a bientôt :)🎈");
				continuer = false;
				break;
			}
		}
	}
 
}