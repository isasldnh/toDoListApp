package com.toDoList.toDoList.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_tarefa")
public class Tarefa {
	
	//parametros de tarefas
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "O atributo titulo é obrigatório!") 
	@Size(min = 5, max = 100, message = "O título deve conter no mínimo 05 e no máximo 100 caracteres")
	private String titulo;
	
	@NotNull(message = "O atributo descrição é obrigatório!") 
	@Size(min = 5, max = 500, message = "O título deve conter no mínimo 05 e no máximo 500 caracteres")
	private String descricao;
	
	@NotNull(message = "O atributo conclusão é obrigatório!")
	private boolean conclusao;
	
	@NotNull(message = "O atributo titulo é obrigatório!") 
	@Size(min = 5, max = 10, message = "A prioridade da sua tarefa deve ter entre 5 e 10 caracteres.")
	private String prioridade;
	
	@ManyToOne
	@JsonIgnoreProperties("tarefa")
	private Usuario usuario;
	
	//construtor
	public Tarefa (long id, String titulo, String descricao, boolean conclusao, String prioridade) {
		this.id=id;
		this.titulo=titulo;
		this.descricao=descricao;
		this.conclusao=conclusao;
		this.prioridade=prioridade;
	}
	
	//gets e setters	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isConclusao() {
		return conclusao;
	}

	public void setConclusao(boolean conclusao) {
		this.conclusao = conclusao;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
