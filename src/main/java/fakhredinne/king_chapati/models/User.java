package fakhredinne.king_chapati.models;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@MappedSuperclass

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class  User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String username;

    private String password;
    private String firstname;
    private String lastname;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private int phone_number;
    private String profile_image;
    private LocalDateTime createdAt;
    private Role role;
 









}

