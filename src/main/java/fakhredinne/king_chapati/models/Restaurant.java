package fakhredinne.king_chapati.models;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Restaurant extends User{

    private String Location;
    @ManyToOne
    @JoinColumn(name = "Subscription")
    Subscription sub;
    @OneToMany(mappedBy="restaurant")
    private Set<OrderItem> orders;
    @Getter
    @OneToMany(mappedBy="restaurant")
    private List<Meal> meals;


}
