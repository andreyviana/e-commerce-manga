package com.api.emanga.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "generos")
public class GeneroModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 30, nullable = false)
	private String genero;

	@ManyToMany(fetch = FetchType.LAZY,
		cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
		},
		mappedBy = "generos")
	@JsonIgnore
	private Set<MangaModel> mangas;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public Set<MangaModel> getMangas() {
		return this.mangas;
	}
	
	public void setMangas(Set<MangaModel> mangas) {
		this.mangas = mangas;
	}
}
