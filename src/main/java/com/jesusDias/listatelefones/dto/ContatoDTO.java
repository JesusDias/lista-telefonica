package com.jesusDias.listatelefones.dto;

import java.io.Serializable;

import com.jesusDias.listatelefones.entities.Contato;

public class ContatoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String nome;
	private String telefone;
	private String nascimento;
	private String email;
	
	public ContatoDTO() {
		
	}
	
	public ContatoDTO(Contato obj) {
		id = obj.getId();
		nome = obj.getNome();
		telefone = obj.getTelefone();
		nascimento = obj.getNacimento();
		email = obj.getEmail();
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

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
