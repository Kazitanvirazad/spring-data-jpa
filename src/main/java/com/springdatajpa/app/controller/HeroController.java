package com.springdatajpa.app.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdatajpa.app.dto.SuperHeroDTO;
import com.springdatajpa.app.service.SuperHeroService;

@RestController
@RequestMapping(path = "/hero")
public class HeroController {

	private SuperHeroService superHeroService;

	@GetMapping(path = "/getallheroes", produces = { "application/json" })
	public ResponseEntity<List<SuperHeroDTO>> getAllHero() {
		return new ResponseEntity<>(superHeroService.getAllSuperHero(), new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(path = "/demo", produces = { "application/json" })
	public ResponseEntity<String> getDemo() {
		return new ResponseEntity<>("Hello Kazi", new HttpHeaders(), HttpStatus.OK);
	}

}
