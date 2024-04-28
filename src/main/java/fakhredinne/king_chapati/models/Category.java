package fakhredinne.king_chapati.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;
@Entity
@Table( name = "category")
@Getter
@Setter
@ToString
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_cat")
    private int id_cat;
    private String name;

}
