package org.sid;

import java.util.Collections;

import org.sid.entities.Compte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BnqueSiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BnqueSiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		RestTemplate restTemplate=new RestTemplate();
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		String ressourceURL="http://localhost:8080/comptes/CC1";
		HttpEntity<Compte> entity=new HttpEntity<>(headers);
		ResponseEntity<Compte> response=restTemplate.exchange(ressourceURL, HttpMethod.GET,entity,Compte.class);
		
		if(response.getStatusCode()==HttpStatus.OK)
		{
			System.out.println(response.getBody().getSolde());
		}
		else
		{
			System.out.println("il y'a une errrrrrrrrreeeeeeeeeeeeeur");
		}
		
		
	}
}
