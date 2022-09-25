package miu.edu.cs544.cartservice.Controller;

import miu.edu.cs544.cartservice.DTO.CartItemDTO;
import miu.edu.cs544.cartservice.Domain.CartItem;
import miu.edu.cs544.cartservice.Service.CartItemService;
import org.modelmapper.ModelMapper;
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
public class CartItemController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/cart")
    public ResponseEntity<List<CartItemDTO>> getAllCartItems() {
        List<CartItemDTO> itemDTOS= cartItemService.getAllCartItems();
        if (itemDTOS==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        this.kafkaTemplate.send("events.new", "List of Cart items  "+itemDTOS.toString()+"Accessed at"+timestamp2);

        return new ResponseEntity<>(itemDTOS, HttpStatus.OK);

    }

    @PostMapping("/cart")
    public ResponseEntity<?> addCartItem(@RequestBody CartItem cartItem) {
        cartItemService.addCartItem(cartItem);
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        this.kafkaTemplate.send("events.new", "Cart Item Added "+cartItem.toString()+" Added at "+timestamp2);
        return new ResponseEntity<>("Cart item added successfully", HttpStatus.OK);
    }

    @PutMapping("/cart/{id}")
    public ResponseEntity<?> updateCartItem(@PathVariable Integer id, @RequestBody CartItem cartItem) {
        cartItemService.updateCartItem(id,cartItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/cart/{id}")
    public ResponseEntity<CartItemDTO> deleteCartItem(@PathVariable Integer id) {
        cartItemService.deleteCartItem(id);
        CartItemDTO cartItemResponse = modelMapper.map(null, CartItemDTO.class);
        return ResponseEntity.ok().body(cartItemResponse);
    }
}
