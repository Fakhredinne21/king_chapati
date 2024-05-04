package fakhredinne.king_chapati.models;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "Restaurant")
public class Restaurant extends User{

@ManyToOne
Subscription sub;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="restaurant")
    private Set<Order> orders;

    @Getter
    @OneToMany(cascade = CascadeType.ALL,mappedBy="restaurant")
    private Set<Meal> meals;


}
