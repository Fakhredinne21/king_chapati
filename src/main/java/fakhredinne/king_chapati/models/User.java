package fakhredinne.king_chapati.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
//@Table( name = "user")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Column(
            nullable = false,
            length = 35

    )
    private String username;
    @Column(
            nullable = false
    )
    private String password;
    private String full_name;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private int phone_number;
    private String profile_image;
    @Column(
            updatable = false,nullable = false
    )
    private LocalDateTime createdAt;





}

