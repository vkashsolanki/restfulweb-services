package com.restapi.controller;

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

import com.restapi.dto.RecentTransactionDto;
import com.restapi.response.ApiResponse;
import com.restapi.service.RecentTransactionService;

@RestController
public class RecentTransactionController {
	
	
	@Autowired
	private RecentTransactionService recentTransactionService;
	
	@PostMapping("/savedata")
	public ResponseEntity<?> saveTransaction(@RequestBody RecentTransactionDto recentTransactionDto){
		
		try {
			RecentTransactionDto createTransaction = recentTransactionService.createTransaction(recentTransactionDto);
			if(createTransaction != null) {
			
			return ResponseEntity.ok(new ApiResponse("Transaction created", "Successful", true, 201, Arrays.asList(createTransaction)));
			
			}else
			{
				return ResponseEntity.ok(new ApiResponse("Transaction not Created", "Failed", false, 400, Arrays.asList()));
				
			}
			
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal Server Error", "Bad Request", false, 502,Arrays.asList()));
		}
		
	}
	
	
	@GetMapping("/getbyid/{transactionId}")
	public ResponseEntity<?> getByIdTransaction(@PathVariable("transactionId") long transactionId, RecentTransactionDto dto){
		
	
			
			if(transactionId <=0) {
				return new ResponseEntity<>(new ApiResponse("Bad Request", "Please enter the transaction id is greater than 0", false, 400, Arrays.asList()),HttpStatus.BAD_REQUEST);
			}
			
			RecentTransactionDto findByIdTransaction = recentTransactionService.findByIdTransaction(transactionId);
			
			return ResponseEntity.ok(findByIdTransaction);
			

		
	}

	@GetMapping("/getall")
	public ResponseEntity<?> findAllTransactions(@RequestBody RecentTransactionDto recentTransactionDto){
		
		try {
			List<RecentTransactionDto> findAllTransactions = recentTransactionService.findAllTransactions();
			if(findAllTransactions != null && findAllTransactions.size( )> 0) {
				
			return ResponseEntity.ok(new ApiResponse("Show All Transactions", "Success", true, 203, findAllTransactions));
			
			}else {
				
				return ResponseEntity.ok(new ApiResponse("Not Show all Transaction", "Failed", false, 400, findAllTransactions));
			}
			
		} catch (Exception e) {
			
			return ResponseEntity.ok(new ApiResponse("Internal Server Error", "Bad Request", false, 502));
			
		}
		
		
		
	}
	
	
	@PutMapping("/upddate/{transactionId}")
	public ResponseEntity<?> updateTransaction(@RequestBody RecentTransactionDto recentTransactionDto,@PathVariable("transactionId") long transactionId){
		
			try {
				String updateTransaction = recentTransactionService.updateTransactions(transactionId, recentTransactionDto);
				if(updateTransaction != null) {
					
					return ResponseEntity.ok(new ApiResponse("Updated Transaction", "Success", true, 204));
				}else
				{
					return ResponseEntity.ok(new ApiResponse("not Update Transaction", "Failed", false, 400));
				}
				
				
			} catch (Exception e) {
				return ResponseEntity.ok(new ApiResponse("Internal Server Error", "Bad request", false, 504));
			}
		
		
		
	}
	
	@DeleteMapping("deletetran/{transactionId}")
	public ResponseEntity<?> deleteTransaction(@PathVariable("transactionId")long transactionId){
		
		try {
			String deleteTransaction = recentTransactionService.deleteTransaction(transactionId);
			if(deleteTransaction != null) {
				
				return ResponseEntity.ok(new ApiResponse("Delete Transaction", "Success", true, 203));
			}else
			{
				return ResponseEntity.ok(new ApiResponse("Not Delete Transaction", "Failed", false, 400));
			}
		} catch (Exception e) {
			return ResponseEntity.ok(new ApiResponse("Internal Server Error", "Bad request", false, 503));
		}
		
		
	}
	
	

}
