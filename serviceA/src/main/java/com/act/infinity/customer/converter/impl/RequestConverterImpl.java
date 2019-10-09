package com.act.infinity.customer.converter.impl;

import com.act.infinity.customer.converter.RequestConverter;
import com.act.infinity.customer.grpc.CreateCustomerRequest;
import com.act.infinity.customer.model.bo.CustomerBO;
import com.act.infinity.customer.model.bo.OrderBO;
import com.act.infinity.customer.model.dto.CustomerDTO;
import com.act.infinity.customer.model.dto.OrderDTO;
import org.springframework.stereotype.Service;

@Service
public class RequestConverterImpl implements RequestConverter {

  @Override
  public CustomerBO createBO(CreateCustomerRequest input){

    return new CustomerBO(input.getRequest().getId(), input.getRequest().getName());
  }

  @Override
  public CustomerBO createBO(CustomerDTO input){

    return new CustomerBO(input.getId(), input.getName());
  }

  @Override
  public OrderBO createBO(OrderDTO obj){
    return new OrderBO(obj.getId(), obj.getCustomerId(), obj.getOrderNumber());
  }

}
