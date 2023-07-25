package com.springdatajpa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.app.dao.Employee;
import com.springdatajpa.app.dto.EmployeeDTO;
import com.springdatajpa.app.repo.mysql.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<EmployeeDTO> getAllEmployee() {
		List<EmployeeDTO> employees = EmployeeDTO.copyDaoToDtoList(employeeRepository.findAll());
		return employees;
	}

	public Employee getEmployeeByEmpNo(Integer empno) {
		Employee employee = employeeRepository.findByEmployeeNumber(empno);
		return employee;
	}
}
