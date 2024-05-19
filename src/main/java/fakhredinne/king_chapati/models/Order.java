package fakhredinne.king_chapati.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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
    @GeneratedValue
    private Integer id_order;
    private String status,destination;
    private LocalDateTime orderDate;
    private int total_price;
    @OneToMany(mappedBy="order")
    private Set<OrderItem> order_items;
    @ManyToOne
    @JoinColumn(name = "customer")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "delivAgent")
    DeliveryAgent delivAgent;





}
