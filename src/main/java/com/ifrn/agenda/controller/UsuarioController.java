package com.ifrn.agenda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ifrn.agenda.model.Usuario;
import com.ifrn.agenda.repository.UsuarioRepository;



@Controller
public class UsuarioController {
	
	
	@Autowired
	private UsuarioRepository usuariorepository;

	
	
	@GetMapping("/login")
	private String login() {
		
		return "/login/login";
	}
	
	@PostMapping("/login")
	private String Validacao_Login(@RequestParam("login") String login,
			@RequestParam("senha") String senha,
			HttpSession session) {
			
		Usuario user= usuariorepository.validando_login(login, senha);
		
		
		if(user != null) {
			session.setAttribute("usuario", user);
			System.out.println("Entrou!");
			System.out.println("nome:"+user.getNome());
			 
		}else {
			System.out.println("Sem autenticação!");
			
		}
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/login";
	}
	


}
