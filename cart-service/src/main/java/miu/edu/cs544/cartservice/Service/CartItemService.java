package miu.edu.cs544.cartservice.Service;

import miu.edu.cs544.cartservice.Domain.CartItem;

import java.util.List;

public interface CartItemService {
    List<CartItem> getAllCartItems();
    CartItem addCartItem(CartItem cartItem);
    CartItem updateCartItem(Long id, CartItem itemRequest);
    void deleteCartItem(Long id);

}
