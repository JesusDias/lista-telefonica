package com.jesusDias.listatelefones.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesusDias.listatelefones.entities.Contato;
import com.jesusDias.listatelefones.repositories.ContatoRepository;

@Service
public class DBService {
	
	@Autowired
	private ContatoRepository reposytory;
	
	public void instatiateTesteDatabase(){
		
		Contato c1 = new Contato(null, "jesus Dias", "99999", "22/06/1991", "Jeuss@hotmail"); 
		Contato c2 = new Contato(null, "Angelica Silva", "99999", "22/06/1991", "angelica@hotmail"); 
		Contato c3 = new Contato(null, "Marcos Castro", "555555", "22/06/1991", "marcos@hotmail"); 
		Contato c4 = new Contato(null, "Thalia Martins", "9999", "22/06/1991", "thalia@hotmail"); 
		Contato c5 = new Contato(null, "joao Das coves", "22222", "22/06/1991", "joao@hotmail"); 
		reposytory.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		
		
	}
}
