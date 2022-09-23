package miu.edu.cs544.orderservice.service;

import miu.edu.cs544.orderservice.domain.Order;
import miu.edu.cs544.orderservice.domain.OrderStatus;
import miu.edu.cs544.orderservice.repository.OrderRepository;
import miu.edu.cs544.orderservice.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public List<Order> getOrderById(Integer i, Integer u){
        return orderRepository.getOrderById(i,u);
    }

    public void createOrder(Order order){
        orderRepository.save(order);
    }

    public void updateOrder(Integer order_id,Integer status_id){
         Order order = orderRepository.findById(order_id).get();
        OrderStatus orderStatus = orderStatusRepository.findById(status_id).get();

         order.setOrder_status(orderStatus);
        orderRepository.save(order);
    }
}
