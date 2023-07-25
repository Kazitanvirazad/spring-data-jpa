package com.springdatajpa.app;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.springdatajpa.app.dto.DepartmentDTO;
import com.springdatajpa.app.dto.EmployeeDTO;
import com.springdatajpa.app.dto.LaptopDTO;
import com.springdatajpa.app.dto.SuperHeroDTO;
import com.springdatajpa.app.service.DepartmentService;
import com.springdatajpa.app.service.EmployeeService;
import com.springdatajpa.app.service.LaptopService;
import com.springdatajpa.app.service.SuperHeroService;
import com.springdatajpa.app.util.ApplicationContextUtil;
import com.springdatajpa.app.util.SerializeUtil;

public class Application {

	public static void main(String[] args) {

		ApplicationContext context = ApplicationContextUtil.getApplicationContext();
		DepartmentService departmentService = context.getBean(DepartmentService.class);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		SuperHeroService sHeroService = context.getBean(SuperHeroService.class);
		LaptopService laptopService = context.getBean(LaptopService.class);

		List<EmployeeDTO> employees = employeeService.getAllEmployee();
		List<DepartmentDTO> departments = departmentService.getAllDepartments();
		List<SuperHeroDTO> superHeros = sHeroService.getAllSuperHero();
		List<LaptopDTO> laptops = laptopService.getAllLaptop();

		employees.forEach((emp) -> {
			System.out.println(SerializeUtil.serialize(emp));
		});

		departments.forEach((dept) -> {
			System.out.println(SerializeUtil.serialize(dept));
		});

		superHeros.forEach((hero) -> {
			System.out.println(SerializeUtil.serialize(hero));
		});

		laptops.forEach((laptop) -> {
			System.out.println(SerializeUtil.serialize(laptop));
		});

	}

}
