package com.ecart.data.pojo;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderData {
	private BigDecimal orderId;
	private String orderDescription;
	private String orderQty;
	private BigDecimal orderPrice;

}
