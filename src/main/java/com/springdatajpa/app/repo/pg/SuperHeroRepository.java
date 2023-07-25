package com.springdatajpa.app.repo.pg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdatajpa.app.dao.SuperHero;

@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, Integer> {

}