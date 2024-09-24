package com.restapi.service;

import java.util.List;

import com.restapi.dto.RecentTransactionDto;

public interface RecentTransactionService {
	
	public RecentTransactionDto createTransaction(RecentTransactionDto recentTransactionDto); 
	public RecentTransactionDto findByIdTransaction(long transactionId);
	public List<RecentTransactionDto> findAllTransactions();
	public String updateTransactions(long transactionId, RecentTransactionDto  recentTransactionDto);
	public String deleteTransaction(long transactionId);

}
