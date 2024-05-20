package fakhredinne.king_chapati.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "order_item")
@Getter
@Setter
@ToString
public class OrderItem {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_item;
    private String status;
    private int quantity;
    @ManyToOne
            @JoinColumn(name = "Meal_id")
    Meal meal;
    @ManyToOne
    @JoinColumn(name = "Order_id")
    Order order;
    @ManyToOne
    @JoinColumn(name = "restaurant")
    Restaurant restaurant;

}
