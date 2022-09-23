package miu.edu.cs544.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderStatus {
    @Id
    @GeneratedValue
    private Integer statusId;
    private String name;
    private String code;


}
