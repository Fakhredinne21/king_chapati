package fakhredinne.king_chapati.config;

import fakhredinne.king_chapati.models.Admin;
import fakhredinne.king_chapati.models.Role;
import fakhredinne.king_chapati.models.User;
import fakhredinne.king_chapati.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthenticationService {
    private final AdminRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    public AuthenticationResponse register(RegisterRequest request) {
        Admin user= (Admin) Admin.builder().firstname(request.getFirstname()).lastname(request.getLastname()).email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).role(Role.User).build();
        repository.save(user);
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
        );
        UserDetails user = (UserDetails) repository.findAdminByEmail(request.getEmail()) .orElseThrow(() -> new UserNotFoundException("Admin user not found"));;
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();


    }
}
