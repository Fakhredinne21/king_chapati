package fakhredinne.king_chapati.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "Delivery_society")
@Getter
@Setter
@ToString
public class DeliverySociety {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_soc")
    private Long id_soc;
    private String name,email;
    private int phone_number;


}
