package com.restful.response;

import java.util.List;

import com.restful.dto.RecentTransactionDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
	
	
	private List<RecentTransactionDto> trContent;
	private int pageNumber;
	private int pageSize;
	private long totalElement;
	private int totalPage;
	private boolean lastPage;
	
	
	
	

}
