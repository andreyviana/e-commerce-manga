package com.api.emanga.model;


import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "mangas")
public class MangaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 100, nullable = false)
	private String titulo;

	@Column
	private String fotoCapaUrl;

	@Column
	private Integer volume;

	@Column
	private BigDecimal preco;

	@Column
	private String descricao;

	@Column(length = 100)
	private String autores;
	
	@ManyToMany(fetch = FetchType.LAZY,
		cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
		})
	@JoinTable(
		name = "generos_mangas",
		joinColumns = @JoinColumn(name = "id_manga"),
		inverseJoinColumns = @JoinColumn(name = "id_genero"))
	private Set<GeneroModel> generos;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getFotoCapaUrl() {
		return this.fotoCapaUrl;
	}
	
	public void setFotoCapaUrl(String url) {
		this.fotoCapaUrl = url;
	}
	
	public Integer getVolume() {
		return this.volume;
	}
	
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	
	public BigDecimal getPreco() {
		return this.preco;
	}
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getAutores() {
		return this.autores;
	}
	
	public void setAutores(String autores) {
		this.autores = autores;
	}

	public Set<GeneroModel> getGeneros() {
		return this.generos;
	}

	public void setGeneros(Set<GeneroModel> generos) {
		this.generos = generos;
	}
}
