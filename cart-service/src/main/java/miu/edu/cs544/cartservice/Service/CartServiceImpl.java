package miu.edu.cs544.cartservice.Service;

import miu.edu.cs544.cartservice.DTO.CartDTO;
import miu.edu.cs544.cartservice.Domain.Cart;
import miu.edu.cs544.cartservice.Domain.CartItem;
import miu.edu.cs544.cartservice.Repository.CartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;

    @Override
    public void createCart(Cart cart) {
         cartRepository.save(cart);
    }

    @Override
    public CartDTO getCart(Integer id) {
        Cart c = cartRepository.getById(id);
        ModelMapper modelMapper = new ModelMapper();
        CartDTO  cartDTO  = modelMapper.map(c, CartDTO.class);
        return cartDTO;
    }
}
