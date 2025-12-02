package fr.OufCorp.controller;

import fr.OufCorp.model.*;
import fr.OufCorp.view.*;

public class BaseDD {
	//STOCKAGE DE L'ENSEMBLE DES DONNEES
	public static void initBaseDD() {
 
		// ROLE PREDEFINIS
		Role r1 = new Role(1, "Administrateur".toUpperCase());
		Role r2 = new Role(2, "Employe".toUpperCase());
		OperationRole.listRole.add(r1);
		OperationRole.listRole.add(r2);

 
		// PERSONNAGSES
		Person p1 = new Person("Destina", "Volmy", "ADMIN", "admin123", r1);
		Person p2 = new Person("Dubois", "Aurélie", "a.DUBOIS", "A123Dubois", r2);
		// Person p3 = new Person("Dupont", "Jacques", "j.DUPONT", "123456", "Standard", r2);
		// Person p4 = new Person("Camélia", "Saadedine", "C.S2adine", "Saadedine", "Standard", r2);
		OperationEmploye.listPerson.add(p1);
		OperationEmploye.listPerson.add(p2);
		// OperationEmploye.listPerson.add(p3);
		// OperationEmploye.listPerson.add(p4);
 
		// CARTES
		Carte c1 = new Carte("AR002", "Gold", 50.0, p1);
		Carte c2 = new Carte("BR002", "Standard", 50.0, p2);
		// Carte c3 = new Carte("CR003", "Standard", 50.0, p3);
		// Carte c4 = new Carte("CR004", "Standard", 50.0, p4);
		OperationCarte.listCarte.add(c1);
		OperationCarte.listCarte.add(c2);
		// OperationCarte.listCarte.add(c3);
		// OperationCarte.listCarte.add(c4);
 
		// CATEGORIE
		Categorie Cat1 = new Categorie(1, "Alimentaire".toUpperCase());
		OperationCategorie.listCategorie.add(Cat1);
 
		// PRODUITS
		Produits pr1 = new Produits("19", "Frosties", "Kellog's", 2.50, 120, Cat1);
		Produits pr2 = new Produits("18", "Bouteille d'eau", "Cristaline", 1.02, 100, Cat1);
		Produits pr3 = new Produits("17", "Boissons", "Coca-Cola", 1.54, 200, Cat1);
		OperationProduits.listProduits.add(pr1);
		OperationProduits.listProduits.add(pr2);
		OperationProduits.listProduits.add(pr3);
	}
 
}
