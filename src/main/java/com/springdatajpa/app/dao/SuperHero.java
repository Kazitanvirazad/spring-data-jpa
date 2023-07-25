package com.springdatajpa.app.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dchero")
public class SuperHero {

	@Id
	@Column(name = "hid")
	private Integer hid;

	@Column(name = "hname")
	private String hname;

	@Column(name = "hpower")
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

}
