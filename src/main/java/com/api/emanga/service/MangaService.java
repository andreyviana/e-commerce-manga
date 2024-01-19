package com.api.emanga.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.emanga.model.MangaModel;
import com.api.emanga.respository.MangaRepository;

@Service
public class MangaService {

	@Autowired MangaRepository repository;
	
	public List<MangaModel> getMangas() {
		return this.repository.findAll();
	}
	
	public Optional<MangaModel> getMangaById(Integer id) {
		return this.repository.findById(id);
	}

	public MangaModel adicionarManga(MangaModel manga) {
		return this.repository.save(manga);
	}

	public Optional<MangaModel> atualizarManga(Integer id, MangaModel manga) {
		return getMangaById(id).map(x -> {
			x.setTitulo(manga.getTitulo());
			x.setFotoCapaUrl(manga.getFotoCapaUrl());
			x.setVolume(manga.getVolume());
			x.setPreco(manga.getPreco());
			x.setDescricao(manga.getDescricao());
			x.setAutores(manga.getAutores());
			return adicionarManga(x);
		});
	}
	
	public Boolean excluirManga(Integer id) {
		return getMangaById(id).map(x -> {
			this.repository.delete(x);
			return true;
		}).orElse(false);
	}
}
