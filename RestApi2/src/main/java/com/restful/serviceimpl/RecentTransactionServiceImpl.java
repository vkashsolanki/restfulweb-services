package com.restful.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.dto.RecentTransactionDto;
import com.restful.entity.RecentTransaction;
import com.restful.repository.RecentTransactionRepository;
import com.restful.service.RecentTransactionService;

@Service
public class RecentTransactionServiceImpl implements RecentTransactionService {

	@Autowired
	private RecentTransactionRepository recentTransactionRepository;

	@Override
	public RecentTransactionDto createTransaction(RecentTransactionDto recentTransactionDto) {

		RecentTransactionDto recentTransactionDto2 = new RecentTransactionDto();

		RecentTransaction recentTransaction = new RecentTransaction();
		if (recentTransaction != null) {
			recentTransaction.setTransactionId(recentTransactionDto.getTransactionId());
			recentTransaction.setTransactionType(recentTransactionDto.getTransactionType());
			recentTransaction.setTransactionStatus(recentTransactionDto.getTransactionStatus());
			recentTransaction.setTransactionModeOfPayment(recentTransactionDto.getTransactionModeOfPayment());
			recentTransaction.setTransactionCredit(recentTransactionDto.getTransactionCredit());
			recentTransaction.setTransactonDateAndTime(new Date());

		} 
			RecentTransaction saveTransaction = recentTransactionRepository.save(recentTransaction);
			if (saveTransaction != null) {
				recentTransactionDto2.setTransactionId(saveTransaction.getTransactionId());
				recentTransactionDto2.setTransactionType(saveTransaction.getTransactionType());
				recentTransactionDto2.setTransactionStatus(saveTransaction.getTransactionStatus());
				recentTransactionDto2.setTransactionModeOfPayment(saveTransaction.getTransactionModeOfPayment());
				recentTransactionDto2.setTransactionCredit(saveTransaction.getTransactionCredit());
				recentTransactionDto2.setTransactonDateAndTime(saveTransaction.getTransactonDateAndTime());

			}

		
		return recentTransactionDto2;

	}

	@Override
	public RecentTransactionDto findById(int transactionId) {
	  RecentTransaction recentTransaction = this.recentTransactionRepository.findById(transactionId).get();
	  RecentTransactionDto recentTransactionDto = new RecentTransactionDto();
	  if(recentTransactionDto != null) {
		  recentTransactionDto.setTransactionId(recentTransaction.getTransactionId());
		  recentTransactionDto.setTransactionType(recentTransaction.getTransactionType());
		  recentTransactionDto.setTransactionStatus(recentTransaction.getTransactionStatus());
		  recentTransactionDto.setTransactionCredit(recentTransaction.getTransactionCredit());
		  recentTransactionDto.setTransactionStatus(recentTransaction.getTransactionModeOfPayment());
		  recentTransactionDto.setTransactonDateAndTime(new Date());
	  }
	  
		return recentTransactionDto;
	}

	@Override
	public List<RecentTransactionDto> getAllTransaction() {
		ArrayList<RecentTransactionDto> arrayList = new ArrayList<RecentTransactionDto>();
		List<RecentTransaction> list = recentTransactionRepository.findAll();
		for (RecentTransaction recentTransaction : list) {
			RecentTransactionDto recentTransactionDto = new RecentTransactionDto();
			
			recentTransactionDto.setTransactionId(recentTransaction.getTransactionId());
			recentTransactionDto.setTransactionType(recentTransaction.getTransactionType());
			recentTransactionDto.setTransactionCredit(recentTransaction.getTransactionCredit());
			recentTransactionDto.setTransactionModeOfPayment(recentTransaction.getTransactionModeOfPayment());
			recentTransactionDto.setTransactionStatus(recentTransaction.getTransactionStatus());
			recentTransactionDto.setTransactonDateAndTime(new Date());
			arrayList.add(recentTransactionDto);
		}
		
		return arrayList;
	}

	@Override
	public String updateTransaction(int transactionId, RecentTransactionDto recentTransactionDto) {
		
		 RecentTransaction recentTransaction = recentTransactionRepository.findById(transactionId).get();
		 if(recentTransaction != null) {
			 recentTransaction.setTransactionCredit(recentTransactionDto.getTransactionCredit());
			 recentTransaction.setTransactionModeOfPayment(recentTransactionDto.getTransactionModeOfPayment());
			 recentTransaction.setTransactionStatus(recentTransactionDto.getTransactionStatus());
			 recentTransaction.setTransactionType(recentTransactionDto.getTransactionType());
			 recentTransaction.setTransactonDateAndTime(new Date());
			 
			 recentTransactionRepository.save(recentTransaction);
			 
		 }
		 return "Updated Successfully";

	}

	@Override
	public String deleteTransaction(int transactionId) {
		
	    this.recentTransactionRepository.delete(recentTransactionRepository.findById(transactionId).get());
		return "Deleted Successfully";
	}

}
