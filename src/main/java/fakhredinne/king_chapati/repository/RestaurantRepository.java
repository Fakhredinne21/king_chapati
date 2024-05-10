package fakhredinne.king_chapati.repository;

import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository  extends JpaRepository<Restaurant, Long> {

   Restaurant findRestaurantsByIdUser(Long id);
   // List<Restaurant> getRestaurantsByLocation(String location);
    Restaurant findRestaurantByUsername(String username);

}
