package fakhredinne.king_chapati.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "Orders")

public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_order;
    private String status,destination;
    private LocalDateTime orderDate;
    private int total_price;
    @OneToMany(mappedBy="order")
    private List<OrderItem> order_items=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "customer")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "delivAgent")
    DeliveryAgent delivAgent;

}
