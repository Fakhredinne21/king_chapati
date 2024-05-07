package fakhredinne.king_chapati.models;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Category {
    @Id
    @GeneratedValue
    private int id_cat;
    private String name;
    @OneToMany(mappedBy = "cat")
    private Set<Meal> meals;
}
