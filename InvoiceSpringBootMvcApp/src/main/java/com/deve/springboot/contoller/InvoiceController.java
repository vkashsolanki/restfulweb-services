package com.deve.springboot.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.deve.springboot.exception.InvoiceNotFoundException;
import com.deve.springboot.model.Invoice;
import com.deve.springboot.service.IInvoiceService;

@Controller
@RequestMapping(value = "/invoice")
public class InvoiceController {

@Autowired
private IInvoiceService service;	


@GetMapping("/")
public String showHomePage() {
	
	return "homepage";
	
}

@GetMapping("/register")
public String showRegistration()
{
	return "registerInvoicePage";
}

@PostMapping("/save")
public String saveInvoice(@ModelAttribute Invoice invoice, Model model) {
	service.saveInvoice(invoice);
	long id = service.saveInvoice(invoice).getId();
	String message = "Record With Id :: " +id+ " is save Succefully";
	model.addAttribute("message" ,message);
	
	return "registerInvoicePage";
	
}

@GetMapping(value = "/getAllInvoices")
public String getAllInvoices(@RequestParam(value = "message", required = false)String message, Model model) {
	
	List<Invoice> allInvoices = service.getAllInvoices();
	model.addAttribute("list",allInvoices);
	model.addAttribute("message", message);
	
	return "allInvoicePage";
}

@GetMapping("/edit")
public String getEditPage(Model model, RedirectAttributes attributes, @RequestParam Long id)
{
	String page = null;
	
	try {
		
		Invoice invoiceById = service.getInvoiceById(id);
		model.addAttribute("invoiceById", invoiceById);
		page="editInvoicePage";
		
	} catch (InvoiceNotFoundException e) {
		
		e.printStackTrace();
		attributes.addAttribute("message", e.getMessage());
		page = "redirect:getAllInvoices";
	}
	
	return page;
}

@PostMapping("/update")
public String updateInvoice(@ModelAttribute Invoice invoice, RedirectAttributes attributes) {
	service.updateInvoice(invoice);
	long id = invoice.getId();
	attributes.addAttribute("message", "Invoice with id ::"+id+ " is updated Successfully ");
	return "redirect:getAllInvoices";
}


@GetMapping("delete")
public String deleteInvoice(@RequestParam Long id, RedirectAttributes attributes) {
	
	try {
		
		service.deleteInvoiceById(id);
		attributes.addAttribute("message", "Invoice with id ::"+id+ " is Remove Successfully ");
			
	} catch (InvoiceNotFoundException e) {
		e.printStackTrace();
		attributes.addAttribute("message", e.getMessage());
	}
	
	return "redirect:getAllInvoices";
}


	

}
