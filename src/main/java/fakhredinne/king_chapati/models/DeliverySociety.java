package fakhredinne.king_chapati.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table( name = "DelieverySociety")
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
    @OneToMany(cascade = CascadeType.ALL,mappedBy="DeliverySociety")
    private Set<DeliveryAgent> agents;




}
