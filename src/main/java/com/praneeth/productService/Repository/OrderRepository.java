package com.praneeth.productService.Repository;

import com.praneeth.productService.Model.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Orders,String> {
}
