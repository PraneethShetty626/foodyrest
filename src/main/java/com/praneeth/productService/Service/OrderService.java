package com.praneeth.productService.Service;

import com.praneeth.productService.Model.Orders;
import com.praneeth.productService.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void orderFood(Orders order){
        orderRepository.save(order);
    }

    public List<Orders> getAllOrders(){
        return orderRepository.findAll();
    }

    public void setStatusDelivered(String orderid) throws  Exception{
        Optional<Orders> order = orderRepository.findById(orderid);
        if(order.isPresent()){
            Orders up_order = order.get();
            boolean c_status = up_order.isDelivery_Status();

            if(c_status){
                throw new Exception("Order already delivered");
            }
            up_order.setDelivery_Status(true);
            orderRepository.save(up_order);
        }
        else {
            throw new Exception("Order "+orderid + "not found");
        }
    }


}

