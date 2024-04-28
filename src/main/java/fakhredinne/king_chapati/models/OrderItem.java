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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_item")
    private int id_item;
    private int quantity;
    @ManyToOne
    Meal meal;
    @ManyToOne
    Order order;

}
