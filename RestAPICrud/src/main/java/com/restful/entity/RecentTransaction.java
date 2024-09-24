package com.restful.entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rcTable")
@Entity
public class RecentTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	private String transactionType;
	private String transactionStatus;
	private String transactionPaymentMode;
	private String transactionCredit;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	
	

}
