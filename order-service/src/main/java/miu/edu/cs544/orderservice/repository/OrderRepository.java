package miu.edu.cs544.orderservice.repository;

import miu.edu.cs544.orderservice.domain.Order;
import org.hibernate.query.QueryParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query(value = "select o from Order o join o.order_status s where o.user_id =:u and s.statusId = :i")
    public List<Order> getOrderById(@Param("u") Integer u, @Param("i") Integer i);
}



