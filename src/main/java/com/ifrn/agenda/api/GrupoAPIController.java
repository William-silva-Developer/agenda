package com.ifrn.agenda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ifrn.agenda.model.Grupo;
import com.ifrn.agenda.repository.GrupoRepository;

@RestController
public class GrupoAPIController {
	
	@Autowired
	private GrupoRepository repository;
	
	@GetMapping("/api/grupo")
	public List<Grupo> obtergruposexistente(){
		return repository.ObterGrupos();
	}
	
	@GetMapping("/api/grupo/{id}")//FAZ UMA BUSCA NO GRUPO POR ID E CASO NÃO ENCOTRE DARÁ UM ERRO. MÉTODO REFERENTE AO GET DO GRUPO.
	public ResponseEntity<Grupo> ObterGrupoPorId(@PathVariable("id") int id) {
		Grupo grupo = repository.obterGrpoPorId(id);
		if(grupo != null) {
			return ResponseEntity.ok(grupo);
		}else {
			return ResponseEntity.notFound().build();
		}
		
		
	}
	@PostMapping("/api/grupo")//MÉTODO REFERENTE AO POST DO GRUPO
	@ResponseStatus(code = HttpStatus.CREATED)
	public Grupo CriarGrupo(@RequestBody Grupo grupo) {
		repository.Salvar(grupo);
		return grupo;
		
		
	}
	
	@PutMapping("/api/grupo/{id}")//MÉTODO PARA EDITAR OU ATUALIZAR O GRUPO. REFENTE AO PUT
	public ResponseEntity<Grupo>EditandoGrupo(@PathVariable int id, @RequestBody Grupo grupo_novo){
		Grupo grupo = repository.obterGrpoPorId(id);
		
		if(grupo != null) {
			repository.AtualizarGrupo(id, grupo_novo);
			return ResponseEntity.ok(grupo_novo);
		}else {
			return ResponseEntity.noContent().build();
		}
		
	}// DEU ERRO EM ATUALIZAR GRUPO
	
	@DeleteMapping("/api/grupo/{id}")
	public ResponseEntity<Grupo>apagargrupo(@PathVariable int id){
		Grupo grupo = repository.obterGrpoPorId(id);
		
		if(grupo != null) {
			repository.excluirgrupo(id);
			return ResponseEntity.ok(grupo);
		}else {
			return ResponseEntity.noContent().build();
		}
		
	}

}
