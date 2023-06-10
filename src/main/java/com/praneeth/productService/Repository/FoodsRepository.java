package com.praneeth.productService.Repository;

import com.praneeth.productService.Model.FoodItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodsRepository extends MongoRepository<FoodItem,String> {
}
