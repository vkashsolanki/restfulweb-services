package com.deve.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
public class Invoice {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String location;
	private double amount;
	

}
