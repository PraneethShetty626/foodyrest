package com.praneeth.productService.Controller;

import com.praneeth.productService.Model.FoodItem;
import com.praneeth.productService.Service.FoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FoodsController {

    @Autowired
    private FoodsService  foodsService;


    @PostMapping("/add")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addFoodItem(@RequestBody FoodItem foodItem){
        foodsService.addFoodItem(foodItem);
    }

    @GetMapping("/getAllFoods")
    public List<FoodItem> getAllFoodItems(){
        return foodsService.getAllFoodItem();
    }

    @DeleteMapping("/deleteItem/{name}")
    public void deleteFoodItem(@PathVariable("name") String name){
        foodsService.deleteFood(name);
    }

    @PutMapping("/setAvailability/{name}")
    public void setFoodAvailabilityStatus(@PathVariable("name") String name) throws Exception {
        foodsService.updateFood(name);
    }
}
