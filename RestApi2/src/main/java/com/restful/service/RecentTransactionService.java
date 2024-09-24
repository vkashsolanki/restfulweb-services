package com.restful.service;

import java.util.List;

import com.restful.dto.RecentTransactionDto;

public interface RecentTransactionService {
	
	public RecentTransactionDto createTransaction(RecentTransactionDto recentTransactionDto);
	public RecentTransactionDto findById(int transactionId);
	public List<RecentTransactionDto> getAllTransaction();
	public String updateTransaction(int transactionId, RecentTransactionDto recentTransactionDto);
	public String deleteTransaction(int transactionId);
	

}
