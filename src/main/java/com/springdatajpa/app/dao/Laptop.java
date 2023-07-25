package com.springdatajpa.app.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "laptop")
public class Laptop {

	@Id
	@Column(name = "lid")
	private Integer lid;

	@Column(name = "laptopBrand")
	private String laptopBrand;

	@Column(name = "laptopModelName")
	private String laptopModelName;

	@Column(name = "processor")
	private String processor;

	@Column(name = "empno")
	private Integer empno;

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getLaptopBrand() {
		return laptopBrand;
	}

	public void setLaptopBrand(String laptopBrand) {
		this.laptopBrand = laptopBrand;
	}

	public String getLaptopModelName() {
		return laptopModelName;
	}

	public void setLaptopModelName(String laptopModelName) {
		this.laptopModelName = laptopModelName;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public Laptop() {
		super();
	}

}
