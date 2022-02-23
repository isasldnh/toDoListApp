package com.toDoList.toDoList.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toDoList.toDoList.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	//requisicao de dados via email
	public Optional<Usuario> findByEmail(String email);
	
	//requisicao de dados via nome
	public List <Usuario> findAllByNomeContainingIgnoreCase(String nome); 
}
