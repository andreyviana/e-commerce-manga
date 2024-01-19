package com.api.emanga.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.emanga.model.GeneroModel;

@Repository
public interface GeneroRepository extends JpaRepository<GeneroModel, Integer> {

}
