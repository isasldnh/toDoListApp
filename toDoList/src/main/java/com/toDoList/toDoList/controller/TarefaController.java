package com.toDoList.toDoList.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toDoList.toDoList.model.Tarefa;
import com.toDoList.toDoList.repository.TarefaRepository;

@RestController
@RequestMapping("/tarefa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TarefaController {
	
	//chama o repository
	@Autowired
	private TarefaRepository tarefaRepository;
	
	
	//Encontrar todas as tarefas
	@GetMapping
	public List<Tarefa> findAll(){
		return tarefaRepository.findAll();
	}
	
	//Tarefas filtradas por prioridade
	@GetMapping("/tarefa/{prioridade}")
	   public ResponseEntity<Object> findByCategoria(@PathVariable(value = "prioridade") Integer prioridade) {
	       return ResponseEntity.ok(tarefaRepository.findAllByPrioridade(prioridade));
	}
	
	//Nova tarefa incluida
	@PostMapping
	public ResponseEntity<Tarefa> postPostagem (@Valid @RequestBody Tarefa tarefa){
		return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefa));
	}
	
	//Deletar tarefa
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePostagem(@PathVariable long id) {
		
		return tarefaRepository.findById(id)
				.map(resposta -> {
					tarefaRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Atualizar tarefa
	@PutMapping("/update")
	public ResponseEntity<Tarefa> putPostagem (@Valid @RequestBody Tarefa tarefa){
		
		return tarefaRepository.findById(tarefa.getId())
			.map(resposta -> ResponseEntity.ok().body(tarefaRepository.save(tarefa)))
			.orElse(ResponseEntity.notFound().build());
	}
	
	
}
