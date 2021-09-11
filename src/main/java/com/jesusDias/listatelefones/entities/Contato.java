package com.jesusDias.listatelefones.entities;

import java.io.Serializable;
import java.util.Date;

public class Contato implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String nome;
	private String telefone;
	private Date nacimento;
	private String email;
	
	public Contato() {
		
	}

	public Contato( Long id, String nome, String telefone, Date nacimento, String email) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.nacimento = nacimento;
		this.email = email;
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

	public Date getNacimento() {
		return nacimento;
	}

	public void setNacimento(Date nacimento) {
		this.nacimento = nacimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
