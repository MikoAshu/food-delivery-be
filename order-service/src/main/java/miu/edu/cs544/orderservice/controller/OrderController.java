package miu.edu.cs544.orderservice.controller;

import miu.edu.cs544.orderservice.domain.Order;
import miu.edu.cs544.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<?>  getOrder(){
        return new ResponseEntity<> (orderService.getOrders(), HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<?>  getOrders(@RequestParam Integer user_id,  @RequestParam(required = false,defaultValue = "created") Integer status_id ){
        return new ResponseEntity<>(orderService.getOrderById(user_id,status_id),HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<?> createOrder(@RequestBody Order order){
        orderService.createOrder(order);
    return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/order")
    public ResponseEntity<?> updateOrder(@RequestParam Integer order_id, Integer status_id){
        orderService.updateOrder(order_id,status_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
