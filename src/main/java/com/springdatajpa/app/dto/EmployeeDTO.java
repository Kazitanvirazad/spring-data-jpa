package com.springdatajpa.app.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.springdatajpa.app.dao.Employee;

public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 9170914812990338413L;

	private Integer employeeNumber;

	private String employeeName;

	private String designation;

	private Integer manager;

	private Date hireDate;

	private Integer salary;

	private Integer commission;

	private DepartmentDTO department;

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getCommission() {
		return commission;
	}

	public void setCommission(Integer commission) {
		this.commission = commission;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(Integer employeeNumber, String employeeName, String designation, Integer manager, Date hireDate,
			Integer salary, Integer commission, DepartmentDTO department) {
		this();
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;
		this.designation = designation;
		this.manager = manager;
		this.hireDate = hireDate;
		this.salary = salary;
		this.commission = commission;
		this.department = department;
	}

	public EmployeeDTO(Employee employee) {
		this();
		this.employeeNumber = employee.getEmployeeNumber();
		this.employeeName = employee.getEmployeeName();
		this.designation = employee.getDesignation();
		this.manager = employee.getManager();
		this.hireDate = employee.getHireDate();
		this.salary = employee.getSalary();
		this.commission = employee.getCommission();
		this.department = new DepartmentDTO(employee.getDepartment());
	}

	public static List<EmployeeDTO> copyDaoToDtoList(List<Employee> employees) {
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();

		employees.forEach(emp -> {
			employeeDTOs.add(new EmployeeDTO(emp));
		});
		return employeeDTOs;
	}
}
