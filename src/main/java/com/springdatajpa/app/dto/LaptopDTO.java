package com.springdatajpa.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;

import com.springdatajpa.app.dao.Laptop;
import com.springdatajpa.app.service.EmployeeService;
import com.springdatajpa.app.util.ApplicationContextUtil;

public class LaptopDTO implements Serializable {

	private static final long serialVersionUID = 6926261795853937368L;

	private Integer lid;

	private String laptopBrand;

	private String laptopModelName;

	private String processor;

	private Integer empno;

	private EmployeeDTO employee;

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

	public EmployeeDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

	public LaptopDTO() {
		super();
	}

	public LaptopDTO(Integer lid, String laptopBrand, String laptopModelName, String processor, Integer empno,
			EmployeeDTO employee) {
		this();
		this.lid = lid;
		this.laptopBrand = laptopBrand;
		this.laptopModelName = laptopModelName;
		this.processor = processor;
		this.empno = empno;
		this.employee = employee;
	}

	public LaptopDTO(Laptop laptop) {
		this();
		ApplicationContext context = ApplicationContextUtil.getApplicationContext();
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		this.lid = laptop.getLid();
		this.laptopBrand = laptop.getLaptopBrand();
		this.laptopModelName = laptop.getLaptopModelName();
		this.processor = laptop.getProcessor();
		this.empno = laptop.getEmpno();
		this.employee = new EmployeeDTO(employeeService.getEmployeeByEmpNo(laptop.getEmpno()));
	}

	public static List<LaptopDTO> copyDaoToDtoList(List<Laptop> laptops) {
		List<LaptopDTO> laptopDTOs = new ArrayList<>();
		laptops.forEach(laptop -> {
			laptopDTOs.add(new LaptopDTO(laptop));
		});
		return laptopDTOs;
	}

}
