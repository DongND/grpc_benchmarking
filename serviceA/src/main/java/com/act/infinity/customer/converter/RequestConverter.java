package com.act.infinity.customer.converter;

import com.act.infinity.customer.grpc.CreateCustomerRequest;
import com.act.infinity.customer.model.bo.CustomerBO;
import com.act.infinity.customer.model.bo.OrderBO;
import com.act.infinity.customer.model.dto.CustomerDTO;
import com.act.infinity.customer.model.dto.OrderDTO;

public interface RequestConverter {
  CustomerBO createBO(CreateCustomerRequest obj);
  CustomerBO createBO(CustomerDTO obj);

  OrderBO createBO(OrderDTO obj);
}
