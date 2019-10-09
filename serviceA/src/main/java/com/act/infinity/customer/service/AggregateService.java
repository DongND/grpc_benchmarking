package com.act.infinity.customer.service;

import com.act.infinity.customer.converter.RequestConverter;
import com.act.infinity.customer.model.bo.OrderBO;
import com.act.infinity.customer.model.dto.OrderDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AggregateService {

  @Autowired
  private HttpClientService httpClientService;

  @Autowired
  private RequestConverter requestConverter;

  // Get all order by customerId, customerId +1, customerId + 2
  public List<OrderBO> getAllOrdersByCustomerId(Integer firstCustomerId){
    List<OrderDTO> first = httpClientService.getOrdersByCustomerId("http://localhost:8001",  firstCustomerId);
    List<OrderDTO> second = httpClientService.getOrdersByCustomerId("http://localhost:8002", firstCustomerId +1);
    List<OrderDTO> third = httpClientService.getOrdersByCustomerId("http://localhost:8003", firstCustomerId +2);

    List listDTOs = new ArrayList<OrderDTO>();
    listDTOs.addAll(first != null ? first : new ArrayList());
    listDTOs.addAll(second != null ? second : new ArrayList());
    listDTOs.addAll(third != null ? third : new ArrayList());
    List ret = new ArrayList<OrderBO>();

    listDTOs.forEach(el->{
      ret.add(requestConverter.createBO((OrderDTO) el));

    });

    return ret;
  }
}
