package fakhredinne.king_chapati.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.net.PasswordAuthentication;
import java.util.Set;

@MappedSuperclass
//@Table( name = "user")
@Getter
@Setter
@ToString
public class User {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private Long id_user;
    private Long username;
    private String password;
    private String full_name;
    private String email;
    private int phone_number;
    private String profile_image;







}

