package fr.OufCorp.controller;

import fr.OufCorp.model.*;
import java.util.List;
import java.util.ArrayList;
import fr.OufCorp.model.*;
 
 
public class OperationRole {
	public static List<Role> listRole = new ArrayList<Role>();
	public static Role getRoleByRoleName(String roleName) {
		Role role = null;
		for(Role r : listRole) {
			if(r.getnomRole().equals(roleName)) {
				role = r;
			}
		}
		return role;
	}
}