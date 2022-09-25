package miu.edu.cs544.orderservice.controller;

import miu.edu.cs544.orderservice.domain.Order;
import miu.edu.cs544.orderservice.dto.OrderDto;
import miu.edu.cs544.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private KafkaTemplate<Object,Object> kafkaTemplate;



    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>>  getOrders(@RequestParam(required = false) Long user_id, @RequestParam(required = false) Long status_id){
        if (status_id == null || user_id == null){
//            orderService.getOrders();

            List<OrderDto> orders =  orderService.getOrders();
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());

            this.kafkaTemplate.send("events.new",orders.toString() + "Accessed at: " + timestamp);
            return new ResponseEntity<>(orders,HttpStatus.OK);
        }

        List<OrderDto> orderDtos = orderService.getOrderById(user_id,status_id);
        this.kafkaTemplate.send("events.new",orderDtos);
        return new ResponseEntity<>(orderDtos,HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<?> createOrder(@RequestBody Order order){
        orderService.createOrder(order);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        this.kafkaTemplate.send("events.new",order.toString() + timestamp);
    return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/order")
    public ResponseEntity<?> updateOrder(@RequestParam Long order_id, Long status_id){
        orderService.updateOrder(order_id,status_id);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        this.kafkaTemplate.send("events.new","this status id of "+ order_id + "is updated to: " +  + status_id + "at: " + timestamp);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/order")
    public ResponseEntity<?> deleteOrder(@RequestParam Long id){
        orderService.deleteOrder(id);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        this.kafkaTemplate.send("events.new",  "order with order_id of: " + id + "is deleted at "+ timestamp );
        return new ResponseEntity<>(HttpStatus.OK);

    }




}
