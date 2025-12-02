package fr.OufCorp.view;
import fr.OufCorp.controller.*;
import fr.OufCorp.model.*;
 
public class Program {
	public static Carte titulaireConnecte = null;
	public static Person personneConnecte = null;
	public static void main(String[] args) {
 
		BaseDD.initBaseDD();
		Menu.Demarrage();		
	}
 
}