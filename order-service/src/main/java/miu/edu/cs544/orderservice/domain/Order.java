package miu.edu.cs544.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer user_id;
    private Integer cart_id;
    private double total_price;
    private String confirmation_number;
    private LocalDate order_time;

    @ManyToOne
    private OrderStatus order_status;


    public Order(Integer user_id, Integer cart_id, double total_price) {
        this.user_id = user_id;
        this.cart_id = cart_id;
        this.total_price = total_price;
        this.order_time = LocalDate.now();
        this.confirmation_number = generate();
           }
           public String generate(){
               Random random = new Random();
               int x =  random.nextInt(0,1000);
               return "aa" + x;
           }



}
