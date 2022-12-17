package com.ecart.data.entity;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "orders_data")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDataEntity {
	@Id
	private BigInteger orderId;
	private String orderDescription;
	private String orderQty;
	private Double orderPrice;

}
