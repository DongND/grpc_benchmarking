package com.act.infinity.customer.converter;

import com.act.infinity.customer.grpc.CreateCustomerResponse;
import com.act.infinity.customer.model.bo.CustomerBO;
import com.act.infinity.customer.model.bo.OrderBO;
import com.act.infinity.customer.model.dto.CustomerDTO;
import com.act.infinity.customer.model.dto.OrderDTO;
import com.act.infinity.order.grpc.GetOrderListResponse;
import com.act.infinity.order.grpc.GetOrderResponse;
import java.util.List;

public interface ResponseConverter {

  CreateCustomerResponse createCustomerResponseGRPC(CustomerBO obj);  //for gRPC
  CustomerDTO createDTO(CustomerBO obj);  // for REST

  GetOrderResponse getOrderResponseGRPC(OrderBO input); //for gRPC
  OrderDTO createDTO(OrderBO obj);   // for REST

  GetOrderListResponse getOrderCustomerListResponseGRPC(List<OrderBO> objList);  //for gRPC
  List<OrderDTO> createListDTO(List<OrderBO> objList); // for REST

}
