package miu.edu.cs544.cartservice.Controller;

import miu.edu.cs544.cartservice.DTO.CartDTO;
import miu.edu.cs544.cartservice.DTO.CartItemDTO;
import miu.edu.cs544.cartservice.Domain.Cart;
import miu.edu.cs544.cartservice.Domain.CartItem;
import miu.edu.cs544.cartservice.Service.CartItemService;
import miu.edu.cs544.cartservice.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @GetMapping("/getcart/{user_id}")
    public ResponseEntity<CartDTO> getCart(@PathVariable Integer user_id){
        CartDTO cart = cartService.getCart(user_id);
        if (cart==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
//        this.kafkaTemplate.send("events.new", " Cart Accessed "+cart.toString()+" Accessed at "+timestamp2);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PostMapping("/createCart")
    public ResponseEntity<?> createCart(@RequestBody Cart cart){
        cartService.createCart(cart);
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        this.kafkaTemplate.send("events.new", "Cart created "+cart.toString()+" Added at "+timestamp2);
        return new ResponseEntity<>("Cart created successfully", HttpStatus.OK);
    }
}
