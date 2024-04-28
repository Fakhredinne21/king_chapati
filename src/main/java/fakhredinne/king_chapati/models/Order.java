package fakhredinne.king_chapati.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table( name = "orders")
@Getter
@Setter
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_order")
    private int id_order;
    private String status,destination;
    private LocalDate order_date;
    private int total_price;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="order")
    private Set<OrderItem> order_items;

    @ManyToOne
    Restaurant restaurant;

    @ManyToOne
    Client client;

    @ManyToOne
    DeliveryAgent delivAgent;


}
