package fakhredinne.king_chapati.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;
@Entity
@Table( name = "Delievery_Society")
@Getter
@Setter
@ToString
public class Delievery_Society {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_soc")
    private Long id_soc;
    private String name,email;
    private int phone_number;


}
