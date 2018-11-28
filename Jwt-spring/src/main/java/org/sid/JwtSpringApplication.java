package org.sid;

import org.sid.dao.TaskRepository;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.sid.entities.Task;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JwtSpringApplication implements CommandLineRunner {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Bean
	public BCryptPasswordEncoder getBCPE()
	{
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JwtSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		accountService.saveUser(new AppUser(null,"admin","admin",null));
//		accountService.saveUser(new AppUser(null,"user","1234",null));
//		accountService.saveRole(new AppRole(null,"ADMIN"));
//		accountService.saveRole(new AppRole(null,"USER"));
//		accountService.AddRoleToUser("admin", "ADMIN");
//		accountService.AddRoleToUser("admin", "USER");
//		accountService.AddRoleToUser("user", "USER");
		
//		taskRepository.save(new Task(null,"T1"));
//		taskRepository.save(new Task(null,"T2"));
//		taskRepository.save(new Task(null,"T3"));
		
		taskRepository.findAll().forEach(t->
		{
			System.out.println(t.getTaskName());
		});
	}
}
