package miu.edu.cs544.orderservice.repository;

import miu.edu.cs544.orderservice.domain.Order;
import org.hibernate.query.QueryParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query(value = "from order_table o where o.user_id =:a and o.order_status.id = :b")
    public List<Order> findOrderById(@Param("a") Long id, @Param("b") Long status_id);
}



