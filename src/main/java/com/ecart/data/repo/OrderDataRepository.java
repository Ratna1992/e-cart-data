package com.ecart.data.repo;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecart.data.entity.OrderDataEntity;

@Repository
public interface OrderDataRepository extends MongoRepository<OrderDataEntity, BigInteger> {

}
