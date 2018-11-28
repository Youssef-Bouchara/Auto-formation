package org.sid;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroService1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MicroService1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		/*Formation f1= formationRepository.save(new Formation(null,"PHP",30,null));
		Formation f2= formationRepository.save(new Formation(null,"Java",30,null));
		Formation f3= formationRepository.save(new Formation(null,"Oracle",30,null));
		
		etudiantRepository.save(new Etudiant(null,"Youssef","Bouchara",new Date(),f1));
		etudiantRepository.save(new Etudiant(null,"othmane","Bouchara",new Date(),f1));
		etudiantRepository.save(new Etudiant(null,"Salah","basir",new Date(),f2));
		etudiantRepository.save(new Etudiant(null,"said","jmani",new Date(),f3));*/
		
		
	}
	
}
