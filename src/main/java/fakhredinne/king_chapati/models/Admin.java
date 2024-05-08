package fakhredinne.king_chapati.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User{
    @Id
    @GeneratedValue
    private Long idAdmin;
}
