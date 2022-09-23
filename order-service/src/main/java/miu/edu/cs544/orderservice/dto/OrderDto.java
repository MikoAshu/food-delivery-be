package miu.edu.cs544.orderservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDto {
    private Integer id;
    private Integer user_id;
    private Integer cart_id;
    private Double total_price;
    private String confirmation_number;
    private LocalDate order_time;
}
