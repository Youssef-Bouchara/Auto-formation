package org.sid.web;

import org.sid.entities.AppUser;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm userForm)
	{
		if(!userForm.getPassword().equals(userForm.getRepassword()))
		{
			throw new RuntimeException("You must confirm your Password");
		}
		
		AppUser user=accountService.findUserByUsername(userForm.getUsername());
		
		if(user!=null)
		{
			throw new RuntimeException("This user is already registred");
		}
		
		AppUser appUser=new AppUser();
		appUser.setUsername(userForm.getUsername());
		appUser.setPassword(userForm.getPassword());
		
		accountService.saveUser(appUser);
		
		accountService.AddRoleToUser(userForm.getUsername(), "USER");
		
		return appUser;
	}
	
	@GetMapping("/register/{username}")
	public AppUser getAll(@PathVariable String username)
	{
		return accountService.findUserByUsername(username);
	}
	
	

}
