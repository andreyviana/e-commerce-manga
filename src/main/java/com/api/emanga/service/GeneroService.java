package com.api.emanga.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.emanga.model.GeneroModel;
import com.api.emanga.respository.GeneroRepository;

@Service
public class GeneroService {

	@Autowired private GeneroRepository repository;

	public List<GeneroModel> getGeneros() {
		return this.repository.findAll();
	}

	public Optional<GeneroModel> getGeneroById(Integer Id) {
		return this.repository.findById(Id);
	}

	public GeneroModel adicionarGenero(GeneroModel genero) {
		return this.repository.save(genero);
	}

	public Optional<GeneroModel> atualizarGenero(Integer id, GeneroModel genero) {
		return getGeneroById(id).map(x -> {
			x.setGenero(genero.getGenero());
			return adicionarGenero(x);
		});
	}
	
	public Boolean excluirGenero(Integer id) {
		return getGeneroById(id).map(x -> {
			this.repository.delete(x);
			return true;
		}).orElse(false);
	}
}
