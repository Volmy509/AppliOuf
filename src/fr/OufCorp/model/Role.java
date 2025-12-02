package fr.OufCorp.model;
 
public class Role {
	private int ID;
	private String nomRole;
 
	public Role(int ID, String nomRole) {
		this.ID = ID;
		this.nomRole = nomRole;
 
	}
 
	public int getID() {
		return ID;
	}
 
	public void setID(int ID) {
		this.ID = ID;
	}
 
	public String getnomRole() {
		return nomRole;
	}
 
	public void setnomRole(String nomRole) {
		this.nomRole = nomRole;
	}
 
	public String infoRole() {
		return "id : " + ID + " Role:  " + nomRole;
	}
 
}