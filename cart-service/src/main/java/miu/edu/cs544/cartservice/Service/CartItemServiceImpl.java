package miu.edu.cs544.cartservice.Service;

import miu.edu.cs544.cartservice.DTO.CartItemDTO;
import miu.edu.cs544.cartservice.Domain.CartItem;
import miu.edu.cs544.cartservice.Repository.CartItemRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CartItemServiceImpl implements CartItemService{
    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public List<CartItemDTO> getAllCartItems() {
        List<CartItem> items = cartItemRepository.findAll();
        List<CartItemDTO> itemDTOS = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(CartItem item: items){
            itemDTOS.add(modelMapper.map(item, CartItemDTO.class));
        }
        return itemDTOS;

    }

    @Override
    public void addCartItem(CartItem cartItem) {cartItemRepository.save(cartItem);
    }

    @Override
    public void updateCartItem(Integer id, CartItem itemRequest) {

        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException((String) null));
        cartItem.setFoodId(itemRequest.getFoodId());
        cartItem.setUserId(itemRequest.getUserId());
        cartItem.setQuantity(itemRequest.getQuantity());
        cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(Integer id) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException((String) null));
        cartItemRepository.save(cartItem);
    }
}
