package com.ifrn.agenda.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ifrn.agenda.model.Usuario;

@Repository
public class UsuarioRepository {
	
	private List<Usuario> usuarios;

	public UsuarioRepository() {
		usuarios =  new ArrayList<Usuario>();
		
		
		Usuario pessoa1 = new Usuario("william", 1, "12345", "comum", "silva");
		Usuario pessoa2 = new Usuario("Carlos - Administrador", 2, "123456", "admin ", "junior");
	
		
		
		
		
		usuarios.add(pessoa1);
		usuarios.add(pessoa2);
		
		
	}

	public Usuario validando_login(String login, String senha) {
		for(Usuario usuario: usuarios) {
			if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		
		
		
		return null;
		
	}
	
			
		
		
		
	
	
	
	
	
	
	

}
