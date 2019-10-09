package com.act.infinity.customer.controller.rest;

import com.act.infinity.customer.converter.RequestConverter;
import com.act.infinity.customer.converter.ResponseConverter;
import com.act.infinity.customer.model.dto.OrderDTO;
import com.act.infinity.customer.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	RequestConverter requestConverter;

	@Autowired
	ResponseConverter responseConverter;

	@GetMapping("/api/v1/order/{id}")
	public OrderDTO getOrder(@PathVariable Integer id){
		return responseConverter.createDTO(
				orderService.getById(id));
	}
	@GetMapping("/api/v1/customer/{customerId}/orders")
	public List<OrderDTO> getCustomer(@PathVariable Integer customerId){
		return responseConverter.createListDTO(orderService.getByCustomerId(customerId));
	}
}
