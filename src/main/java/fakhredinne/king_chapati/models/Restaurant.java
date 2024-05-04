package fakhredinne.king_chapati.models;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "Restaurant")
public class Restaurant extends User{

@ManyToOne
Subscription sub;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="restaurant")
    private Set<Order> orders;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="restaurant")
    private Set<Conversation> conversations;

}
