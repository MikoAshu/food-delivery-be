package miu.edu.cs544.cartservice.Repository;

import miu.edu.cs544.cartservice.Domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long > {
}
