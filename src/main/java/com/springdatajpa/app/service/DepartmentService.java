package com.springdatajpa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.app.dto.DepartmentDTO;
import com.springdatajpa.app.repo.mysql.DepartmentRepository;

@Service
public class DepartmentService {
	private DepartmentRepository departmentRepository;

	@Autowired
	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	public List<DepartmentDTO> getAllDepartments() {
		List<DepartmentDTO> departments = DepartmentDTO.copyDaoToDtoList(departmentRepository.findAll());
		return departments;
	}

}
