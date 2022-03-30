package com.ifrn.agenda.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import com.ifrn.agenda.model.Contato;
import com.ifrn.agenda.model.Grupo;

@Repository
public class ContatoRepository {
	
	private List<Contato> contatos;
	
	
	public ContatoRepository() {
		contatos = new ArrayList<Contato>();
		
		
		
		
		
	}
	
	public List<Contato> ObterTodosContatos() {
		return contatos;
		
	}
	


	public void SalvarContato(Contato contato) {
		this.contatos.add(contato);
		
	}
	//MÉTODO AJUDA A RETORNAR UM CONTATO COM BASE NO EMAIL - BOTÃO MOSTRAR
	public Contato ObterContatoPorEmail(String email) {
		Contato contato = null;
		
		for(Contato c : this.contatos) {
			if(c.getEmail().equals(email)) {
				contato = c;
			}
		}
		
		return contato;
	}
	//METODO PARA APAGAR CONTATO
	public void ApagarContatoPorEmail(String email) {
		this.contatos.remove(ObterContatoPorEmail(email));
		
	}
	//MÉTODO USADO PARA ATUALIZAR UM CONTATO
	public void AtualizarContato(Contato contato_atualizado) {
		String email = contato_atualizado.getEmail();
		Contato contato_velho = ObterContatoPorEmail(email);
		this.contatos.set(contatos.indexOf(contato_velho), contato_atualizado);
			
	}


	
	

}
