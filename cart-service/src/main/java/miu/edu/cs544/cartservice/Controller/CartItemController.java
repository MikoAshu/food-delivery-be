package miu.edu.cs544.cartservice.Controller;

import miu.edu.cs544.cartservice.DTO.CartItemDTO;
import miu.edu.cs544.cartservice.Domain.CartItem;
import miu.edu.cs544.cartservice.Service.CartItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartItemController {
    @Autowired
    private ModelMapper modelMapper;

    private CartItemService cartItemService;

    @GetMapping("/")
    public List<CartItemDTO> getAllCartItems() {
        return cartItemService.getAllCartItems().stream().map(item -> modelMapper.map(item, CartItemDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    public ResponseEntity<CartItemDTO> addCartItem(@RequestBody CartItemDTO cartItemDTO) {
        //convert DTO to entity
        CartItem cartItemRequest = modelMapper.map(cartItemDTO, CartItem.class);
        CartItem item = cartItemService.addCartItem(cartItemRequest);

        //convert entity to DTO
        CartItemDTO cartItemResponse = modelMapper.map(item, CartItemDTO.class);
        return new ResponseEntity<CartItemDTO>(cartItemResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItemDTO> updateCartItem(@PathVariable Long id, @RequestBody CartItemDTO cartItemDTO) {
        CartItem cartItemRequest = modelMapper.map(cartItemDTO, CartItem.class);
        CartItem item = cartItemService.updateCartItem(id, cartItemRequest);

        CartItemDTO cartItemResponse = modelMapper.map(item, CartItemDTO.class);
        return ResponseEntity.ok().body(cartItemResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CartItemDTO> deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
        CartItemDTO cartItemResponse = modelMapper.map(null, CartItemDTO.class);
        return ResponseEntity.ok().body(cartItemResponse);
    }
}
