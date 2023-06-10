package com.praneeth.productService.Controller;


import com.praneeth.productService.Model.Orders;
import com.praneeth.productService.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public void postOrder(@RequestBody Orders orders){
        orderService.orderFood(orders);
    }
    
    @GetMapping("/allOrders")
    public List<Orders> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PutMapping("/setDeliverd/{order_id}")
    public  void  setDeliveredStatus(@PathVariable("order_id") String order_id) throws  Exception{
         orderService.setStatusDelivered(order_id);
    }
}
