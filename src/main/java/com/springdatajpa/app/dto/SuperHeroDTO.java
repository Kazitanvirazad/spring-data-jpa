package com.springdatajpa.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.springdatajpa.app.dao.SuperHero;

public class SuperHeroDTO implements Serializable {

	private static final long serialVersionUID = -7343941235810357687L;

	private Integer hid;

	private String hname;

	private String hpower;

	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHpower() {
		return hpower;
	}

	public void setHpower(String hpower) {
		this.hpower = hpower;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SuperHeroDTO() {
		super();
	}

	public SuperHeroDTO(Integer hid, String hname, String hpower) {
		this();
		this.hid = hid;
		this.hname = hname;
		this.hpower = hpower;
	}

	public SuperHeroDTO(SuperHero hero) {
		this();
		this.hid = hero.getHid();
		this.hname = hero.getHname();
		this.hpower = hero.getHpower();
	}

	public static List<SuperHeroDTO> copyDaoToDto(List<SuperHero> heros) {
		List<SuperHeroDTO> superHeroDTOs = new ArrayList<>();

		heros.forEach(hero -> {
			superHeroDTOs.add(new SuperHeroDTO(hero));
		});
		return superHeroDTOs;
	}
}
