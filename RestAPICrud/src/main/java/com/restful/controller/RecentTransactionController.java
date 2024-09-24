package com.restful.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restful.dto.RecentTransactionDto;
import com.restful.response.ApiResponse;
import com.restful.serviceimpl.RecentTransactionImpl;

@RestController
public class RecentTransactionController {

	@Autowired
	private RecentTransactionImpl recentTransactionImpl;
	
	@PostMapping(value = "/savedata")
	public ResponseEntity<?> saveTransaction(@RequestBody RecentTransactionDto recentTransactionDto) {

		RecentTransactionDto createTransaction = this.recentTransactionImpl.createTransaction(recentTransactionDto);
		try {
			if (createTransaction != null) {
				return ResponseEntity.ok(new ApiResponse("Transaction created", "Successfull", true, 201, Arrays.asList(createTransaction)));
			} else {
				return ResponseEntity.ok(new ApiResponse("Transaction Not Created", "failed", false, 400, Arrays.asList(createTransaction)));

			}

		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal Server Error", "Bad Requeset", false, 502, Arrays.asList()));
		}

	}
	
	
	@DeleteMapping(value = "/delete/{transactionId}")
	public ResponseEntity<?> deleteTransaction(@PathVariable("transactionId") int transationId){
		try {
			
			String deleteTransaction = this.recentTransactionImpl.deleteTransaction(transationId);
			if(deleteTransaction != null) {
				return ResponseEntity.ok(new ApiResponse("Transaction Deleted", "Successful", true, 202));
			}else {
				return ResponseEntity.ok(new ApiResponse("Transaction Not Deleted", "Failed", false, 400));
			}
			
			
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal Server Error", "Bad resquest", false, 502));
		}

	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<?> getAllTransactions(){
		
		List<RecentTransactionDto> allTransaction = this.recentTransactionImpl.getAllTransaction();
		try {
			if(allTransaction != null && allTransaction.size() > 0) {
				return ResponseEntity.ok(new ApiResponse("Show All Transactions", "successfull",true, 203, allTransaction));
			}else {
				return ResponseEntity.ok(new ApiResponse("Not Show All Transaction", "Failed", false, 400, allTransaction));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Inernal Server Error", "Bad Request", false, 502));
		}
		
	}
	
	@PutMapping(value = "/update/{transactionId}")
	public ResponseEntity<?> updateTransaction(@RequestBody RecentTransactionDto recentTransactionDto, @PathVariable("transactionId") int transactionId){
		
		
		try {
			String updateTransaction = this.recentTransactionImpl.updateTransaction(transactionId, recentTransactionDto);
			
			if(updateTransaction != null) {
				return ResponseEntity.ok(new ApiResponse("updated All Transaction","Successful",true, 204));
			}else {
				return ResponseEntity.ok(new ApiResponse("Transaction Not updated", "Failed", false, 400));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal Server Error", "Bad Request", false, 502));
		}
		
	}
	
	@GetMapping(value = "/getId/{transactionId}")
	public ResponseEntity<?> getTransactionById(@PathVariable("transactionId") int transactionId){
		
		if(transactionId < 0) {
			
			return new ResponseEntity<>(new ApiResponse("BAD REQUEST", "Please enter the transactinId is greter than Zero", false, 400, Arrays.asList()),
					HttpStatus.BAD_REQUEST);
		}
		
		RecentTransactionDto findById = this.recentTransactionImpl.findById(transactionId);
		return ResponseEntity.ok(findById);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
