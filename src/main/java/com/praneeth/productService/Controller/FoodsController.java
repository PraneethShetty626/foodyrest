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

    @CrossOrigin("https://foodyres.web.app")
    @PostMapping("/add")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addFoodItem(@RequestBody FoodItem foodItem){
        foodsService.addFoodItem(foodItem);
    }
    @CrossOrigin("https://foodyres.web.app")
    @GetMapping("/getAllFoods")
    public List<FoodItem> getAllFoodItems(){
        return foodsService.getAllFoodItem();
    }

    @CrossOrigin("https://foodyres.web.app")
    @DeleteMapping("/deleteItem/{name}")
    public void deleteFoodItem(@PathVariable("name") String name){
        foodsService.deleteFood(name);
    }

    @CrossOrigin("https://foodyres.web.app")
    @PutMapping("/setAvailability/{name}")
    public void setFoodAvailabilityStatus(@PathVariable("name") String name) throws Exception {
        foodsService.updateFood(name);
    }
}
