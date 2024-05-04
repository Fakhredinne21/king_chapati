package fakhredinne.king_chapati.models;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table( name = "Client")

public class Client extends User{
    @OneToMany(cascade = CascadeType.ALL,mappedBy="client")
    private Set<Order> orders;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="client")
    private Set<Conversation>conversations ;

}
