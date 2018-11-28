package org.sid.service;

import org.sid.dao.RoleRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	public AppUser saveUser(AppUser user) {
		String hashPwd=bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPwd);
		return userRepository.save(user);
	}

	public AppRole saveRole(AppRole role) {
		return roleRepository.save(role);
	}

	public void AddRoleToUser(String username, String roleName) {
		AppRole role=roleRepository.findByRoleName(roleName);
		AppUser user=userRepository.findByUsername(username);
		user.getRoles().add(role);
	}

	public AppUser findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
