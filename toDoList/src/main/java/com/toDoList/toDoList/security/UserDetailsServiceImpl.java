package com.toDoList.toDoList.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.toDoList.toDoList.model.Usuario;
import com.toDoList.toDoList.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	//chama o repository
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//verificação de usuario
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(userName);
		usuario.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));
		return usuario.map(UserDetailsImpl::new).get();
	}
	

}
