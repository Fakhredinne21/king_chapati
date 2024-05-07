package fakhredinne.king_chapati.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
    @GeneratedValue
    private Integer id_order;
    private String status,destination;
    @Column(
            updatable = false ,nullable = false

    )
    private LocalDateTime orderDate;
    private int total_price;
    @OneToMany(mappedBy="order")
    private Set<OrderItem> order_items;

    @ManyToOne
            @JoinColumn(name = "restaurant")
    Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "Client")
    Client client;

    @ManyToOne
    @JoinColumn(name = "delivAgent")
    DeliveryAgent delivAgent;





}
