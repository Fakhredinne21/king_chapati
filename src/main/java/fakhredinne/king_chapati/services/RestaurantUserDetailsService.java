package fakhredinne.king_chapati.services;


import fakhredinne.king_chapati.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RestaurantUserDetailsService  implements UserDetailsService {
    private  RestaurantService restaurantService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Restaurant restaurant =restaurantService.findByUsername(username);
        if(restaurant==null){
            throw new UsernameNotFoundException("User 404");
        }
        return User.builder()
                .username(restaurant.getUsername())
                .password(restaurant.getPassword())
                .roles(restaurant.getRole().name())
                .build();
    }
}
