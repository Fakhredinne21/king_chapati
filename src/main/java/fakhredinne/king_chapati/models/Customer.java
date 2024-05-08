package fakhredinne.king_chapati.models;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer extends User {
    @Id
    @GeneratedValue
    private Long idcustomer;
    @OneToMany(mappedBy="customer")
    private Set<Order> orders;


}
