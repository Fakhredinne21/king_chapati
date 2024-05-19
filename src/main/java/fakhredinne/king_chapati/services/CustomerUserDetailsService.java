package fakhredinne.king_chapati.services;

import fakhredinne.king_chapati.models.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service

public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    private  CustomerService customerService;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer =customerService.findByUsername(username);
        if(customer==null){
            throw new UsernameNotFoundException("User 404");
        }
        return User.builder()
                .username(customer.getUsername())
                .password(customer.getPassword())
                .roles(customer.getRole().name())
                .build();
    }
}
