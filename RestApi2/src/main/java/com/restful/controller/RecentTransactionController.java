package com.restful.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restful.dto.RecentTransactionDto;
import com.restful.response.ApiResponse;
import com.restful.service.RecentTransactionService;
import com.restful.serviceimpl.RecentTransactionServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.Authorization;

@RestController
public class RecentTransactionController {

	@Autowired
	private RecentTransactionService recentTransactionService;
	
	
	@PostMapping("/savedata")
	public ResponseEntity<?> saveTransactoin(@RequestBody RecentTransactionDto recentTransactionDto){
		try {
			
			RecentTransactionDto createTransaction = this.recentTransactionService.createTransaction(recentTransactionDto);
			if(createTransaction != null) {
	         return ResponseEntity.ok(new ApiResponse("Transaction Created","Successful",true, 201, Arrays.asList(createTransaction)));			
  			}else {
				return ResponseEntity.ok(new ApiResponse("Transaction Not Created","Failed",false, 400, Arrays.asList()));
				
			}
			
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal Server Error","Bad request",false, 502, Arrays.asList()));
		}
		
	}
	
	@GetMapping("/getbyid/{transactionId}")
	public ResponseEntity<?> getTransactionById(@PathVariable("transactionId") int transactionId){
		if(transactionId <= 0) {
			
			return new ResponseEntity<>(new ApiResponse("Bad Request", "Please enter transactionId is greater than 0",
					false, 400, Arrays.asList()), HttpStatus.BAD_REQUEST);
		}
		
			RecentTransactionDto isFindId = recentTransactionService.findById(transactionId);
			
			return ResponseEntity.ok(isFindId);
		
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllTransaction(){
		
		try {
			List<RecentTransactionDto> allTransaction = recentTransactionService.getAllTransaction();
			if(allTransaction != null && allTransaction.size() > 0) {
				return ResponseEntity.ok(new ApiResponse("Show All Transaciton","Successful", true, 203, allTransaction));
			}else
			{
				
				return ResponseEntity.ok(new ApiResponse("Transaciton not Show", "Failed",false, 400, allTransaction));
			}
			
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal server Error","Bad Requeset", false, 502));
		}
	
		
		
	}
	
	@PutMapping("updatedata/{transactionId}")
	public ResponseEntity<?> updateTransaction(@PathVariable("transactionId") int transactionId, @RequestBody RecentTransactionDto recentTransactionDto){
		try {
			String updateTransaction = recentTransactionService.updateTransaction(transactionId, recentTransactionDto);
			if(updateTransaction != null) {
				return ResponseEntity.ok(new ApiResponse("Updated All Transaction", "Successfull",true, 204));
			}else
			{
				return ResponseEntity.ok(new ApiResponse("Not update Transaciotn","Failed", false, 400));
			}
			
			
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal Server Error", "Bad Request", false, 502));
		}
		
	}
	
	@DeleteMapping("deletedata/{transactionId}")
	public ResponseEntity<?> deleteTransaion(@PathVariable("transactionId") int transactionId){
			
		
		try {
			
			String deleteTransaction = recentTransactionService.deleteTransaction(transactionId);
			if(deleteTransaction != null) {
				
			return ResponseEntity.ok(new ApiResponse("Deleted TransactionId ", "Successful", true, 202));
			}else
			{
				
				return ResponseEntity.ok(new ApiResponse("not Delete Transaction","Failed", false,400));
			}
			
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal Server Error", "Bad Request", false, 502));
		}
		
	}
	
	
	
}


















