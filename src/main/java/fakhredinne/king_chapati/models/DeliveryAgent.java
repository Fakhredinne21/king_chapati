package fakhredinne.king_chapati.models;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "DeliveryAgent")
public class DeliveryAgent extends User{
    private String full_name;
    @ManyToOne
    DeliverySociety deliv_soc;

    @OneToMany(cascade = CascadeType.ALL,mappedBy="delivAgent")
    private Set<Order> orders;
}
