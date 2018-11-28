package org.sid.service;

import org.sid.entities.AppUser;
import org.sid.entities.AppRole;

public interface AccountService {
	
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void AddRoleToUser(String username,String roleName);
	public AppUser findUserByUsername(String username);

}
