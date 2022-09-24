package miu.edu.cs544.cartservice.Service;

import miu.edu.cs544.cartservice.Domain.CartItem;
import miu.edu.cs544.cartservice.Repository.CartItemRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartItemServiceImpl implements CartItemService{
    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem addCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem updateCartItem(Long id, CartItem itemRequest) {

        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException((String) null));
        cartItem.setFoodId(itemRequest.getFoodId());
        cartItem.setUserId(itemRequest.getUserId());
        cartItem.setQuantity(itemRequest.getQuantity());
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(Long id) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException((String) null));
        cartItemRepository.save(cartItem);
    }
}
