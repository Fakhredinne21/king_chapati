package fakhredinne.king_chapati.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryCompany {
    @Id
    @GeneratedValue
    private Long id_comp;
    private String name,email;
    private int phone_number;

    @OneToMany(mappedBy="deliv_comp")
    private Set<DeliveryAgent> agents;




}
