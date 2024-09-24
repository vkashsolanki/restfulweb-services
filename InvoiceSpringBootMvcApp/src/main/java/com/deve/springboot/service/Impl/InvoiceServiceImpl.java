package com.deve.springboot.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deve.springboot.exception.InvoiceNotFoundException;
import com.deve.springboot.model.Invoice;
import com.deve.springboot.repo.InvoiceRepository;
import com.deve.springboot.service.IInvoiceService;

@Service
public class InvoiceServiceImpl implements IInvoiceService{
	
	@Autowired
	private InvoiceRepository repo;
	
	
	

	@Override
	public Invoice saveInvoice(Invoice invoice) {
		
		
		return repo.save(invoice);
	}

	@Override
	public List<Invoice> getAllInvoices() {
		List<Invoice> findAll = repo.findAll();
		return findAll;
	}

	@Override
	public Invoice getInvoiceById(Long id) {
		Optional<Invoice> findById = repo.findById(id);
		if(findById.isPresent()) {
			Invoice invoice = findById.get();
			return 	invoice;
		}else {
			throw new InvoiceNotFoundException("Invoice with Id ::=>"+ id + " NOT FOUND ");
		}
		
		
	}

	@Override
	public void deleteInvoiceById(Long id) {
		repo.delete(getInvoiceById(id));
		
		//repo.deleteById(id);
		
	}

	@Override
	public void updateInvoice(Invoice invoice) {
		//Invoice save = repo.save(invoice);
		//System.out.println(save);
		repo.save(invoice);
	}

}
