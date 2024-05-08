package fakhredinne.king_chapati.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Subscription {
    @Id
    @GeneratedValue
    private Long id_sub;
    private String name,decription;
    private int price;
     @OneToMany(mappedBy = "sub")
    private Set<Restaurant> restaurants;

}
