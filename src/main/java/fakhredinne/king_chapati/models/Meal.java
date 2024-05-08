package fakhredinne.king_chapati.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Meal {
    @Id
    @GeneratedValue
    private Long id_meal;
    private String name;
    private String description;
    private int price;
    private String image;
    private boolean state;
    private Long test_id;
    @ManyToOne
    @JoinColumn(name = "category")
    Category cat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "retaurant_id")
    Restaurant restaurant;


}
