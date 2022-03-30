package com.ifrn.agenda.model;

public class Usuario {
	
	private String nome;
	private int id;
	private String senha;
	private String perfil;
	private String login;
	
	
	
	//CONSTRUTOR
	public Usuario(String nome, int id, String senha, String perfil, String login) {
		super();
		this.nome = nome;
		this.id = id;
		this.senha = senha;
		this.perfil = perfil;
		this.login = login;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public String getPerfil() {
		return perfil;
	}



	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}
	
	
	
	
	
	

}
