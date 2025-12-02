package fr.OufCorp.model;
 
import javax.swing.JOptionPane;
 
public class MyLibrary {
 
	public static void afficher(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
 
	public static String saisir(String msg) {
		return JOptionPane.showInputDialog(msg);
	}
 
	public static int saisirEntier(String msg) {
		return Integer.parseInt(saisir(msg));
	}
 
	public static double saisirDouble(String msg) {
		return Double.parseDouble(saisir(msg));
	}
}