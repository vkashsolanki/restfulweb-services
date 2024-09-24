package com.restful.service;

import java.util.List;

import com.restful.dto.RecentTransactionDto;
import com.restful.response.TransactionResponse;

public interface RecentTransactionService {
	
	
	public RecentTransactionDto createTransaction(RecentTransactionDto recentTransactionDto);
	public String deleteTransaction(int transactionId);
	public String updateTransaction(int transactionId, RecentTransactionDto recentTransactionDto);
	public List<RecentTransactionDto> getAllTransaction();
	public RecentTransactionDto findById(int transactionId);
	public TransactionResponse getAllTransationByPagination(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
}
