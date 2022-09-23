package miu.edu.cs544.orderservice.repository;

import miu.edu.cs544.orderservice.domain.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus,Integer> {
}
