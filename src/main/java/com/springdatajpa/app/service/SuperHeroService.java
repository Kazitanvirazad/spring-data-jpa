package com.springdatajpa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.app.dto.SuperHeroDTO;
import com.springdatajpa.app.repo.pg.SuperHeroRepository;

@Service
public class SuperHeroService {

	private SuperHeroRepository superHeroRepository;

	@Autowired
	public SuperHeroService(SuperHeroRepository superHeroRepository) {
		this.superHeroRepository = superHeroRepository;
	}

	public List<SuperHeroDTO> getAllSuperHero() {
		List<SuperHeroDTO> superHeros = SuperHeroDTO.copyDaoToDto(superHeroRepository.findAll());
		return superHeros;
	}

}
