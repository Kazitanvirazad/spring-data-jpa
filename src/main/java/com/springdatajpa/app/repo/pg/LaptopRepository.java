package com.springdatajpa.app.repo.pg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdatajpa.app.dao.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

}
