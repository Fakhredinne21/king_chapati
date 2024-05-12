package fakhredinne.king_chapati.models;

import jakarta.persistence.*;
import lombok.*;


import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User   {
    @Id
    @GeneratedValue
    private Long idAdmin;
    @Enumerated(EnumType.STRING)
    private Role role;



}
