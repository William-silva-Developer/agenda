package com.ifrn.agenda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifrn.agenda.model.Contato;
import com.ifrn.agenda.model.Grupo;
import com.ifrn.agenda.repository.ContatoRepository;
import com.ifrn.agenda.repository.GrupoRepository;



@Controller
public class ContatoController {
	
	
	
	@Autowired
	private ContatoRepository contatorepository;
	
	@Autowired
	private GrupoRepository gruporepository;
	
	@GetMapping("/")
	public String ListarContatos(Model model) {
		model.addAttribute("contatos", contatorepository.ObterTodosContatos());
		model.addAttribute("grupos", gruporepository.ObterGrupos());
		return "index";
	}
	//MÉTODO REFERENTE AO BOTÃO MOSTRAR
	@GetMapping("/contato/mostrar/{email}")
	public String MostrarContato(@PathVariable("email") String email, Model model) {
		Contato contato = contatorepository.ObterContatoPorEmail(email);
		model.addAttribute("contato", contato);
		return "contato/mostrar_contato";
		
	}
	
	//MÉTODO REFERENTE AO BOTÃO APAGAR
	@GetMapping("/contato/apagar/{email}")
	public String ApagarContato(@PathVariable("email") String email,
			RedirectAttributes redirecionando) {
		contatorepository.ApagarContatoPorEmail(email);
		
		redirecionando.addFlashAttribute("mensagem", "CONTATO EXCLUIDO COM SUCESSO!"); 
		
		return "redirect:/";
		
	}
	//MÉTODO PARA EDITAR CONTATOS
	@GetMapping("/contato/editar/{email}")
	public String EditarContato(@PathVariable("email") String email, 
			Model model) {
		
		Contato contato = contatorepository.ObterContatoPorEmail(email);
		model.addAttribute("contato",contato);
		model.addAttribute("grupos", gruporepository.ObterGrupos());
		System.out.println(contato);		
		return "contato/form_contato";
	}
	
	
	
	
	@GetMapping("contato/novo")
	public String NovoContato(Model model) {
		model.addAttribute("contato", new Contato());
		model.addAttribute("grupos", gruporepository.ObterGrupos());
		return "contato/form_contato";
		
	}
	
	@PostMapping("/")
	public String SalvarContato(@ModelAttribute Contato contato,
			@RequestParam(value="gruposcheck", required = false) String[] grupos,
			@RequestParam(value="editando", required = false) String [] editando) {
	
		if(editando == null) {
			
			List<Grupo> GruposParaSalvar = new ArrayList<Grupo>();
			
			for (String NomeGrupo : grupos) {
				GruposParaSalvar.add(gruporepository.ObterGrupoPorNome(NomeGrupo));
				
			}
			contato.setGrupos(GruposParaSalvar);
			contatorepository.SalvarContato(contato);
		}else {
			contatorepository.AtualizarContato(contato);
		}
		return "redirect:/";
		
		
		
		
		
	}
	
	

}
