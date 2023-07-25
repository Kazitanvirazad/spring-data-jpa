package com.springdatajpa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.app.dto.LaptopDTO;
import com.springdatajpa.app.repo.pg.LaptopRepository;

@Service
public class LaptopService {

	private LaptopRepository laptopRepository;

	@Autowired
	public LaptopService(LaptopRepository laptopRepository) {
		this.laptopRepository = laptopRepository;
	}

	public List<LaptopDTO> getAllLaptop() {
		return LaptopDTO.copyDaoToDtoList(laptopRepository.findAll());
	}
}
