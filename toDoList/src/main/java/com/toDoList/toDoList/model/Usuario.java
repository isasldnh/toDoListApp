package com.toDoList.toDoList.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name="tb_usuario") //cria a tabela usuario no db
public class Usuario {
	
	//parametros para usuario
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull (message = "O atributo nome não pode estar em branco")
	@Size (min=3, max=25, message = "O mínimo de caracteres é 3 e o máximo é 25.")
	private String nome;
	
	@Schema(example="email@email.com.br")
	@NotNull (message = "O atributo email não pode estar em branco")
	@Size (min=3, max=100, message = "O mínimo de caracteres é 3 e o máximo é 100.")
	private String email;
	
	@NotNull (message = "O atributo senha não pode estar em branco")
	@Size (min=3, max=100, message = "O mínimo de caracteres é 3 e o máximo é 100.")
	private String senha;
	
	@OneToMany(mappedBy="usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Tarefa> tarefa;
	
	//construtor
	public Usuario (Long id, String nome,String email, String senha) {
		this.id=id;
		this.nome=nome;
		this.email=email;
		this.senha=senha;
	}
	
	public Usuario() {    }

	//gets e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Tarefa> getTarefa() {
		return tarefa;
	}

	public void setTarefa(List<Tarefa> tarefa) {
		this.tarefa = tarefa;
	}
	
	
}
