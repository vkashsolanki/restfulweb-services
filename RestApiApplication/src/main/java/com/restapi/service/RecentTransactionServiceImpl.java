package com.restapi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.dto.RecentTransactionDto;
import com.restapi.entity.RecentTransaction;
import com.restapi.repository.RecentTransactionRepository;


@Service
public class RecentTransactionServiceImpl implements RecentTransactionService{
	
	@Autowired
	private RecentTransactionRepository recentTransactionRepository;

	@Override
	public RecentTransactionDto createTransaction(RecentTransactionDto recentTransactionDto) {
		
		 RecentTransactionDto recentTransactionDto2 = new RecentTransactionDto();
		
		RecentTransaction recentTransaction = new RecentTransaction();
		if(recentTransaction != null) {
			recentTransaction.setTransactionId(recentTransactionDto.getTransactionId());
			recentTransaction.setTransactionCredit(recentTransactionDto.getTransactionCredit());
			recentTransaction.setTransactionDateAndTime(new Date());
			recentTransaction.setTransactionModeOfPayment(recentTransactionDto.getTransactionModeOfPayment());
			recentTransaction.setTransactionType(recentTransactionDto.getTransacitonType());
			recentTransaction.setTransationStatus(recentTransactionDto.getTransactionStatus());
			
		}
		
		RecentTransaction saveTransaction = recentTransactionRepository.save(recentTransaction);
		
		if(saveTransaction != null) {
			
			recentTransactionDto2.setTransactionId(saveTransaction.getTransactionId());
			recentTransactionDto2.setTransacitonType(saveTransaction.getTransactionType());
			recentTransactionDto2.setTransactionDateAndtime(new Date());
			recentTransactionDto2.setTransactionModeOfPayment(saveTransaction.getTransactionModeOfPayment());
			recentTransactionDto2.setTransactionStatus(saveTransaction.getTransationStatus());
			recentTransactionDto2.setTransactionCredit(saveTransaction.getTransactionCredit());
		}
		
		
		
		
		
		return  recentTransactionDto;
	}

	@Override
	public RecentTransactionDto findByIdTransaction(long transactionId) {

			
			RecentTransaction recentTransaction = recentTransactionRepository.findById(transactionId).get();
			RecentTransactionDto recentTransactionDto = new RecentTransactionDto();
			if(recentTransactionDto != null) {
				
				recentTransactionDto.setTransacitonType(recentTransaction.getTransactionType());
				recentTransactionDto.setTransactionCredit(recentTransaction.getTransactionCredit());
				recentTransactionDto.setTransactionModeOfPayment(recentTransaction.getTransactionModeOfPayment());
				recentTransactionDto.setTransactionDateAndtime(new Date());
				recentTransactionDto.setTransactionStatus(recentTransaction.getTransationStatus());
				
			}
			

		return recentTransactionDto;
	}

	@Override
	public List<RecentTransactionDto> findAllTransactions() {
		
		ArrayList<RecentTransactionDto> arrayList = new ArrayList<RecentTransactionDto>();
		
		List<RecentTransaction> list = this.recentTransactionRepository.findAll();
		
		for(RecentTransaction recentTransaction : list) {
			RecentTransactionDto recentTransactionDto2 = new RecentTransactionDto();
			
			recentTransactionDto2.setTransacitonType(recentTransaction.getTransactionType());
			recentTransactionDto2.setTransactionCredit(recentTransaction.getTransactionCredit());
			recentTransactionDto2.setTransactionDateAndtime(new Date());
			recentTransactionDto2.setTransactionId(recentTransaction.getTransactionId());
			recentTransactionDto2.setTransactionModeOfPayment(recentTransaction.getTransactionModeOfPayment());
			recentTransactionDto2.setTransactionStatus(recentTransaction.getTransationStatus());
			
			arrayList.add(recentTransactionDto2);
			
		}
		return arrayList;
		
		
	}

	@Override
	public String updateTransactions(long transactionId, RecentTransactionDto recentTransactionDto) {
		
		
		RecentTransaction recentTransaction = this.recentTransactionRepository.findById(transactionId).get();
		if(recentTransaction != null)
		{
			//recentTransaction.setTransactionId(recentTransactionDto.getTransactionId());
			recentTransaction.setTransactionCredit(recentTransactionDto.getTransactionCredit());
			recentTransaction.setTransactionDateAndTime(new Date());
			recentTransaction.setTransactionModeOfPayment(recentTransactionDto.getTransactionModeOfPayment());
			recentTransaction.setTransationStatus(recentTransactionDto.getTransactionStatus());
			recentTransaction.setTransactionType(recentTransactionDto.getTransacitonType());
			
			recentTransactionRepository.save(recentTransaction);
		}
		
		return "updated Succesfull";
	}

	@Override
	public String deleteTransaction(long transactionId) {
		//RecentTransaction deleteTransaction = recentTransactionRepository.findById(transactionId).get();
		//recentTransactionRepository.delete(deleteTransaction);
		
		recentTransactionRepository.delete(recentTransactionRepository.findById(transactionId).get());

		return "Delete Successfully";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
