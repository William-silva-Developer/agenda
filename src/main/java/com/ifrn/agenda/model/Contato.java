package com.ifrn.agenda.model;

import java.util.List;

public class Contato {
	
	private String nome;
	private String sobrenome;
	private String telefone;
	private String email;
	private List<Grupo>grupos;
	
	//CONSTRUTOR VAZIO
	public Contato() {}
	
	//CONSTRUTOR COM CAMPOS
	public Contato(String nome, String sobrenome, String telefone, String email, List<Grupo> grupos) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.email = email;
		this.grupos = grupos;
	}

	//MÉTODOS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}


	//SERVE PARA IMPRIMIR UM OBJETO
	public String toString() {
		return "Contato [nome=" + nome + ", sobrenome=" + sobrenome + ", telefone=" + telefone + ", email=" + email
				+ ", grupos=" + grupos + "]";
	}
	
	
	
	
	
	
	
	

}
