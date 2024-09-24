package com.restful.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecentTransactionDto {
	

	private int transactionId;
	private String transactionType;
	private String transactionStatus;
	private String transactionModeOfPayment;
	private String transactionCredit;
	private Date transactonDateAndTime;
	
	

}
