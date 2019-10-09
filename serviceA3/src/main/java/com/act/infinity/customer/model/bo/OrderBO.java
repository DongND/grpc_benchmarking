package com.act.infinity.customer.model.bo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderBO {
  private Integer id;
  private Integer customerId;
  private Integer orderNumber;
}
