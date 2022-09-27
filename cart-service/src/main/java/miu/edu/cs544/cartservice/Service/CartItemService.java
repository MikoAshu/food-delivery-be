package miu.edu.cs544.cartservice.Service;

import miu.edu.cs544.cartservice.DTO.CartItemDTO;
import miu.edu.cs544.cartservice.Domain.CartItem;

import java.util.List;

public interface CartItemService {
    List<CartItemDTO> getAllCartItems();
    void addCartItem(CartItem cartItem);
    void updateCartItem(Integer id, CartItem itemRequest);
    void deleteCartItem(Integer id);

}
