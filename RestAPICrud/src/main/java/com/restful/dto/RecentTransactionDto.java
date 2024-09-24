package com.restful.dto;

import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecentTransactionDto {
	
	
	private int transactionDId;
	private String transationDType;
	private String transationDStatus;
	private String transactionDPaymentMode;
	private String transationDCredits;
	private Date DdateTime;

}
