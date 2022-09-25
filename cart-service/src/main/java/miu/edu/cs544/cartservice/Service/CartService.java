package miu.edu.cs544.cartservice.Service;

import miu.edu.cs544.cartservice.DTO.CartDTO;
import miu.edu.cs544.cartservice.Domain.Cart;
import miu.edu.cs544.cartservice.Domain.CartItem;

import java.util.List;

public interface CartService {
    void createCart(Cart cart);
    CartDTO getCart(Integer id);
}
