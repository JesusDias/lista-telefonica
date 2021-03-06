package com.jesusDias.listatelefones.dto;

import java.io.Serializable;

import com.jesusDias.listatelefones.entities.Contato;

public class ContatoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String telefone;

	public ContatoDTO() {
		
	}
	
	public ContatoDTO(Contato obj) {
		id = obj.getId();
		nome = obj.getNome();
		telefone = obj.getTelefone();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
