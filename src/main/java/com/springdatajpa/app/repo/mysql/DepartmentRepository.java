package com.springdatajpa.app.repo.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdatajpa.app.dao.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
