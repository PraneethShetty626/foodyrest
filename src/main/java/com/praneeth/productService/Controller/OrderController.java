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

    @CrossOrigin("https://foodyres.web.app")
    @PostMapping("/order")
    public void postOrder(@RequestBody Orders orders){
        orderService.orderFood(orders);
    }

    @CrossOrigin("https://foodyres.web.app")
    @GetMapping("/allOrders")
    public List<Orders> getAllOrders(){
        return orderService.getAllOrders();
    }

    @CrossOrigin("https://foodyres.web.app")
    @PutMapping("/setDeliverd/{order_id}")
    public  void  setDeliveredStatus(@PathVariable("order_id") String order_id) throws  Exception{
         orderService.setStatusDelivered(order_id);
    }
}
