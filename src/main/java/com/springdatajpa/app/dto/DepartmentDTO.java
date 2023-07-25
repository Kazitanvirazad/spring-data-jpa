package com.springdatajpa.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.springdatajpa.app.dao.Department;

public class DepartmentDTO implements Serializable {

	private static final long serialVersionUID = 8544789826701489690L;

	private Integer departmentNumber;

	private String departmentName;

	private String location;

	public Integer getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(Integer departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public DepartmentDTO() {
		super();
	}

	public DepartmentDTO(Department department) {
		this();
		this.departmentNumber = department.getDepartmentNumber();
		this.departmentName = department.getDepartmentName();
		this.location = department.getLocation();
	}

	public DepartmentDTO(Integer departmentNumber, String departmentName, String location) {
		this();
		this.departmentNumber = departmentNumber;
		this.departmentName = departmentName;
		this.location = location;
	}

	public static List<DepartmentDTO> copyDaoToDtoList(List<Department> departments) {
		List<DepartmentDTO> departmentDTOs = new ArrayList<>();

		departments.forEach(dept -> {
			departmentDTOs.add(new DepartmentDTO(dept));
		});
		return departmentDTOs;
	}
}
