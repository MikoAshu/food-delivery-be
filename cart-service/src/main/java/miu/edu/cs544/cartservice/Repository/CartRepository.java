package miu.edu.cs544.cartservice.Repository;

import miu.edu.cs544.cartservice.Domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
