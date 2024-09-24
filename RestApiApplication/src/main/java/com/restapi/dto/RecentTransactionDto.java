package com.restapi.dto;

import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecentTransactionDto {
	
	private long transactionId;
	private String transacitonType;
	private String transactionStatus;
	private String transactionCredit;
	private String transactionModeOfPayment;
	private Date transactionDateAndtime;

}
