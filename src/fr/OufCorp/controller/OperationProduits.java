package fr.OufCorp.controller;

import java.util.ArrayList;

import java.util.List;
import fr.OufCorp.model.*;
import fr.OufCorp.view.*;

public class OperationProduits {
	public static List<Produits> listProduits = new ArrayList<Produits>();

	// METHODE POUR GERER LES PORDUITS
	public static void gererProduits() {

		boolean continuer = true;
		while (continuer) {
			int choix = MyLibrary.saisirEntier(
					"Que voulez vous faire : \n\n0- Retourner au menu \n\n1- Créer un produit \n\n2- Supprimer un produit \n\n3- Afficher tout les produits \n\n4- Se deconnecter");

			switch (choix) {
			case 0:
				Menu.MenuAdmin();
				break;
			case 1:
				createProducts();
				break;
			case 2:
				// deleteProducts();
				break;
			case 3:
				listProducts();
				break;
			case 4:
			default:
				continuer = false;
				Menu.afterLogout();
				break;
			}
		}
	}

	// METHODE POUR CREER UN PRODUIT
	public static Produits createProducts() {
		MyLibrary.afficher("Vous allez creer un produit");
		String Id = generateId();
		String Nom = MyLibrary.saisir("Id :" + Id + "\nQuelle est le nom du produits ");
		String Marque = MyLibrary.saisir("Id :" + Id + "\nQuelle est la marque du produit ");
		double Prix = MyLibrary.saisirDouble("Id :" + Id + "\nQuelle est le prix du produit ");
		int Quantite = MyLibrary.saisirEntier("Id :" + Id + "\nCombien y'en a t-il en stock ");
		Categorie Categorie = OperationCategorie.getCategorieByCategorieName("Alimentaire");

		Produits pr = new Produits(Id, Nom, Marque, Prix, Quantite, Categorie);
		listProduits.add(pr);

		MyLibrary.afficher(
				"Vous avez bien créer un produit: " + "\n Nom: " + Nom + "\n Marque: " + Marque + "\n Quantité: "
						+ Quantite + "\n Prix: " + Prix + " €" + "\n id produit: " + Id + "\nCategorie: " + Categorie);
		return pr;
	}

	// METHODE QUI GENERE UN "Id" ALEATOIRE AUX PRODUITS
	private static String generateId() {
		String id = "";
		String nombre = "0123456789";
		for (int i = 0; i < 4; i++) {
			id += nombre.charAt((int) (Math.random() * nombre.length()));
		}
		return id;
	}

	// METHODE QUI PERMET DE RECHERCHER UN PRODUIT
	private static Produits searchProducts(String Id) {
		Produits Pr = null;
		for (Produits P : listProduits) {
			if (P.getId().equals(Id)) {
				Pr = P;
			}
		}
		return Pr;
	}

	// METHODE QUI PERMET DE LISTER LES CLIENTS
	public static void listProducts() {
		String Base = " ";
		for (Produits p : listProduits) {
			if (p.getId() != null) {
				Base += p.infoProduits() + "\n";
			}
		}
		if (Base.equals(" ")) {
			MyLibrary.afficher("Aucun produit n'a été trouvé");
		} else {
			MyLibrary.afficher(Base);
		}
	}

	@SuppressWarnings("unused")
	public static void achats() {
		// VERIFIE SI & QEUL l'UTILISATEUR EST CONNECTE
		if (Program.titulaireConnecte == null) {
			MyLibrary.afficher("Veuillez vous connecter avant de faire un achat.");
			return;
		}

		// AFFICHE LES PRODUITS DISPONIBLE
		MyLibrary.afficher("Cliquer sur " + "OK" + " pour voir les produits disponible: ");
		listProducts();

		Produits pr = searchProducts(MyLibrary.saisir("Entrez l'ID du produit que vous voulez achetez "));
		if (pr == null) {
			MyLibrary.afficher("Vous n'avez choisi aucun produit");
		} else {
		System.out.println("Le produit sélectionner est: " + pr.infoProduits());
			int quantite = MyLibrary.saisirEntier("Combien voulez-en vous ? ");

			if (quantite <= 0) {
				MyLibrary.afficher("Vous ne pouvez pas en achetez si peu 😔");
			} else if (quantite > pr.getQuantite()) {
				MyLibrary.afficher("Il n'y en a plus assez en stock" + "\n\n Encore en stock : " + pr.getQuantite());
			} else {
				double total = pr.getprix() * quantite;
				if (Program.titulaireConnecte.getSolde() < total) {
					MyLibrary.afficher("PAYEMENT REFUSE ❌" + "\nLe solde de votre carte n'est pas suffisant " + " Voici votre solde: "
							+ "\n\nSolde: " + Program.titulaireConnecte.getSolde() +" €" + "\nMontant requis: " + total + " €");
					return;
				}
				pr.setQuantite(pr.getQuantite() - quantite);
				Program.titulaireConnecte.setSolde(Program.titulaireConnecte.getSolde() - total);
				MyLibrary.afficher("Vous avez acheter : " + pr.infoProduits() + " pour un total de: "
						+ total + " €"+" Merci pour vos achats");
			}

		}
	}
}