package com.ifrn.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ifrn.agenda.model.Grupo;
import com.ifrn.agenda.repository.GrupoRepository;

@Controller
public class GrupoController {
	
	@Autowired
	private GrupoRepository repository;
	
	
	
	@GetMapping("/grupo")
	public String ListarGrupos(Model model) {
		model.addAttribute("grupos",repository.ObterGrupos());
		return "/grupo/listagem-grupo";
	}
	
	@GetMapping("/grupo/novo")
	public String NovoGrupo(Model model) {
		model.addAttribute("grupo", new Grupo());
		return "/grupo/form-grupo";
	}
	
	@PostMapping("/grupo")
	public String SalvarGrupo(@ModelAttribute Grupo grupo) {
		repository.Salvar(grupo);
		return "redirect:grupo";
	}
	
		
		

}
