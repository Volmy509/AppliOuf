package fr.OufCorp.controller;
 
import fr.OufCorp.model.*;
import java.util.ArrayList;
 
import java.util.List;
 
import fr.OufCorp.model.*;
import fr.OufCorp.view.*;
 
public class OperationCarte {
	public static List<Carte> listCarte = new ArrayList<Carte>();
 
	// METHODES POUR GERER LES CARTES
	public static void gererCarteAdmin() {
		System.out.println("Taille de listCarte: " + listCarte.size());
		for (Carte c : listCarte) {
			System.out.println("Carte présente: " + c.getnumCarte());
		}
 
		boolean continuer = true;
		while (continuer) {
			int choix = MyLibrary
					.saisirEntier("Que voulez-vous faire ?\n" + "\n0- Retourner au menu" + "\n1- Créer une carte"
							+ "\n2- Supprimer une carte" + "\n3- Afficher toutes les cartes" + "\n4- Se déconnecter");
			switch (choix) {
			case 0:
				Menu.MenuAdmin();
			case 1:
				createCarte();
				break;
			case 2:
				deleteCarte();
				break;
			case 3:
				listCarte();
				break;
			case 4:
				continuer = false;
				Menu.afterLogout();
				break;
			}
		}
	}
 
	public static void consulterSolde() {
		// VERIFIE SI & QEUL l'UTILISATEUR EST CONNECTE
		if (Program.titulaireConnecte == null) {
			MyLibrary.afficher("Veuillez vous connecter avant de consulter votre solde");
			return;
		}
 
		if (Program.titulaireConnecte != null) {
			MyLibrary.afficher(Program.titulaireConnecte.infoCarte());
		}
	}
 
	// METHODE POUR CREER UNE CARTE
	public static Carte createCarte() {
		double Solde = 10.0;
		String numCarte = generateNumCarte();
		String TypeOfCard = MyLibrary.saisir(" Gold \n Standard ");
		Person titulaire = OperationEmploye
				.getClientByIdentifiant(MyLibrary.saisir("Saisissez l'identifiant de l'employé(e)"));
 
		Carte c = new Carte(numCarte, TypeOfCard, Solde, titulaire);
		listCarte.add(c);
		return c;
	}
 
	// METHODE QUI PERMET DE LISTER LES CARTES
	public static void listCarte() {
		String data = " ";
		for (Carte c : listCarte) {
			if (c.getnumCarte() != null) {
				data += c.infoCarte() + "\n";
			}
		}
		if (data.length() == 0) {
			MyLibrary.afficher("Aucune carte n'a été trouvé");
		} else {
			MyLibrary.afficher(data);
		}
	}
 
	// METHODE POUR SUPPRIMER UNE CARTES
	public static void deleteCarte() {
		Carte carte = searchCarte(MyLibrary.saisir("Entrez le numero de la carte a supprimer"));
 
		if (carte != null) {
			listCarte.remove(carte);
			MyLibrary.afficher("La carte a bien été supprimer ");
		} else {
			MyLibrary.afficher("La carte n'a pas été reconnue");
		}
	}
 
	// METHODE POUR RECHERCHER UN CARTE PAR SON NUMERO (en l'occurence utilisé pour
	// envoyer de l'argent a un collègue )
	public static Carte searchCarteByNumCarte(Person personne) {
		for (Carte c : listCarte) {
			if (c.getnumCarte().equals(personne)) {
				return c;
			}
		}
		return null;
	}
 
	// METHODE QUI PERMET DE RECHERCHER UNE CARTE
	public static Carte searchCarte(String numCarte) {
		Carte proprietaire = null;
		for (Carte carteChercher : listCarte) {
			if (carteChercher.getnumCarte() != null && carteChercher.getnumCarte().equals(numCarte)) {
				return carteChercher;
			}
		}
		return null;
	}
 
	// METHODE QUI GENERE UN "numéro de carte" ALEATOIRE
	public static String generateNumCarte() {
		String password = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		for (int i = 0; i < 8; i++) {
			password += alphabet.charAt((int) (Math.random() * alphabet.length()));
		}
		return password;
	}
}