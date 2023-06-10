package com.praneeth.productService.Service;

import com.praneeth.productService.Model.FoodItem;
import com.praneeth.productService.Repository.FoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodsService {
    @Autowired
    private FoodsRepository foodsRepository;

    public void  addFoodItem(FoodItem foodItem){
        foodsRepository.save(foodItem);
    }

    public List<FoodItem> getAllFoodItem(){
        return foodsRepository.findAll();
    }

    public void deleteFood(String name){
        foodsRepository.deleteById(name);
    }

    public void  updateFood(String name) throws Exception {
       Optional<FoodItem> item = foodsRepository.findById(name);

       if(item.isPresent()){
          FoodItem up_item =  item.get();
          up_item.setAvailable(!up_item.isAvailable());

           foodsRepository.save(up_item);
       }
       else {
           throw new Exception("item "+name + "not found");
       }
    }
}
