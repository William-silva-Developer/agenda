package com.ifrn.agenda.model;

public class Grupo {
	
	private String nome;
	private String descricao;
	
	//CONSTRUTOR VAZIO
	public Grupo() {}
	
	//CONSTRUTOR COM CAMPOS
	public Grupo (String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	
	//MÉTODOS
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	//SERVE PARA IMPRIMIR UM OBJETO
	public String toString() {
		return "Grupo [nome=" + nome + ", descricao=" + descricao + "]";
	}
	
	
	
	

}
