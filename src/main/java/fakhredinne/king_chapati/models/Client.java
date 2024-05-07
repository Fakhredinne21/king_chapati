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
@Table( name = "Client")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client extends User {
    @Id
    @GeneratedValue
    private Long idclient;
    @OneToMany(mappedBy="client")
    private Set<Order> orders;


}
