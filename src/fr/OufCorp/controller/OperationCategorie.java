package fr.OufCorp.controller;
 
import java.util.ArrayList;
import fr.OufCorp.view.*;
import java.util.List;
 
import fr.OufCorp.model.*;
 
public class OperationCategorie {
	public static List<Categorie> listCategorie= new ArrayList<Categorie>();
	public static Categorie getCategorieByCategorieName(String nomCategorie) {
		Categorie Categorie = null;
		for(Categorie c : listCategorie) {
			if(c.getnomCategorie().equals(nomCategorie)) {
				Categorie = c;
			}
		}
		return Categorie;
	}
}