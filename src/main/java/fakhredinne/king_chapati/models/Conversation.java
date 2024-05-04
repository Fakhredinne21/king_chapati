package fakhredinne.king_chapati.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table( name = "Conversation")
@Getter
@Setter
@ToString
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_convr")
    private Long id_convr;
    @ManyToOne
    private Restaurant restaurant;
    @ManyToOne
    private Client client;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="conversation")
    private Set<Message> messagess ;


}
