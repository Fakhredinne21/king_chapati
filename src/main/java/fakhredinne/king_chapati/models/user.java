package fakhredinne.king_chapati.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;
@Entity
@Table( name = "user")
@Getter
@Setter
@ToString
public class user {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private Long id_user;
    private Long username;
    private Long password;
    private String full_name;
    private String email;
    private int phone_number;






}

