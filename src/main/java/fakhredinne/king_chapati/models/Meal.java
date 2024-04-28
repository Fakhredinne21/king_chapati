package fakhredinne.king_chapati.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "Meals")
@Getter
@Setter
@ToString
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_meal")
    private String name;
    private String description;
    private int price;
}
