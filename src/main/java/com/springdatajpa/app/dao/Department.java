package com.springdatajpa.app.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dept")
public class Department {
	@Id
	@Column(name = "deptno")
	private Integer departmentNumber;

	@Column(name = "dname")
	private String departmentName;

	@Column(name = "loc")
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

}
