package com.api.emanga.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.emanga.model.MangaModel;
import com.api.emanga.service.MangaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/emanga/mangas")
public class MangaController {
	
	@Autowired private MangaService service;

	@GetMapping
	public ResponseEntity<List<MangaModel>> getMangas() {
		return !service.getMangas().isEmpty() ? ResponseEntity.ok(service.getMangas()) : ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<MangaModel>> getMangaById(@PathVariable("id") Integer id) {
		return service.getMangaById(id).isPresent() ? ResponseEntity.ok(service.getMangaById(id)) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<MangaModel> adicionarManga(@RequestBody MangaModel manga) {
		return manga.getId() == null ? ResponseEntity.status(201).body(service.adicionarManga(manga)) 
			: ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Optional<MangaModel>> atualizarManga(@Valid @PathVariable("id") Integer id, @RequestBody MangaModel manga) {
		return service.atualizarManga(id, manga).isPresent() ? ResponseEntity.ok(service.atualizarManga(id, manga)) 
			: ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluirManga(@PathVariable("id") Integer id) {
		return service.excluirManga(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
}
