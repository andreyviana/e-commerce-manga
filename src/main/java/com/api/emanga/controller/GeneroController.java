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

import com.api.emanga.model.GeneroModel;
import com.api.emanga.service.GeneroService;

@RestController
@RequestMapping("/api/emanga/generos")
public class GeneroController {
	
	@Autowired private GeneroService service;
	
	@GetMapping
	public ResponseEntity<List<GeneroModel>> getGeneros() {
		return !service.getGeneros().isEmpty() ? ResponseEntity.ok(service.getGeneros()) : ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<GeneroModel>> getGenroById(@PathVariable("id") Integer id) {
		return service.getGeneroById(id).isPresent() ? ResponseEntity.ok(service.getGeneroById(id)) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<GeneroModel> adicionarGenero(@RequestBody GeneroModel genero) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionarGenero(genero));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Optional<GeneroModel>> atualizarGenero(@PathVariable("id") Integer id, @RequestBody GeneroModel genero) {
		return service.atualizarGenero(id, genero).isPresent() ? ResponseEntity.ok(service.atualizarGenero(id, genero))
				: ResponseEntity.notFound().build();
 	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluirGenero(@PathVariable("id") Integer id) {
		return service.excluirGenero(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
}
