package fakhredinne.king_chapati.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAgent extends User{
    private String full_name;
    @ManyToOne
    @JoinColumn(name = "Company")
    DeliveryCompany deliv_comp;
    @OneToMany(mappedBy="delivAgent")
    private Set<Order> orders;
}
