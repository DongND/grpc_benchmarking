package com.act.infinity.customer.controller.grpc;


import com.act.infinity.customer.converter.RequestConverter;
import com.act.infinity.customer.converter.ResponseConverter;
import com.act.infinity.customer.service.OrderService;
import com.act.infinity.order.grpc.GetCustomerOrderRequest;
import com.act.infinity.order.grpc.GetOrderListResponse;
import com.act.infinity.order.grpc.OrderServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class OrderGrpcController extends OrderServiceGrpc.OrderServiceImplBase {

  @Autowired
  OrderService orderService;

  @Autowired
  RequestConverter requestConverter;

  @Autowired
  ResponseConverter responseConverter;

  @Override
  public void getCustomerOrderList(GetCustomerOrderRequest request, StreamObserver<GetOrderListResponse> responseStreamObserver){

    GetOrderListResponse response = responseConverter.getOrderCustomerListResponseGRPC(orderService.getByCustomerId(request.getCustomerId()));

    responseStreamObserver.onNext(response);
    responseStreamObserver.onCompleted();
  }



}
