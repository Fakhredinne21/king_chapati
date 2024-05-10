package fakhredinne.king_chapati.models;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@MappedSuperclass
//@Table( name = "user")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Long idUser;
    @Column(
            nullable = false,
            length = 35

    )
    private String username;
    @Column(
            nullable = false
    )
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
    @Column(
            updatable = false,nullable = false
    )
    private LocalDateTime createdAt;
    private Role role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }







}

