package com.itau.thecat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itau.thecat.model.Breed;

public interface Breeds extends JpaRepository<Breed, String> {
	
	public List<Breed> findByNameContaining(String descricao);

}
