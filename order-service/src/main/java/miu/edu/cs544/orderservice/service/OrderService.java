package miu.edu.cs544.orderservice.service;

import miu.edu.cs544.orderservice.domain.Order;
import miu.edu.cs544.orderservice.domain.OrderStatus;
import miu.edu.cs544.orderservice.dto.OrderDto;
import miu.edu.cs544.orderservice.repository.OrderRepository;
import miu.edu.cs544.orderservice.repository.OrderStatusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    public List<OrderDto> getOrders(){
        ModelMapper mapper = new ModelMapper();
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        for(Order o : orders){
            orderDtos.add(mapper.map(o,OrderDto.class));
        }
        return orderDtos;
    }

    public List<OrderDto> getOrderById(Long user_id, Long status_id){
        List<Order> orders = orderRepository.findOrderById(user_id, status_id);
        ModelMapper mapper = new ModelMapper();
        List<OrderDto> orderDtos = new ArrayList<>();
        for(Order o : orders){
            orderDtos.add(mapper.map(o,OrderDto.class));
        }
        return orderDtos;

    }

    public void createOrder(Order order){
        orderRepository.save(order);
    }


    public void updateOrder(Long order_id,Long status_id){
         Order order = orderRepository.findById(order_id).get();
         OrderStatus orderStatus =  orderStatusRepository.findById(status_id).get();
         order.setOrder_status(orderStatus);
        orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
