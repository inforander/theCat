package com.itau.thecat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itau.thecat.model.Breed;
import com.itau.thecat.model.dto.BreedDTO;
import com.itau.thecat.repository.Breeds;
import com.itau.thecat.repository.filter.BreedFilter;

@Service
public class TheCatService {

	@Autowired
	private TheCatAPIService theCatAPIService;

	@Autowired
	private Breeds breeds;
	
	@Autowired
	private ObjectMapper mapper;

	public List<BreedDTO> listBreeds() throws Exception {
		List<BreedDTO> listBreeds = theCatAPIService.listBreeds();
		listBreeds.forEach(breed -> {
			Breed breedRepo = mapper.convertValue(breed, Breed.class);
			save(breedRepo);
		});
		return listBreeds;
	}
	
	public List<Breed> filtrar(BreedFilter filtro) {
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		return breeds.findByNameContaining(descricao);
	}

	public void save(Breed breed) {
		try {
			breeds.save(breed);
		} catch (Exception e) {
			throw e;
		}
	}

	public void delete(String id) {
		breeds.delete(id);
	}

	public Breed find(String id) {
		return breeds.findOne(id);
	}

}
