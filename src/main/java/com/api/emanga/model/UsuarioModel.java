package com.api.emanga.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome_usuario", length = 30, nullable = false)
	private String nomeUsuario;

	@Column(name = "email_usuario", unique = true, nullable = false)
	private String emailUsuario;

	@Column(name = "senha_usuario", nullable = false)
	private String senhaUsuario;
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNomeUsuario() {
		return this.nomeUsuario;
	}
	
	public void setNomeUsuario(String nome) {
		this.nomeUsuario = nome;
	}
	
	public String getEmailUsuario() {
		return this.emailUsuario;
	}
	
	public void setEmailUsuario(String email) {
		this.emailUsuario = email;
	}
	
	public String getSenhaUsuario() {
		return this.senhaUsuario;
	}
	
	public void setSenhaUsuario(String senha) {
		this.senhaUsuario = senha;
	}
}
