package com.ifrn.agenda.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ifrn.agenda.model.Contato;
import com.ifrn.agenda.model.Grupo;
import com.ifrn.agenda.repository.ContatoRepository;
import com.ifrn.agenda.repository.GrupoRepository;

@RestController
public class ContatoAPIController {
	
	@Autowired
	private ContatoRepository contatorepositorio;
	
	@Autowired
	private GrupoRepository gruporepository;
	
	
	
	@GetMapping("/api/contato")
	public List<Contato> BuscarContatos(){
		return contatorepositorio.ObterTodosContatos();
		
	}
	
	@PostMapping("/api/contato")
	public Contato CriarContato(@RequestBody Contato contato) {
		List<Grupo> grupos = new ArrayList<Grupo>();
		
		for(Grupo grupo : contato.getGrupos()) {
			Grupo grupoAdd = gruporepository.ObterGrupoPorNome(grupo.getNome());
			if(grupoAdd != null) {
				contato.setGrupos(grupos);
				contatorepositorio.SalvarContato(contato);
			}else {
				System.out.println("Grupo vazio!");
			}
			
			grupos.add(	gruporepository.ObterGrupoPorNome(grupo.getNome()));
		}
		contato.setGrupos(grupos);
	
		return contato;
	}

}
