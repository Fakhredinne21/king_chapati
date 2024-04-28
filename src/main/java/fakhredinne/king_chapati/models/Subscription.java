package fakhredinne.king_chapati.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "Subscription")
@Getter
@Setter
@ToString
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_sub")
    private int id_sub;
    private String name,decription;
    private int price;


}
