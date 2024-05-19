package fakhredinne.king_chapati.services;

import fakhredinne.king_chapati.models.Customer;
import fakhredinne.king_chapati.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public void save(Customer user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    public Customer findByEmailAndPassword(String email,String password) {
        passwordEncoder.encode(password);
        return userRepository.findByEmailAndPassword(email,password);
    }

    public Customer findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
