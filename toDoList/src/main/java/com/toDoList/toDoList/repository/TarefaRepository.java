package com.toDoList.toDoList.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toDoList.toDoList.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	//requisicao de dados por titulo da tarefa
	public List<Tarefa> findAllByTituloContainingIgnoreCase(String titulo);
	//requisicao de dados por prioridade
	public Object findAllByPrioridade(Integer prioridade);
}
