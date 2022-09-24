package miu.edu.cs544.cartservice.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cart {
    @Id
    private Long userId;
    @OneToMany
    List<CartItem> cartItems;

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Cart() {
    }

    public Cart(Long userId) {
        this.userId = userId;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}
