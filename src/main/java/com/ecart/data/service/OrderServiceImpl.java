package com.ecart.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.data.entity.OrderDataEntity;
import com.ecart.data.repo.OrderDataRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDataRepository repo;

	@Override
	public List<OrderDataEntity> getOrders() {
		return repo.findAll();
		
	}

}
