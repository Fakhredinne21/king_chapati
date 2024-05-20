package fakhredinne.king_chapati.services;


import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.models.Restaurant;
import fakhredinne.king_chapati.repository.MealRepository;
import fakhredinne.king_chapati.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MealRepository mealRepository;
    public Restaurant findRestaurant(Long id){
        return restaurantRepository.findRestaurantsByIdUser(id);

    }
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }
 /*   public List<Restaurant> findByLocation(String Location){
        return restaurantRepository.getRestaurantsByLocation(Location);
    }*/
    public void save(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public List<Meal>getMeal(String username){
        Restaurant restaurant = findByUsername(username);
        return mealRepository.getByRestaurant(findRestaurant(restaurant.getIdUser()));
    }

    public void deleteMeal(Meal meal){
        mealRepository.delete(meal);

    }
    public Restaurant findByUsername(String username) {
        return restaurantRepository.findByUsername(username);
    }
}
