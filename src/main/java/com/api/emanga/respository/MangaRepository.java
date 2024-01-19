package com.api.emanga.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.emanga.model.MangaModel;

@Repository
public interface MangaRepository extends JpaRepository<MangaModel, Integer> {

}
