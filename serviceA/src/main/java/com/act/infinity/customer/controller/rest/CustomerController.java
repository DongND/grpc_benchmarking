package com.act.infinity.customer.controller.rest;

import com.act.infinity.customer.converter.RequestConverter;
import com.act.infinity.customer.converter.ResponseConverter;
import com.act.infinity.customer.model.dto.CustomerDTO;
import com.act.infinity.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private RequestConverter requestConverter;

	@Autowired
	private ResponseConverter responseConverter;

	@PostMapping("/api/v1/customer")
	public CustomerDTO createCustomer(@RequestBody CustomerDTO customer){
		return responseConverter.createDTO(
				customerService.createCustomer(requestConverter.createBO(customer)));
	}

	@GetMapping("/api/v1/customer/{id}")
	public CustomerDTO getCustomer(@PathVariable Integer id){
		return responseConverter.createDTO(
				customerService.getById(id));
	}
}
