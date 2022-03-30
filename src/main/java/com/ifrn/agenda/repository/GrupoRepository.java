package com.ifrn.agenda.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ifrn.agenda.model.Grupo;

@Repository
public class GrupoRepository {
	
	private List<Grupo> grupos;
	
	public GrupoRepository() {
		grupos = new ArrayList<Grupo>();
		
		
		grupos.add(new Grupo("Familia", "Contatos dos meus familiares"));
		grupos.add(new Grupo("IFRN Alunos", "Alunos do curso de RSI"));
		grupos.add(new Grupo("IFRN Colegas", "Professores e técnicos do IFRN"));
		grupos.add(new Grupo("Natação", "Professores e colegas IFRN"));
		
	}
	
	public List<Grupo> ObterGrupos(){
		return grupos;
	}

	//MÉTODO PARA SALVAR GRUPO CRIADO
	public void Salvar(Grupo grupo) {
		this.grupos.add(grupo);
		
	}

	public Grupo ObterGrupoPorNome(String nomeGrupo) {
		Grupo retorno = null;
		for(Grupo grupo : grupos) {
				
				if(grupo.getNome().equals(nomeGrupo)) {
				retorno = grupo;
				
			}
		}
			return retorno;
					
	}
	
	//OBTER GRUPO POR ID
	public Grupo obterGrpoPorId(int id) {
		try {
			return grupos.get(id);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	//ATUALIZAR GRUPO
	public void AtualizarGrupo(int id, Grupo grupo) {
		this.grupos.set(id, grupo);
	}
	//DELETAR GRUPO POR ID
	public void excluirgrupo(int id) {
		this.grupos.remove(id);
		
	}

	
	

}
