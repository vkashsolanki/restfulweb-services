package com.deve.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deve.springboot.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
