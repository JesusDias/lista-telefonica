package com.jesusDias.listatelefones.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.jesusDias.listatelefones.entities.Contato;
import com.jesusDias.listatelefones.repositories.ContatoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ContatoRepository reposytory;

	@Override
	public void run(String... args) throws Exception {
		Contato c1 = new Contato(null, "jesus", "99999", "22/06/1991", "Jeuss@hotmail"); 
		Contato c2 = new Contato(null, "Angelica", "99999", "22/06/1991", "angelica@hotmail"); 
		reposytory.saveAll(Arrays.asList(c1, c2));
	}
}
