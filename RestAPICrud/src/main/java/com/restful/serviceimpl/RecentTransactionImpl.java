package com.restful.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.dto.RecentTransactionDto;
import com.restful.entity.RecentTransaction;
import com.restful.repository.RecentTransactionRepository;
import com.restful.response.TransactionResponse;
import com.restful.service.RecentTransactionService;

@Service
public class RecentTransactionImpl implements RecentTransactionService {

	@Autowired
	private RecentTransactionRepository recentTransactionRepository;

	// Create Transaction
	@Override
	public RecentTransactionDto createTransaction(RecentTransactionDto recentTransactionDto) {

		RecentTransactionDto recentTransactionDto1 = new RecentTransactionDto();
		RecentTransaction recentTransaction = new RecentTransaction();
		if (recentTransaction != null) {
			// get data
			recentTransaction.setTransactionCredit(recentTransactionDto.getTransationDCredits());
			recentTransaction.setDateTime(new Date());
			recentTransaction.setTransactionPaymentMode(recentTransactionDto.getTransactionDPaymentMode());
			recentTransaction.setTransactionStatus(recentTransactionDto.getTransationDStatus());
			recentTransaction.setTransactionType(recentTransactionDto.getTransationDType());
			recentTransaction.setTransactionId(recentTransactionDto.getTransactionDId());
		}

		// save data
		RecentTransaction saveTransaction = this.recentTransactionRepository.save(recentTransaction);
		if (saveTransaction != null) {
			recentTransactionDto1.setTransactionDId(saveTransaction.getTransactionId());
			recentTransactionDto1.setDdateTime(saveTransaction.getDateTime());
			recentTransactionDto1.setTransactionDPaymentMode(saveTransaction.getTransactionPaymentMode());
			recentTransactionDto1.setTransationDCredits(saveTransaction.getTransactionCredit());
			recentTransactionDto1.setTransationDStatus(saveTransaction.getTransactionStatus());
			recentTransactionDto1.setTransationDType(saveTransaction.getTransactionType());

		}

		return recentTransactionDto1;
	}

	// Delete Transaction
	@Override
	public String deleteTransaction(int transactionId) {

		this.recentTransactionRepository.delete(recentTransactionRepository.findById(transactionId).get());

		return "Delete Successfully";
	}

	// Update Transaction
	@Override
	public String updateTransaction(int transactionId, RecentTransactionDto recentTransactionDto) {
		RecentTransaction dto = this.recentTransactionRepository.findById(transactionId).get();
		if (dto != null) {
			dto.setTransactionPaymentMode(recentTransactionDto.getTransactionDPaymentMode());
			dto.setDateTime(new Date());
			dto.setTransactionCredit(recentTransactionDto.getTransationDCredits());
			dto.setTransactionStatus(recentTransactionDto.getTransationDStatus());
			dto.setTransactionType(recentTransactionDto.getTransationDType());

			recentTransactionRepository.save(dto);

		}
		return "Updated Successfully";
	}

	// GetAll Transactions
	@Override
	public List<RecentTransactionDto> getAllTransaction() {
		
		ArrayList<RecentTransactionDto> arrayList = new ArrayList<RecentTransactionDto>();
		List<RecentTransaction> list = this.recentTransactionRepository.findAll();
		
		for(RecentTransaction recentTransaction : list) {
			RecentTransactionDto transactionDto = new RecentTransactionDto();
			transactionDto.setTransactionDId(recentTransaction.getTransactionId());
			transactionDto.setDdateTime(new Date());
			transactionDto.setTransactionDPaymentMode(recentTransaction.getTransactionPaymentMode());
			transactionDto.setTransationDCredits(recentTransaction.getTransactionCredit());
			transactionDto.setTransationDStatus(recentTransaction.getTransactionStatus());
			transactionDto.setTransationDType(recentTransaction.getTransactionStatus());
			
			arrayList.add(transactionDto);
			
		}
		
		
		return arrayList;
	}

	// Get Transaction by ID
	@Override
	public RecentTransactionDto findById(int transactionId) {
		RecentTransaction recentTransaction = this.recentTransactionRepository.findById(transactionId).get();
		RecentTransactionDto recentTransactionDto = new RecentTransactionDto();
		if(recentTransactionDto != null) {
			recentTransactionDto.setTransactionDId(recentTransaction.getTransactionId());
			recentTransactionDto.setDdateTime(new Date());
			recentTransactionDto.setTransactionDPaymentMode(recentTransaction.getTransactionPaymentMode());
			recentTransactionDto.setTransationDCredits(recentTransaction.getTransactionCredit());
			recentTransactionDto.setTransationDStatus(recentTransaction.getTransactionStatus());
			recentTransactionDto.setTransationDType(recentTransaction.getTransactionType());
		}
		
		
		return recentTransactionDto;
	}

	// GetAll Transacton by pagination

	@Override
	public TransactionResponse getAllTransationByPagination(Integer pageNumber, Integer pageSize, String sortBy,
			String sortDir) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}
