package com.caches.entity;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class City {
	
	private String name;
	private String villageno;

}
