package miu.edu.cs544.cartservice.DTO;

import lombok.Data;

@Data
public class CartItemDTO {
    private Long id;
    private Long userId;
    private Long foodId;
    private Integer quantity;
}
