package miu.edu.cs544.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

@Entity(name = "order_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private Long user_id;
    private Integer cart_id;
    private Double total_price;
    private String confirmation_number;
    private LocalDate order_time;

    @ManyToOne
    private OrderStatus order_status;


    public Order(Long user_id, Integer cart_id, Double total_price) {
        this.user_id = user_id;
        this.cart_id = cart_id;
        this.total_price = total_price;
        this.order_time = LocalDate.now();
        this.confirmation_number = generate();
           }
           public String generate(){
               Random random = new Random();
               String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
               String NUMBERS = "0123456789";
               StringBuilder builder = new StringBuilder();
               for (int i = 0; i < 7; i++) {
                   if(i%2 == 0){
                       int y =  random.nextInt(0,25);
                       builder.append(LETTERS.charAt(y));
                   } else {
                       int y =  random.nextInt(0,9);
                       builder.append(NUMBERS.charAt(y));
                   }
               }
               return builder.toString();
           }



}
